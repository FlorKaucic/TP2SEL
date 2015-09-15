package sel;

public class GaussJordan {
	
	public int seguir(MatrizMath m){
		int i;
		for(i=0; i<m.getMat().length; i++)
			if(m.verSiFilaCero(i, m.getErrTol())==true || m.verSiColCero(i, m.getErrTol())==true)
				return 0;
			
		return 1;
		
	}
	
	public int gaussJordan(MatrizMath m1, MatrizMath m2) {
		int a=1, f, i = 0;
		double k;

		// cuando el pivot es 0, verificar toda la fila si es 0
		// si la fila no es 0, buscar una fila que sumarle.

		while (!m1.esIdentidad() && (a = seguir(m1)) != 0) {
			if (i == m1.getMat().length)
				i = 0;
		
				if (Math.abs(m1.getValue(i,i)) < m1.getErrTol())
					if (m1.verSiFilaCero(i, m1.getErrTol()))
						return 0;
					else {
						f = m1.buscarFila(i, m1.getErrTol());
						if(f>=0){
							m1.sumarFilas(i, f);
							m2.sumarFilas(i, f);
						}
					}
				else {
					k = 1 / m1.getValue(i,i);
					m1.multiplicarFila(i, k);
					m2.multiplicarFila(i, k);
					for (int j = 0; j < m1.getMat().length; j++) {
						m1.restarFilas(i, j, m1.getErrTol());
						m2.restarFilas(i, j, m1.getErrTol());
					}
				}
			i++;
		}
		return a;
	}
}