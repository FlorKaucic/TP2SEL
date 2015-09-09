package tp2sel;

public class MatrizMath {
	private static final double errTol = 0.00001;
	double [][] mat = null;
	int dimF = 0;
	int dimC = 0;
	
	public MatrizMath(int f, int c)
	{
		dimF=f;
		dimC=c;
		this.mat = new double [f][c];		
	}
	
	public MatrizMath()
	{
		this.dimF=0;
		this.dimC=0;
		this.mat = null;
	}
	
	public MatrizMath sumar (MatrizMath obj) throws DistDimException
	{
		if(this.dimF != obj.dimF || this.dimC != obj.dimC)
			throw new DistDimException(" Distinta Dimension ");
		MatrizMath aux = new MatrizMath(this.dimF,this.dimC);
		for(int i=0;i<dimF;i++)
			for(int j=0;j<dimC;j++)
				aux.mat[i][j] = this.mat[i][j] + obj.mat[i][j];
		return aux;
	}
	
	public MatrizMath restar (MatrizMath obj) throws DistDimException
	{
		if(this.dimF != obj.dimF || this.dimC != obj.dimC)
			throw new DistDimException(" Distinta Dimension ");
		MatrizMath aux = new MatrizMath(this.dimF,this.dimC);
		for(int i=0;i<dimF;i++)
			for(int j=0;j<dimC;j++)
				aux.mat[i][j] = this.mat[i][j] - obj.mat[i][j];
		return aux;
	}
	
	public MatrizMath multiplicar (MatrizMath obj) throws DistDimException
	{
		if(this.dimC != obj.dimF)
			throw new DistDimException(" Distinta Dimension ");
		MatrizMath aux = new MatrizMath (this.dimF, obj.dimC);
		for(int i=0;i<this.dimF;i++)
			for(int j=0;j<obj.dimC;j++)
				for(int k=0;k<this.dimC;k++) //podria haber usado obj.dimF en lugar de this.dimC
					aux.mat[i][j]+= this.mat[i][k] * obj.mat[k][j];	
		return aux;
	}
	
	public VectorMath multiplicar (VectorMath obj) throws DistDimException
	{ //M x V = V
		if(this.dimC != obj.dim)
			throw new DistDimException (" Distinta Dimension ");
		VectorMath aux = new VectorMath (this.dimF);
		for(int i=0;i<this.dimF;i++)
			for(int j=0;j<this.dimC;j++)
				aux.vec[i]+=this.mat[i][j]*obj.vec[j];
		return aux;
	}
	
	public MatrizMath multiplicar (double real)
	{
		MatrizMath aux = new MatrizMath(this.dimF,this.dimC);
		for(int i=0;i<this.dimF;i++)
			for(int j=0;j<this.dimC;j++)
				aux.mat[i][j]+= this.mat[i][j] * real;
		return aux;
	}
	
	public double normaUno()
	{
		double norma1=0;
		for(int i=0;i<this.dimF;i++)
			for(int j=0;j<this.dimC;j++)
				norma1+= this.mat[i][j]>0?this.mat[i][j]:-this.mat[i][j];
		return norma1;
	}
	
	public double normaDos()
	{
		double norma2=0;
		for(int i=0;i<this.dimF;i++)
			for(int j=0;j<this.dimC;j++)
				norma2+= this.mat[i][j]*this.mat[i][j];
		return Math.sqrt(norma2);
	}
	
	public double normaInfinito()
	{
		double aux, normaInf = 0;
		for(int i=0;i<this.dimF;i++)
			for(int j=0;j<this.dimC;j++)
			{	
				aux = this.mat[i][j]>0?this.mat[i][j]:-this.mat[i][j];
				normaInf = normaInf>aux?normaInf:aux;
			}
	}
	public boolean equals (MatrizMath obj)
	{
		// podria haber creado una matriz auxiliar, pero si necesito ||A-A'||2 <E, entonces
		// al ser la norma, estaria haciendo la raiz cuadrada de la diferencia de los Aij de ambas matrices
		double normaDif = 0;
		for(int i=0;i<this.dimF;i++)
			for(int j=0;j<this.dimC;j++)
				normaDif+= (this.mat[i][j] - obj.mat[i][j])*(this.mat[i][j] - obj.mat[i][j]);
		return Math.sqrt(normaDif)<errTol; //si la norma es mas chica que el error tolerado, son "iguales"
	}
}
