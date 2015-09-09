package test;

import sel.VectorMath;

public class VectorMathTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Vector hardcodeado
		VectorMath vec = new VectorMath(new double[]{3,4.2,9});
		System.out.println("Vector: "+vec);

		VectorMath newvec = vec.multiplicar(0.5);
		System.out.println(vec.multiplicar(0.5));
		System.out.println("Vector: "+newvec);

	}

}
