package sel;

import java.io.*;

public class FileWorker {
	
	public SEL leerArchivo(String ruta) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		SEL sel = null;
		try {
			String linea;
			archivo = new File(ruta);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			int tam = 0;
			if ((linea = br.readLine()) != null)
				tam = Integer.parseInt(linea);
			sel = new SEL(tam);
			int c = 0;
			while (c < (tam * tam) && (linea = br.readLine()) != null) {
				String[] data = linea.split(" ");
				sel.getMatriz().setValue(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Double.parseDouble(data[2]));
				c++;
			}
			
			for (int i = 0; i < tam; i++) {
				linea = br.readLine();
				sel.getVector().setValue(i, Double.parseDouble(linea));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sel;
	}

	public boolean escribirArchivo(VectorMath obj, double error, String ruta) {
		FileWriter fw = null;
		PrintWriter pw = null;

		try {
			fw = new FileWriter(ruta);
			pw = new PrintWriter(fw);
			pw.println(obj.dim);
			for (int i = 0; i < obj.dim; i++)
				pw.println(obj.vec[i]);
			pw.println();
			pw.println(error);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (fw != null)
					fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return true;
	}

}
