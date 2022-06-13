// Write a program to find addition, multiplication and transpose of matrix.
import java.util.Scanner;

public class Matrix {
    private final int r, c;
    private final int[][] mat;


    public Matrix() {
        Scanner sin = new Scanner(System.in);
        System.out.println("Enter dimensions of matrix: ");
        r = sin.nextInt();
        c = sin.nextInt();

        mat = new int[r][c];
        System.out.println("Enter element of "+r+"x"+c+" matrix: ");
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                mat[i][j] = sin.nextInt();
            }
        }
    }

    public Matrix(int rows, int columns) {
        r = rows;
        c = columns;
        mat = new int[r][c];
    }

    public Matrix add(Matrix m) {
        // First matrix - r, c, mat
        // Second matrix - m.r, m.c, m.mat
        if( r != m.r || c != m.c ) {
            return null;
        }

        // Result matrix: res.r, res.c, res.mat
        Matrix res = new Matrix(r, c);

        for(int i=0; i < r; i++) {
            for(int j=0; j < c; j++) {
                res.mat[i][j] = mat[i][j] + m.mat[i][j];
            }
        }

        return res;
    }

    public void showMatrix() {
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

class MatrixOpr {
    public static void main(String[] args) {
        Matrix a = new Matrix();
        Matrix b = new Matrix();

        Matrix c = a.add(b);
        if(c == null) {
            System.out.println("Addition not possible due to invalid dimensions");
        } else {
            System.out.println("First matrix: ");
            a.showMatrix();

            System.out.println("Second matrix: ");
            b.showMatrix();

            System.out.println("Addition matrix: ");
            c.showMatrix();
        }
    }
}