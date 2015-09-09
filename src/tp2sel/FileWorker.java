package tp2sel;

import java.io.*;

public class FileWorker {
	public VectorMath leerArchivoVec (String ruta){
	File archivo = null;
	FileReader fr = null;
	BufferedReader br = null;
	VectorMath vec = new VectorMath();
	int tamVec = 0;
	try {
		String linea;
		archivo = new File (ruta);
		fr = new FileReader(archivo);
		br = new BufferedReader(fr);
		
		if((linea=br.readLine())!=null)
			tamVec = Integer.parseInt(linea);
		vec.vec = new double[tamVec];
		for(int i=0;i<tamVec;i++)
		{
			linea = br.readLine();
			vec.vec[i] = Double.parseDouble(linea);
		}	
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally
	{
		try {
			if(fr!=null)
				fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	return vec;
	}
	public boolean escribirArchivoVec(VectorMath obj,String ruta){
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter(ruta);
			pw = new PrintWriter(fw);
			pw.println(obj.dim);
			for(int i=0;i<obj.dim;i++)
				pw.println(obj.vec[i]);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally
		{
				try {
					if(fw!=null)
						fw.close();	
				} catch (Exception e2) {
					e2.printStackTrace();
				}
		}
		return true;
}


	public MatrizMath leerArchivoMat(String ruta){
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		MatrizMath mat =  new MatrizMath();
		
		try {
			String[] data;
			String linea;
			archivo = new File (ruta);
			fr = new FileReader (archivo);
			br = new BufferedReader (fr);
			int f=0,c=0;
			if((linea=br.readLine())!=null)
			{
				data = linea.split(" ");
				f = Integer.parseInt(data[0]);
				c = Integer.parseInt(data[1]);
			}
			mat.mat = new double[f][c]; //podria haber creado un objeto nuevo con f y c, pero me parecio mejor esto
			//es discutible porque, si cambiara el tipo de dato en la clase, esto tendria que cambiarlo tambien
			while((linea = br.readLine())!=null)
			{
				data = linea.split(" ");
				mat.mat[Integer.parseInt(data[0])][Integer.parseInt(data[1])] = Double.parseDouble(data[2]);
			}	// si uso 2 ciclos for desperdicio los indices que me da el archivo, no se que sea mejor en este punto
			// si usar los indices, o usar i y j del ciclo for.	
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				if(fr!=null)
					fr.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return mat;
	}
	
	public boolean escribirArchivoMat (MatrizMath obj, String ruta)
	{
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter (ruta);
			pw = new PrintWriter (fw);
			
			pw.println(obj.dimF + " " + obj.dimC); //mismo formato que el .in
			for(int i=0;i<obj.dimF;i++)
				for(int j=0;j<obj.dimC;j++)
				{
					pw.println(i + " " + j + " " + obj.mat[i][j]);
				}	
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally
		{
			try {
				if(fw!=null)
					fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return true;
	}
}

