package sel;

//import java.util.GregorianCalendar;
import java.io.File;
//import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub			
		File folder = new File("Entrada");
		File[] listOfFiles = folder.listFiles();
		int cant = listOfFiles.length;
		FileWorker fw = new FileWorker();
		
		for(int i=0; i<cant; i++){
			if (listOfFiles[i].isFile()) {
				String name = new String(listOfFiles[i].getName());
				fw.leerArchivo("Entrada/"+name);
				
				System.out.println();
				
				System.out.println("Matriz:"+fw.getMatriz()+"\nVector:"+fw.getVector());
				
				// Inicio del calendar //Con long da 0
//				Calendar tIni = new GregorianCalendar();
				long tIni = System.currentTimeMillis();
				
				//SEL
				SEL sel = new SEL(fw.getMatriz(), fw.getVector());
				sel.resolver();
				sel.mostrarResultado();
				sel.test();
				
				//Fin del calendar //Con long da 0
//				Calendar tFin = new GregorianCalendar();
//				long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
//				System.out.println("Tiempo de resolucion para el archivo "+name+": " +diff);
				long tFin = System.currentTimeMillis();
				System.out.println("Tiempo de resolucion para el archivo "+name+": " +(tFin-tIni));
			}
		}		
	}
}
