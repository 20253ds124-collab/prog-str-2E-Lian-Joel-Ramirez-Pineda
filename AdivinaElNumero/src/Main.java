import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        int nSecreto = rand.nextInt(100) + 1; // número entre 1 y 100
        int intentos = 0;
        int maxIntentos = 7;
        boolean gano = false;
        int fueraDeRango = 0;
        int noNumerico = 0;

        System.out.println("Adivina el número secreto (entre 1 y 100). Tienes " + maxIntentos + " intentos.");

        while (intentos < maxIntentos && !gano) {
            System.out.print("Intento " + (intentos + 1) + ": ");

            String entrada = sc.nextLine();
            int numeroUsuario;

            try {
                numeroUsuario = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido. Debes escribir un número.");
                noNumerico++;
                intentos++;
                continue;
            }

            if (numeroUsuario < 1 || numeroUsuario > 100) {
                System.out.println("Número fuera de rango (1-100).");
                fueraDeRango++;
                intentos++;
                continue;
            }

            intentos++;

            if (numeroUsuario == nSecreto) {
                System.out.println("Ganaste");
                gano = true;
            } else if (numeroUsuario < nSecreto) {
                System.out.println("El número secreto es mayor.");
            } else {
                System.out.println("El número secreto es menor.");
            }
        }

        if (!gano) {
            System.out.println("Perdiste. El número secreto era: " + nSecreto);
        }

        System.out.println("Veces fuera de rango: " + fueraDeRango);
        System.out.println("Veces no numéricas: " + noNumerico);

        sc.close();
    }
}
