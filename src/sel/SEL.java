package sel;

import java.util.Vector;

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

	public void resolver(MatrizMath m, VectorMath v) {
		
	}

	public double calcularErrorSolucion(){
		// Cambiar return
		return 1;
	}
	
	public void mostrarResultado() {
		System.out.println("Resultado: " + b);
	}

}
