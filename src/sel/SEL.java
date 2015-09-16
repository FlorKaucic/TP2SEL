package sel;

public class SEL {

	MatrizMath matriz1; // A
	VectorMath vect1; // X
	VectorMath vect2; // B 

	public SEL(MatrizMath a, VectorMath b) {
		this.matriz1 = a;
		this.vect1 = b;
		this.vect2 = vect1.clone();
	}

	public boolean test() { 
		//Cambiar return
		// AX = B
		VectorMath vectorObtenido = this.vect1.multiplicar(this.matriz1);
		
		return vectorObtenido.equals(this.vect2);
	}

	public void resolver() {
		GaussJordan.gaussJordan(matriz1.clone(), vect1);
	}

	public double calcularErrorSolucion() {
		// Cambiar return
		return 1;
	}

	public void mostrarResultado() {
		System.out.println("Resultado: " + vect1);
	}
}
