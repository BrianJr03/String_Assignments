import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        power();
    }

    private static void findGreaterNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Number 1: ");
        int numOne = scanner.nextInt();
        System.out.print("Enter Number 1: ");
        int numTwo = scanner.nextInt();
        if (numOne > numTwo) {
            System.out.printf("%d is greater.%n", numOne);
        } else {
            System.out.printf("%d is greater", numTwo);
        }
    }

    private static void axis() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x and y coordinates: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        if (x > 0 && y > 0) {
            System.out.println("1st");
        } else if (x < 0 && y > 0) {
            System.out.println("2nd");
        } else if (x < 0 && y < 0) {
            System.out.println("3rd");
        } else if (x > 0 && y < 0) {
            System.out.println("4th");
        }
    }

    private static void findPrime() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int n = scanner.nextInt();
        int d = 2;

        while(d <= n/2) {
            if (n % d == 0) {
                System.out.printf("%d is not prime.", n);
                break;
            }
            d++;
        }
        System.out.printf("%d is prime", n);
    }

    private static void findSumAndAvg(){
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        System.out.print("Enter 3 numbers");
        int numOne = scanner.nextInt();
        int numTwo = scanner.nextInt();
        int numThree = scanner.nextInt();
        sum = numOne + numTwo + numThree;
        System.out.printf("Sum is %d", sum);
        System.out.printf("Avg is %d", sum / 3);
    }


    private static void power() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x: ");
        int x = scanner.nextInt();

        System.out.print("Enter y: ");
        int y = scanner.nextInt();

        int res = 1;

        for (int i = 1; i<= y; i++) {
            res *= x;
        }

        System.out.printf("%d raised to the power of %d is %d", x, y, res);
    }


}
