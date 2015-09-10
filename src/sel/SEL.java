package sel;

public class SEL {
	
	MatrizMath a;
	VectorMath b;

	public SEL(MatrizMath a, VectorMath b) {
		this.a = a;
		this.b = b;
	}
	
	public static boolean test(){
		// Cambiar return
		return true;
	}

	public void resolver() {
//		GaussJordan.gaussJordan(a, b);
		
		System.out.println("Matriz"+a);
	}

	public double calcularErrorSolucion(){
		// Cambiar return
		return 1;
	}
	
	public void mostrarResultado() {
		System.out.println("Resultado: " + b);
	}

}
