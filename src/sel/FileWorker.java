package sel;

import java.io.*;

public class FileWorker {
	public VectorMath leerArchivoVec(String ruta) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		VectorMath vec = null;
		try {
			String linea;
			archivo = new File(ruta);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			int tamVec = 0;
			if ((linea = br.readLine()) != null)
				tamVec = Integer.parseInt(linea);
			double[] v = new double[tamVec];
			for (int i = 0; i < tamVec; i++) {
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
		return vec;
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

	public MatrizMath leerArchivoMat(String ruta) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		MatrizMath mat = null;
		try {
			String[] data;
			String linea;
			archivo = new File(ruta);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			int f = 0, c = 0;
			if ((linea = br.readLine()) != null) {
				data = linea.split(" ");
				f = Integer.parseInt(data[0]);
				c = Integer.parseInt(data[1]);
			}
			double[][] m = new double[f][c];
			while ((linea = br.readLine()) != null) {
				data = linea.split(" ");
				m[Integer.parseInt(data[0])][Integer.parseInt(data[1])] = Double.parseDouble(data[2]);
			}
			mat = new MatrizMath(m);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null)
					fr.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return mat;
	}

	public boolean escribirArchivoMat(MatrizMath obj, String ruta) {
		FileWriter fw = null;
		PrintWriter pw = null;

		try {
			fw = new FileWriter(ruta);
			pw = new PrintWriter(fw);

			pw.println(obj.getDimF() + " " + obj.getDimC()); // mismo formato que el .in
			for (int i = 0; i < obj.getDimF(); i++)
				for (int j = 0; j < obj.getDimC(); j++) {
					pw.println(i + " " + j + " " + obj.getValue(i,j));
				}
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
