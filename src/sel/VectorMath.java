package sel;

public class VectorMath {
	private static final double errTol = 1.0E-15;
	double[] vec = null;
	int dim;

	public VectorMath(int dimension) {
		this.dim = dimension;
		this.vec = new double[dimension];
	}

	public VectorMath() {
		this.dim = 0;
		this.vec = null;
	}

	//ELIMINAR
	public VectorMath(double[] v) {
		// Constructor para hardcodear vector
		this.dim = v.length;
		this.vec = new double[this.dim];
		for (int i = 0; i < this.dim; i++) {
			this.vec[i] = v[i];
		}
	}

	public int getDim() {
		return this.dim;
	}

	public double[] getVec() {
		return this.vec;
	}

	public double getValue(int i) {
		return this.vec[i];
	}

	public void setValue(int i, double value) {
		this.vec[i] = value;
	}

	public VectorMath sumar(VectorMath obj) throws DistDimException {
		if (this.dim != obj.dim)
			throw new DistDimException(" Distinta Dimension ");

		VectorMath aux = new VectorMath(this.dim);

		for (int i = 0; i < this.dim; i++)
			aux.vec[i] += this.vec[i] + obj.vec[i];
		return aux;
	}

	public VectorMath restar(VectorMath obj) throws DistDimException {
		if (this.dim != obj.dim)
			throw new DistDimException(" Distinta Dimension ");

		VectorMath aux = new VectorMath(this.dim);

		for (int i = 0; i < this.dim; i++)
			aux.vec[i] += this.vec[i] - obj.vec[i];
		return aux;
	}

	public double multiplicar(VectorMath obj) throws DistDimException {
		if (this.dim != obj.dim)
			throw new DistDimException(" Distinta Dimension ");
		double aux = 0;
		for (int i = 0; i < this.dim; i++)
			aux += this.vec[i] * obj.vec[i];
		return aux;
	}

	public VectorMath multiplicar(MatrizMath obj) throws DistDimException {
		// V x M = V
		if (this.dim != obj.getDimF())
			throw new DistDimException(" Distinta Dimension ");
		VectorMath aux = new VectorMath(obj.getDimC());
		for (int i = 0; i < obj.getDimC(); i++)
			for (int j = 0; j < this.dim; j++)
				aux.vec[i] += this.vec[j] * obj.getValue(i, j);
		return aux;
	}

	public VectorMath multiplicar(double real) {
		VectorMath aux = new VectorMath(this.dim);
		for (int i = 0; i < this.dim; i++)
			aux.vec[i] = this.vec[i] * real;
		return aux;
	}

	public double normaUno() {
		double norma1 = 0;
		for (int i = 0; i < this.dim; i++)
			norma1 += (this.vec[i] >= 0 ? this.vec[i] : -this.vec[i]);
		return norma1;
	}

	public double normaDos() {
		double norma2 = 0;
		for (int i = 0; i < this.dim; i++)
			norma2 += this.vec[i] * this.vec[i];
		return norma2;
	}

	public double normaInfinito() {
		double normaInf = 0;
		double aux;
		for (int i = 0; i < this.dim; i++) {
			aux = this.vec[i] >= 0 ? this.vec[i] : -this.vec[i];
			normaInf = aux >= normaInf ? aux : normaInf;
		}
		return normaInf;
	}

	public boolean equals(VectorMath obj) throws DistDimException {
		if (this.dim != obj.dim)
			throw new DistDimException(" Distinta Dimension ");
		return this.restar(obj).normaDos() < errTol;
	}

	public VectorMath clone() {
		VectorMath aux = new VectorMath(this.dim);
		for (int i = 0; i < this.dim; i++)
			aux.vec[i] = this.vec[i];
		return aux;
	}

	@Override
	public String toString() {
		StringBuffer cadena = new StringBuffer();
		for (int i = 0; i < this.dim; i++) {
			cadena.append("\n" + this.vec[i]);
		}
		return cadena.toString();
	}

}