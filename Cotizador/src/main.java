import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double peso = valorPeso(sc, "Ingresa peso (kg): ", 0.1, 50.0);
        int distancia = valores(sc, "Ingresa distancia (km): ", 1, 2000);
        int servicio = valores(sc, "Tipo de servicio 1=Estándar, 2=Express: ", 1, 2);
        boolean zonaRemota = valorTrueFalse(sc, "¿El servicio es para una zona remota? (true/false): ");

        ShippingCalculator calc = new ShippingCalculator();
        double subtotal = calc.calcularSubtotal(peso, distancia, servicio, zonaRemota);
        double iva = calc.calcularIVA(subtotal);
        double total = calc.calcularTotal(subtotal, iva);

        imprimirTicket(servicio, peso, distancia, zonaRemota, subtotal, iva, total);
    }

    public static double valorPeso(Scanner sc, String msg, double min, double max) {
        double valor;
        while (true) {
            System.out.print(msg);
            valor = sc.nextDouble();
            if (valor >= min && valor <= max) break;
            System.out.println("Valor fuera de rango.");
        }
        return valor;
    }

    public static int valores(Scanner sc, String msg, int min, int max) {
        int valor;
        while (true) {
            System.out.print(msg);
            valor = sc.nextInt();
            if (valor >= min && valor <= max) break;
            System.out.println("Valor fuera de rango.");
        }
        return valor;
    }

    public static boolean valorTrueFalse(Scanner sc, String msg) {
        boolean valor;
        while (true) {
            System.out.print(msg);
            if (sc.hasNextBoolean()) {
                valor = sc.nextBoolean();
                break;
            } else {
                System.out.println("Debes escribir true o false.");
                sc.next();
            }
        }
        return valor;
    }

    public static void imprimirTicket(int servicio, double peso, int distancia, boolean zonaRemota,
                                      double subtotal, double iva, double total) {
        System.out.println("---TICKET---");
        System.out.println("Servicio: " + (servicio == 1 ? "Estándar" : "Express"));
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Distancia: " + distancia + " km");
        System.out.println("Zona remota: " + zonaRemota);
        System.out.printf("Subtotal: $%.2f\n", subtotal);
        System.out.printf("IVA (16%%): $%.2f\n", iva);
        System.out.printf("TOTAL: $%.2f\n", total);
    }
}
