package sel;

public class GaussJordan {
	public static VectorMath gauss(MatrizMath mat, VectorMath vec) {
	    int n = mat.getDimC();
	    // i va a determinar la posicion de la diagonal principal a partir de la cual evaluo
	    for (int i=0; i<n; i++) {
	        // Encontrar el valor mas grande en la columna i, a partir de la fila i
	    	// Establezco que el primer valor es el mas grande
	        double valorMax = Math.abs(mat.getValue(i, i));
	        int filaMax = i;
	        // Busco si algun valor supera al valorMax
	        for(int k=i+1; k<n; k++) {
	            if (Math.abs(mat.getValue(k, i)) > valorMax) {
	            	// Si es mas grande, lo reemplazo
	                valorMax = Math.abs(mat.getValue(k, i));
	                filaMax = k;
	            }
	        }

	        // Intercambiar la fila con el maximo valor con la fila actual
	        for (int k=i; k<n; k++) {
	            double tmp = mat.getValue(filaMax,k);
	            mat.setValue(filaMax,k,mat.getValue(i,k));
	            mat.setValue(i,k,tmp);
	        }
	        // Intercambio tambien las posiciones del vector
	        double tmp = vec.getValue(filaMax);
	        vec.setValue(filaMax, vec.getValue(i));
	        vec.setValue(i, tmp);

	        // Hago que todas las demas filas tengan 0 en esta columna
	        for(int k=i+1; k<n; k++) { 
	            double c = -mat.getValue(k, i)/mat.getValue(i,i);
	            for(int j=i; j<n; j++) {
	                if (i==j) {
	                    mat.setValue(k,j,0);
	                } else {
	                    mat.setValue(k, j, mat.getValue(k,j)+(c*mat.getValue(i, j)));
	                }
	            }
	            vec.setValue(k, vec.getValue(k)+(c*vec.getValue(i)));
	        }
	    }

	    // Resuelvo el SEL arrastrando el valor de las incognitas encontradas en orden inverso
	    // (matriz triangular superior)
	    VectorMath x = new VectorMath(n);
	    for (int i=n-1; i>-1; i--) {
	        x.setValue(i, vec.getValue(i)/mat.getValue(i, i));
	        for (int k=i-1; k>-1; k--) {
	            vec.setValue(k,vec.getValue(k)-mat.getValue(k,i) * x.getValue(i));
	        }
	    }
	    // Devuelvo el VectorMath resultado
	    return x;
	}
}