package sel;

public class GaussJordan {

	public static boolean esIdentidad(int m1[][]) {
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++) {
				if (i == j && m1[i][j] != 1)
					return false;
				if (i != j && m1[i][j] != 0)
					return false;
			}
		return true;
	}

	public static int gaussJordan(int m1[][], int m2[][]) {
		int k, i = 0, y = 0, j = 0, a = 0;
		while (!esIdentidad(m1)) {
			if (i >= 5)
				i = 0;
			for (y = 0; y < 5; y++) {
				if (m1[i][i] != 0) {

					k = 1 / m1[i][i];

					for (j = 0; j < 5; j++) {
						m1[y][j] *= k;
						m2[y][j] *= k;

					}
				}
			}
			for (y = 0; y < 5; y++) {
				if (i != y)
					for (j = 0; j < 5; j++) {
						m1[y][j] -= m1[i][j];
						m2[y][j] -= m2[i][j];
					}
			}

			i++;
		}
		a = 1;
		return a;
	}
}
