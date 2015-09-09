package sel;

import java.io.*;

public class FileWorker {
	public void leerArchivoVec(String ruta, VectorMath vec, MatrizMath mat) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			String linea;
			archivo = new File(ruta);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			int tam = 0;
			if ((linea = br.readLine()) != null)
				tam = Integer.parseInt(linea);
			double[][] m = new double[tam][tam];
			while ((linea = br.readLine()) != null) {
				String[] data = linea.split(" ");
				m[Integer.parseInt(data[0])][Integer.parseInt(data[1])] = Double.parseDouble(data[2]);
			}
			mat = new MatrizMath(m);
			double[] v = new double[tam];
			for (int i = 0; i < tam; i++) {
				linea = br.readLine();
				v[i] = Double.parseDouble(linea);
			}
			vec = new VectorMath(v);
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
	}

	public boolean escribirArchivoVec(VectorMath obj, String ruta) {
		FileWriter fw = null;
		PrintWriter pw = null;

		try {
			fw = new FileWriter(ruta);
			pw = new PrintWriter(fw);
			pw.println(obj.dim);
			for (int i = 0; i < obj.dim; i++)
				pw.println(obj.vec[i]);

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
