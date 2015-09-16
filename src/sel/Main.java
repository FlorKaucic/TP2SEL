package sel;

import java.util.GregorianCalendar;
import java.io.File;
import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Calendar tTotIni = new GregorianCalendar();
		Calendar tIni, tFin;
		
		File folder = new File("Entrada");
		File[] listOfFiles = folder.listFiles();
		int cant = listOfFiles.length;
		FileWorker fw = new FileWorker();
		
		for(int i=0; i<cant; i++){
			if (listOfFiles[i].isFile()) {
				String path = new String("Entrada/"+listOfFiles[i].getName());
				fw.leerArchivo(path);
				SEL sel = new SEL(fw.getMatriz(), fw.getVector());
				//sel.resolver();
				sel.mostrarResultado();
			}
		}
		
		
		
		// aca va el codigo que llame a las funciones
		
		Calendar tTotFin = new GregorianCalendar();
		long diff = tTotFin.getTimeInMillis() - tTotIni.getTimeInMillis();
		System.out.println("Tiempo total: " +diff);
	
	}
	
}
