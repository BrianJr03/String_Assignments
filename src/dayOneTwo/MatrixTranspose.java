import java.util.Scanner;
@SuppressWarnings("all")

public class MatrixTranspose {

	private final int r, c;
	private final int[][] mat, transposedMat;

	public MatrixTranspose() {
		try (Scanner sin = new Scanner(System.in)) {
			System.out.println("Enter dimensions of matrix: ");
			r = sin.nextInt();
			c = sin.nextInt();

			mat = new int[r][c];
			transposedMat = new int[c][r];

			System.out.println("Enter element of " + r + "x" + c + " matrix: ");
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					mat[i][j] = sin.nextInt();
				}
			}
		}
	}

	public MatrixTranspose(int rows, int columns) {
		r = rows;
		c = columns;
		mat = new int[r][c];
		transposedMat = new int[c][r];
	}

	public MatrixTranspose transpose() {
		MatrixTranspose res = new MatrixTranspose(r, c);

		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				res.transposedMat[j][i] = mat[i][j];
			}
		}

		return res;
	}

	public void showTransposedMatrix() {
		for(int i = 0; i < c; i++){
			for(int j = 0; j <r ; j++){
				System.out.print(transposedMat[i][j] + "\t");
			}
			System.out.println();
		}
	}
}

class MatrixTransposeOpr {
	public static void main(String[] args) {
		MatrixTranspose a = new MatrixTranspose();
		MatrixTranspose c = a.transpose();
		if(c == null) {
			System.out.println("Transpose not possible due to invalid dimensions");
		} else {
			System.out.println("\nTransposed matrix: ");
			c.showTransposedMatrix();
		}
	}
}

