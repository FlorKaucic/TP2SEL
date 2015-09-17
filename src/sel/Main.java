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
		System.out.println(cant);
		FileWorker fw = new FileWorker();
		folder = new File("Salida");
		folder.mkdir();
		
		for(int i=0; i<cant; i++){
			if (listOfFiles[i].isFile()) {
				String name = new String(listOfFiles[i].getName());
				
				SEL sel = new SEL();
				fw.leerArchivo(sel.getMatriz(),sel.getVector(),"Entrada/"+name);
				System.out.println("Matriz:"+sel.getMatriz()+"\nVector:"+sel.getVector());
				System.out.println("Llego a esto");
				
				
				System.out.println("\n"+name);

				
				// Inicio del calendar //Con long da 0
//				Calendar tIni = new GregorianCalendar();
				long tIni = System.currentTimeMillis();
				
				sel.resolver();
				sel.mostrarResultado();
				System.out.println("Resultado del test: "+(sel.test()?"Correcto":"Incorrecto"));
				double error = sel.calcularErrorSolucion();
				System.out.println("Error: "+error);
				//Fin del calendar //Con long da 0
//				Calendar tFin = new GregorianCalendar();
//				long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
//				System.out.println("Tiempo de resolucion para el archivo "+name+": " +diff);
				long tFin = System.currentTimeMillis();
				System.out.println("Tiempo de resolucion para el archivo "+name+": " +(tFin-tIni));
				
				fw.escribirArchivo(sel.getResultado(), error, "Salida/"+name.substring(0, name.length()-2)+"out");
			}
		}		
	}
}
