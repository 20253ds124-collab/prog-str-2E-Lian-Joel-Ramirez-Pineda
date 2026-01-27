import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcion;
        int contadorCaF = 0;
        int contadorFaC = 0;
        int contadorKmaMi = 0;
        int contadorMiaKm = 0;

        do {
            System.out.println("MENU DE CONVERSION");
            System.out.println("1) °C a °F");
            System.out.println("2) °F a °C");
            System.out.println("3) Km a Millas");
            System.out.println("4) Millas a Km");
            System.out.println("5) Salir");
            System.out.print("Selecciona una opcion: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Ingresa un numero valido");
                scanner.next();
                opcion = 0;
            } else {
                opcion = scanner.nextInt();
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa los grados Celsius: ");
                    if (scanner.hasNextDouble()) {
                        double c = scanner.nextDouble();
                        double f = (c * 9/5) + 32;
                        System.out.println(c + " °C = " + f + " °F");
                        contadorCaF++;
                    } else {
                        System.out.println("Valor incorrecto");
                        scanner.next();
                    }
                    break;

                case 2:
                    System.out.print("Ingresa los grados Fahrenheit: ");
                    if (scanner.hasNextDouble()) {
                        double f = scanner.nextDouble();
                        double c = (f - 32) * 5/9;
                        System.out.println(f + " °F = " + c + " °C");
                        contadorFaC++;
                    } else {
                        System.out.println("valor incorrecto");
                        scanner.next();
                    }
                    break;

                case 3:
                    System.out.print("Ingresa los kilometros: ");
                    if (scanner.hasNextDouble()) {
                        double km = scanner.nextDouble();
                        double mi = km * 0.621371;
                        System.out.println(km + " Km = " + mi + " Millas");
                        contadorKmaMi++;
                    } else {
                        System.out.println("valor incorrcto");
                        scanner.next();
                    }
                    break;

                case 4:
                    System.out.print("Ingresa las millas: ");
                    if (scanner.hasNextDouble()) {
                        double mi = scanner.nextDouble();
                        double km = mi / 0.621371;
                        System.out.println(mi + " Millas = " + km + " Km");
                        contadorMiaKm++;
                    } else {
                        System.out.println("valor incorrecto");
                        scanner.next();
                    }
                    break;

                case 5:
                    System.out.println("bye");
                    break;

                default:
                    System.out.println("Opcion invalida. Intenta de nuevo.");
            }

        } while (opcion != 5);

        int total = contadorCaF + contadorFaC + contadorKmaMi + contadorMiaKm;
        System.out.println("RESUMEN");
        System.out.println("Total de conversiones: " + total);
        System.out.println("°C a °F: " + contadorCaF);
        System.out.println("°F a °C: " + contadorFaC);
        System.out.println("Km a Millas: " + contadorKmaMi);
        System.out.println("Millas a Km: " + contadorMiaKm);

        scanner.close();
    }
}
