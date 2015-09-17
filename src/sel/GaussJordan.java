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
				}
			else {
				for (j = i; j < m1.getDimF(); j++) {
					if(m1.getValue(j, i)!=0){
						k = 1 / m1.getValue(j, i);
						m1.multiplicarFila(j, k);
						vec.setValue(j, vec.getValue(j) * k);
					}
				}
				for (j = 0; j < m1.getDimF(); j++) {
					m1.restarFilas(i, j, vec);
				}
			}
			i++;
		}
		return a;
	}
	
	
	public static double[] gauss(MatrizMath a, VectorMath v) {
	    int n = a.getDimC();

	    for (int i=0; i<n; i++) {
	        // Search for maximum in this column
	        double maxEl = Math.abs(a.getValue(i, i));
	        int maxRow = i;
	        for(int k=i+1; k<n; k++) {
	            if (Math.abs(a.getValue(k, i)) > maxEl) {
	                maxEl = Math.abs(a.getValue(k, i));
	                maxRow = k;
	            }
	        }

	        // Swap maximum row with current row (column by column)
	        for (int k=i; k<n; k++) {
	            double tmp = a.getValue(maxRow,k);
	            a.setValue(maxRow,k,a.getValue(i,k));
	            a.setValue(i,k,tmp);
	        }
	        double tmp = v.getValue(maxRow);
	        v.setValue(maxRow, v.getValue(i));
	        v.setValue(i, tmp);

	        // Make all rows below this one 0 in current column
	        for(int k=i+1; k<n; k++) {
	            double c = -a.getValue(k, i)/a.getValue(i,i);
	            for(int j=i; j<n; j++) {
	                if (i==j) {
	                    a.setValue(k,j,0);
	                } else {
	                    a.setValue(k, j, a.getValue(k,j)+(c*a.getValue(i, j)));
	                }
	            }
	            v.setValue(k, v.getValue(k)+(c*v.getValue(i)));
	        }
	    }

	    // Solve equation Ax=b for an upper triangular matrix A
	    double[] x = new double[n];
	    for (int i=n-1; i>-1; i--) {
	        x[i] = v.getValue(i)/a.getValue(i, i);
	        for (int k=i-1; k>-1; k--) {
	            v.setValue(k,v.getValue(k)-a.getValue(k,i) * x[i]);
	        }
	    }
	    return x;
	}
}