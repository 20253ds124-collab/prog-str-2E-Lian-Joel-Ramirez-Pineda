import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        int limite = solicitarNumero(lector);
        int total = calcularSuma(limite);

        mostrarResultado(limite, total);

        lector.close();
    }

    public static int solicitarNumero(Scanner lector) {
        System.out.print("Introduce el valor límite: ");
        return lector.nextInt();
    }

    public static int calcularSuma(int limite) {
        int acumulador = 0;

        for (int contador = 1; contador <= limite; contador++) {
            acumulador += contador;
        }

        return acumulador;
    }

    public static void mostrarResultado(int limite, int total) {
        System.out.println(
                "El resultado de la suma de 1 hasta " + limite + " es: " + total
        );
    }
}