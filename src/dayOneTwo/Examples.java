import java.util.Scanner;

public class Examples {
    public static void main(String[] args) {
        transpose();
    }

    private static void findFactorial() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = input.nextInt();
        int factorial = 1;
        for (int i = 1; i < num + 1; i++) {
            factorial *= i;
        }
        System.out.printf("Factorial of %d is %d", num , factorial);
    }

    private static void getReverseNum () {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = input.nextInt();
        int reversedNum =0;

        while (num != 0) {
            reversedNum = reversedNum * 10 + num % 10;
            num = num/10;
        }

        System.out.println("Reverse of number: " + reversedNum);
    }

    private static void isPalindrome(String string) {
        StringBuilder str
                = new StringBuilder(string);
        String reverseStr = str.reverse().toString();
        if (string.equals(reverseStr)) {
            System.out.println("Is a Palindrome");
        }
        else {
            System.out.println("Not a Palindrome");
        }
    }

    private static void findSmallestAndGreatest() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter numbers to populate array: ");
        int n = input.nextInt();

        System.out.printf("Enter %d array elements", n);

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }

        int max = array[0];

        for (int i = 1; i < n; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        int min = array[0];

        for (int num : array) {
            if (num < min) {
                min = num;
            }
        }

        System.out.printf("Greatest number is %d", max);
        System.out.println();
        System.out.printf("Smallest number is %d", min);

    }

    private static void isNumPresentInArray() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter numbers to populate array: ");
        int n = input.nextInt();
        System.out.printf("Enter %d array elements: ", n);
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }
        System.out.print("Enter a number to check if it is the array: ");
        int numToCheckFor = input.nextInt();
        int count = 0;
        for (int num : array) {
            if (num == numToCheckFor) {
                count++;
            }
        }
    }

    private static void transpose() {
        try (Scanner sin = new Scanner(System.in)) {
            System.out.println("Enter the dimensions of matrix: ");

            int r1 = sin.nextInt();
            int c1 = sin.nextInt();


            int[][] matA = new int[r1][c1];

            int[][] temp  = new int[c1][r1];

            System.out.println("Enter elements of "+r1+" x "+c1+" matrix:");
            for(int i=0; i<r1; i++) {
                for(int j=0; j<c1; j++) {
                    matA[i][j] = sin.nextInt();
                }
            }


            for(int i=0; i<r1; i++) {
                for(int j=0; j<c1; j++) {
                    temp[j][i] = matA[i][j];
                }
            }

            System.out.println("Transposed matrix is: ");


            for(int i=0;i<c1;i++){
                for(int j=0;j<r1;j++){
                    System.out.print(temp[i][j]+" ");
                }
                System.out.println();
            }
        }

    }



    private static void matrix() {
        Scanner sin = new Scanner(System.in);

        System.out.println("Enter the dimensions of matrix: ");

        int r1 = sin.nextInt();
        int c1 = sin.nextInt();

        int[][] matA = new int[r1][c1];

        int[][] transposedMatA = new int[r1][c1];

        System.out.println("Enter elements of "+r1+" x "+c1+" matrix:");
        for(int i=0; i<r1; i++) {
            for(int j=0; j<c1; j++) {
                matA[i][j] = sin.nextInt();
            }
        }

        for(int i=0; i<r1; i++) {
            for(int j=0; j<c1; j++) {
                transposedMatA[j][i] = matA[i][j];
            }
        }

        System.out.println("Transposed matrix is: ");
        for(int i=0; i<r1;i++) {
            for(int j=0;j<c1;j++) {
                System.out.print(transposedMatA[i][j]+"\t");
            }
            System.out.println();
        }

    }
}
