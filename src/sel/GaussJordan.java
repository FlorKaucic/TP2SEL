package sel;

public class GaussJordan {

	public static int seguir(MatrizMath m) {
		int i;
		for (i = 0; i < m.getMat().length; i++)
			if (m.verSiFilaCero(i, m.getErrTol()) == true || m.verSiColCero(i, m.getErrTol()) == true)
				return 0;

		return 1;
	}

	public static int gaussJordan(MatrizMath m1, VectorMath vec) {
		int a = 1, f, i = 0, j;
		double k;

		while (!m1.esIdentidad() && (a = seguir(m1)) != 0) {
			if (i == m1.getMat().length)
				i = 0;

			if (Math.abs(m1.getValue(i, i)) < m1.getErrTol())
				if (m1.verSiFilaCero(i, m1.getErrTol()))
					return 0;
				else {
					f = m1.buscarFila(i, m1.getErrTol());
					if (f >= 0) {
						m1.sumarFilas(i, f);
						vec.setValue(i, vec.getValue(i) + vec.getValue(f));
					}
				}
			else {
				for (j = i; j < m1.getMat().length; j++) {
					k = 1 / m1.getValue(j, i);
					m1.multiplicarFila(j, k);
					vec.setValue(j, vec.getValue(j) * k);
				}
				for (j = 0; j < m1.getMat().length; j++) {
					m1.restarFilas(i, j, vec, m1.getErrTol());
				}
			}

			i++;
		}
		return a;
	}
}