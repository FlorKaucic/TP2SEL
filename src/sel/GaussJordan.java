package sel;

import org.omg.CORBA.VersionSpecHelper;

public class GaussJordan {
	
	public int seguir(MatrizMath m){
		int i;
		for(i=0; i<m.getMat().length; i++)
			if(verSiFilaCero(m, i, m.getErrTol())==true);
				return 0;
		
		for(i=0; i<m.getMat().length;i++)
			if(verSiColCero(m, i, m.getErrTol())==true);
				return 0;
		return 1;
		
	}
	
	public int gaussJordan(MatrizMath m1, MatrizMath m2) {
		int a, f, i = 0;
		double k;

		// cuando el pivot es 0, verificar toda la fila si es 0
		// si la fila no es 0, buscar una fila que sumarle.

		while (!esIdentidad(m1) && (a = seguir(m1) != 0)) {
			if (i == m1.getMat().length)
				i = 0;
		
				if (Math.abs(m1.getValue(i,i)) < m1.getErrTol())
					if (verSiFilaCero(m1, i, m1.getErrTol()))
						return 0;
					else {
						f = buscarFila(m1, i, m1.getErrTol());
						if(f>=0){
							sumarFilas(m1, i, f);
							sumarFilas(m2, i, f);
						}
					}
				else {
					k = 1 / m1.getValue(i,i);
					multiplicarFila(m1, i, k);
					multiplicarFila(m2, i, k);
					for (int j = 0; j < m1.getMat().length; j++) {
						restarFilas(m1, i, j, m1.getErrTol());
						restarFilas(m2, i, j, m1.getErrTol());
					}
				}
			i++;
		}
		return a;
	}
}