
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Calcular IMC");
            System.out.println("2. Calcular área de un rectángulo");
            System.out.println("3. Convertir °C a °F");
            System.out.println("4. Calcular área de un círculo");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Peso (kg): ");
                    double peso = scanner.nextDouble();
                    System.out.print("Altura (m): ");
                    double altura = scanner.nextDouble();
                    System.out.println("Tu IMC es: " + calcularIMC(peso, altura));
                    break;

                case 2:
                    System.out.print("Base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Altura: ");
                    double h = scanner.nextDouble();
                    System.out.println("Área = " + areaRectangulo(base, h));
                    break;

                case 3:
                    System.out.print("Grados Celsius: ");
                    double c = scanner.nextDouble();
                    System.out.println("Fahrenheit = " + convertirCelsiusAFahrenheit(c));
                    break;

                case 4:
                    System.out.print("Radio: ");
                    double r = scanner.nextDouble();
                    System.out.println("Área del círculo = " + areaCirculo(r));
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 5);

        scanner.close();
    }

    /**
     * Calcula el Índice de Masa Corporal.
     * @param peso Peso en kilogramos.
     * @param altura Altura en metros.
     * @return IMC calculado.
     */
    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    /**
     * Calcula el área de un rectángulo.
     * @param base Valor de la base.
     * @param altura Valor de la altura.
     * @return Área del rectángulo.
     */
    public static double areaRectangulo(double base, double altura) {
        return base * altura;
    }

    /**
     * Convierte grados Celsius a Fahrenheit.
     * @param c Temperatura en Celsius.
     * @return Temperatura en Fahrenheit.
     */
    public static double convertirCelsiusAFahrenheit(double c) {
        return (c * 9/5) + 32;
    }

    /**
     * Calcula el área de un círculo usando π*r^2.
     * @param radio Radio del círculo.
     * @return Área del círculo.
     */
    public static double areaCirculo(double radio) {
        return Math.PI * radio * radio;
    }
}
