package test;

import sel.GaussJordan;

import sel.MatrizMath;


public class GaussJordanTest {

	public static void main(String[] args) {
		MatrizMath m = new MatrizMath(3,3);
		MatrizMath n = new MatrizMath(3,3);

		m.setValue(0, 0, 2);
		m.setValue(0, 1, 4);
		m.setValue(0, 2, 3);
		m.setValue(1, 0, 5);
		m.setValue(1, 1, 1);
		m.setValue(1, 2, 2);
		m.setValue(2, 0, 3);
		m.setValue(2, 1, 2);
		m.setValue(2, 2, 1);
		
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) {
				if (i == j)
					n.setValue(i, j, 1);
				else
					n.setValue(i, j, 0);
			}
	
		System.out.println("Matriz: " + m);
		System.out.println("Matriz identidad: " + n);
		
		

		System.out.println(GaussJordan.gaussJordan(m, n));
		
		System.out.println("Matriz: " + m);
		System.out.println("Matriz identidad: " + n);
		
	}
}