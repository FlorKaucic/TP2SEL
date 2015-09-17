package generador;

import java.util.Random;

import java.io.*;

public class Generador {

	public static void main(String[] args) {

		FileWriter fw = null;
		PrintWriter pw = null;
		double desvio = 25;
		int cant = 5000;
		Random randomDouble = new Random();
		int i, j;

		try {
			File folder = new File("Entrada");
			File[] listOfFiles = folder.listFiles();
			int max = 0, nue;			
			for(int k=0; k<listOfFiles.length; k++){
				if (listOfFiles[k].isFile()) {
					if((nue=Integer.parseInt(listOfFiles[k].getName().substring(0,2)))>max)
						max = nue;
				}
			}
			max++;
			fw = new FileWriter("Entrada/"+(max>=10?max:"0"+max)+"_CasoN"+cant+".in");
			pw = new PrintWriter(fw);
			pw.println(cant);

			for (i = 0; i < cant; i++)
				for (j = 0; j < cant; j++)
					pw.println(i + " " + j + " " + (randomDouble.nextDouble() * desvio - 10));

			pw.print(randomDouble.nextDouble() * desvio);
			for (i = 0; i < cant-1; i++)
				pw.print("\n"+randomDouble.nextDouble() * desvio);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null)
					fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
