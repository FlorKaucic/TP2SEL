package sel;

public class GaussJordan {

	public static int seguir(MatrizMath m) {
		int i;
		for (i = 0; i < m.getDimF(); i++)
			if (m.verSiFilaCero(i) == true || m.verSiColCero(i) == true)
				return 0;

		return 1;
	}

	public static int gaussJordan(MatrizMath m1, VectorMath vec) {
		int a = 1, f, i = 0, j;
		double k;

		while (!m1.esIdentidad() && (a = seguir(m1)) != 0) {
			if (i == m1.getDimF())
				i = 0;

			if (Math.abs(m1.getValue(i, i)) < m1.getErrTol())
				if (m1.verSiFilaCero(i))
					return 0;
				else {
					f = m1.buscarFila(i);
					if (f >= 0) {
						m1.sumarFilas(i, f);
						vec.setValue(i, vec.getValue(i) + vec.getValue(f));
						i--;
					}
					System.out.println("\nMatriz1:"+m1);
					System.out.println("\nVec1:"+vec);
				}
			else {
				for (j = i; j < m1.getDimF(); j++) {
					if(m1.getValue(j, i)!=0){
						k = 1 / m1.getValue(j, i);
						m1.multiplicarFila(j, k);
						vec.setValue(j, vec.getValue(j) * k);
					}

					System.out.println("j: "+j);
					System.out.println("m: "+m1.getValue(j, i));
					System.out.println("k: "+(1/m1.getValue(j, i)));
					k = 1 / m1.getValue(j, i);
					m1.multiplicarFila(j, k);
					vec.setValue(j, vec.getValue(j) * k);
					System.out.println("\nMatriz2:"+m1);
					System.out.println("\nVec2:"+vec);
				}
				for (j = 0; j < m1.getDimF(); j++) {
					m1.restarFilas(i, j, vec);
					System.out.println("\nMatriz3:"+m1);
					System.out.println("\nVec3:"+vec);
				}
			}
			i++;
			System.out.println("i: "+i);
		}
		return a;
	}
}