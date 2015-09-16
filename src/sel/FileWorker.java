package sel;

import java.io.*;

public class FileWorker {
	MatrizMath mat;
	VectorMath vec;

	public MatrizMath getMatriz() {
		return mat;
	}

	public VectorMath getVector() {
		return vec;
	}

	public void leerArchivo(String ruta) {
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
			double[] v = new double[tam];
			int c = 0;
			while (c < (tam * tam) && (linea = br.readLine()) != null) {
				String[] data = linea.split(" ");
				m[Integer.parseInt(data[0])][Integer.parseInt(data[1])] = Double.parseDouble(data[2]);
				c++;
			}
			mat = new MatrizMath(m);
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

	public boolean escribirArchivo(VectorMath obj, String ruta) {
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
