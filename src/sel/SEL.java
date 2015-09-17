package sel;

public class SEL {

	MatrizMath matriz1; // A
	VectorMath vect1; // X
	VectorMath vect2; // B 
	// A * X = B
	// matriz1 * vect1 = vect2

	public SEL(int tam) {
		this.matriz1 = new MatrizMath(tam,tam);
		this.vect2 = new VectorMath(tam);
	}
	
	public boolean test() {
		// AX = B
		VectorMath vectorObtenido = this.vect1.multiplicar(this.matriz1);
		return vectorObtenido.equals(this.vect2);
	}

	public void resolver() {
		vect1 = GaussJordan.gauss(matriz1.clone(), vect2.clone());
	}

	public double calcularErrorSolucion() {
		VectorMath vectorObtenido = this.vect1.multiplicar(this.matriz1);
		return vectorObtenido.restar(this.vect2).normaDos();
	}

	public void mostrarResultado() {
		System.out.println("Vector resultado: " + vect1);
	}
	
	public VectorMath getResultado(){
		return vect1;
	}
	
	public MatrizMath getMatriz(){
		return this.matriz1;
	}
	
	public VectorMath getVector(){
		return this.vect2;
	}
}
