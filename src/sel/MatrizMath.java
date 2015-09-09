package sel;

public class MatrizMath {
	
	private static final double errTol = 0.00001;
	
	double[][] mat = null;
	int dimF = 0;
	int dimC = 0;

	public MatrizMath(int f, int c) {
		dimF = f;
		dimC = c;
		this.mat = new double[f][c];
	}

	public MatrizMath() {
		this.dimF = 0;
		this.dimC = 0;
		this.mat = null;
	}

	//ELIMINAR
	public MatrizMath(double[][] m){
		// Constructor para hardcodear matriz
		this.dimF = m.length;
		this.dimC = m[0].length;
		this.mat = new double[this.dimF][this.dimC];
		for (int i = 0; i < this.dimF; i++) {
			for(int j = 0; j < this.dimC; j++){
				this.mat[i][j] = m[i][j];
			}
		}
	}
	
	public MatrizMath sumar(MatrizMath obj) throws DistDimException {
		if (this.dimF != obj.dimF || this.dimC != obj.dimC)
			throw new DistDimException(" Distinta Dimension ");
		MatrizMath aux = new MatrizMath(this.dimF, this.dimC);
		for (int i = 0; i < dimF; i++)
			for (int j = 0; j < dimC; j++)
				aux.mat[i][j] = this.mat[i][j] + obj.mat[i][j];
		return aux;
	}

	public MatrizMath restar(MatrizMath obj) throws DistDimException {
		if (this.dimF != obj.dimF || this.dimC != obj.dimC)
			throw new DistDimException(" Distinta Dimension ");
		MatrizMath aux = new MatrizMath(this.dimF, this.dimC);
		for (int i = 0; i < dimF; i++)
			for (int j = 0; j < dimC; j++)
				aux.mat[i][j] = this.mat[i][j] - obj.mat[i][j];
		return aux;
	}

	public MatrizMath multiplicar(MatrizMath obj) throws DistDimException {
		if (this.dimC != obj.dimF)
			throw new DistDimException(" Distinta Dimension ");
		MatrizMath aux = new MatrizMath(this.dimF, obj.dimC);
		for (int i = 0; i < this.dimF; i++)
			for (int j = 0; j < obj.dimC; j++)
				for (int k = 0; k < this.dimC; k++) // podria haber usado
													// obj.dimF en lugar de
													// this.dimC
					aux.mat[i][j] += this.mat[i][k] * obj.mat[k][j];
		return aux;
	}

	public VectorMath multiplicar(VectorMath obj) throws DistDimException { 
		if (this.dimC != obj.dim)
			throw new DistDimException(" Distinta Dimension ");
		VectorMath aux = new VectorMath(this.dimF);
		for (int i = 0; i < this.dimF; i++)
			for (int j = 0; j < this.dimC; j++)
				aux.vec[i] += this.mat[i][j] * obj.vec[j];
		return aux;
	}
	
	
	public MatrizMath multiplicar(double real) {
		MatrizMath aux = new MatrizMath(this.dimF, this.dimC);
		for (int i = 0; i < this.dimF; i++)
			for (int j = 0; j < this.dimC; j++)
				aux.mat[i][j] += this.mat[i][j] * real;
		return aux;
	}

	@Override
	public String toString() {
		String cadena = "";
		for (int i = 0; i < this.dimF; i++) {
			cadena += "\n";
			for (int j = 0; j < this.dimC; j++)
				cadena += (this.mat[i][j] + "\t");
		}
		return cadena;
	}

}
