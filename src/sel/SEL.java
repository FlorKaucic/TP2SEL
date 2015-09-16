package sel;

public class SEL {
	
	MatrizMath matriz1;
	VectorMath vect1;

	public SEL(MatrizMath a, VectorMath b) {
		this.matriz1 = a;
		this.vect1 = b;
	}
	
	public static boolean test(){
		// Cambiar return
		return true;
	}

	public void resolver() {
		GaussJordan.gaussJordan(matriz1, vect1);
	}

	public double calcularErrorSolucion(){
		// Cambiar return
		return 1;
	}
	
	public void mostrarResultado() {
		System.out.println("Resultado: " + vect1);
	}

}
