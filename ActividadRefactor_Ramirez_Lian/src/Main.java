import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = ingresarEntero("a: ", scanner);
        int b = ingresarEntero("b: ", scanner);
        int c = ingresarEntero("c: ", scanner);

        int suma = getSuma(a, b, c);
        resultados(suma);
    }

    private static void resultados(int suma) {
        System.out.println("suma=" + suma);
        System.out.println("prom=" + getPromedio(suma));
    }

    private static double getPromedio(int suma) {
        return suma / 3.0;
    }

    private static int getSuma(int a, int b, int c) {
        int suma = a + b + c;
        return suma;
    }

    private static int ingresarEntero(String s, Scanner scanner) {
        System.out.print(s);
        int a = scanner.nextInt();
        return a;
    }
}