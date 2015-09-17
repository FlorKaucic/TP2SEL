package sel;

public class SEL {

	MatrizMath matriz1; // A
	VectorMath vect1; // X
	VectorMath vect2; // B 
	// A * X = B
	// matriz1 * vect1 = vect2

	public SEL() {
		this.matriz1 = new MatrizMath();
		this.vect1 = new VectorMath();
	}
	
	public SEL(MatrizMath a, VectorMath b) {
		this.matriz1 = a;
		this.vect2 = b;
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
		System.out.println("Resultado: " + vect1);
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
