package test;

//import sel.GaussJordan;

import sel.MatrizMath;

public class GaussJordanTest {

	public static void main(String[] args) {
		MatrizMath m = new MatrizMath(5,5);
		MatrizMath n = new MatrizMath(5,5);

		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				m.setValue(i, j, i+j+1);

		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++) {
				if (i == j)
					n.setValue(i, j, 1);
				else
					n.setValue(i, j, 0);
			}
/*
		MatrizMath mat = new MatrizMath();
		MatrizMath id = new MatrizMath(n);
		
		System.out.println("Matriz: " + mat);
		System.out.println("Matriz identidad: " + id);
		*/
		System.out.println("Prueba");

		//System.out.println(GaussJordan.gaussJordan(m, n));
		System.out.println("slsls");

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(m.getValue(i, j)+"\t");

			}
			System.out.println("");
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(n.getValue(i, j)+"\t");

			}
			System.out.println("");
		}
	}
}