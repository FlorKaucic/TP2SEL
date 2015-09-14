package sel;

public class GaussJordan {

	// Tiene sysos por todos lados para ver paso a paso que hacía para detectar
	// los errores
	public static boolean esIdentidad(MatrizMath m1) {
		MatrizMath id = new MatrizMath(m1.getDimF(), m1.getDimC()), aux;

		for (int i = 0; i < m1.getMat().length; i++)
			id.setValue(i, i, 1);
		aux = m1.restar(id);
		if (aux.normaDos() < m1.getErrTol())
			return true;

		return false;
	}

	public static int gaussJordan(MatrizMath m1, MatrizMath m2) {
		int a, f, i = 0;
		double k;

		// cuando el pivot es 0, verificar toda la fila si es 0
		// si la fila no es 0, buscar una fila que sumarle.

		while (!esIdentidad(m1) && (a = seguir(m1) != 0)) {
			if (i == m1.getMat().length)
				i = 0;
			//for (int y = 0; y < m1.getMat().length; y++) {
				if (m1.getMat()[i][i] < m1.getErrTol())
					if (verSiFilaCero(m1, i, m1.getErrTol()))
						return 0;
					else {
						f = buscarFila(m1, i, m1.getErrTol());
						if(f>0){
							sumarFilas(m1, i, f);
							sumarFilas(m2, i, f);
						}
					}
				else {
					k = 1 / m1.getMat()[i][i];
					multiplicarFila(m1, i, k);
					multiplicarFila(m2, i, k);
					for (int j = 0; j < m1.getMat().length; j++) {
						restarFilas(m1, i, j);
						restarFilas(m2, i, j);
					}
				}

			//}
		}
		return a;
	}
}