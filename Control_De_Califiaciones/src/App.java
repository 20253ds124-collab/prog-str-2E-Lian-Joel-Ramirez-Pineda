import java.util.Scanner;

public class App {
    public static String noVacio(Scanner sc, String msg) {
        String texto;
        do {
            System.out.print(msg);
            texto = sc.nextLine().trim();
        } while (texto.isEmpty());
        return texto;
    }

    public static double valorCalf(Scanner sc, String msg, double min, double max) {
        double valor;
        do {
            System.out.print(msg);
            valor = sc.nextDouble();
        } while (valor < min || valor > max);
        return valor;
    }

    public static int numAsistencias(Scanner sc, String msg, int min, int max) {
        int valor;
        do {
            System.out.print(msg);
            valor = sc.nextInt();
        } while (valor < min || valor > max);
        return valor;
    }

    public static boolean proyecto(Scanner sc, String msg) {
        boolean valor;
        while (true) {
            System.out.print(msg);
            if (sc.hasNextBoolean()) {
                valor = sc.nextBoolean();
                break;
            } else {
                System.out.println("Escribe true o false.");
                sc.next();
            }
        }
        return valor;
    }

    public static void imprimirReporte(String nombre, double p1, double p2, double p3, double promedio, int asistencia, boolean entregoProyecto, double finalCal, String estado) {
        System.out.println("\n--- REPORTE ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Parcial 1: " + p1);
        System.out.println("Parcial 2: " + p2);
        System.out.println("Parcial 3: " + p3);
        System.out.println("Promedio: " + promedio);
        System.out.println("Asistencia: " + asistencia);
        System.out.println("Entregó proyecto: " + entregoProyecto);
        System.out.println("Calificación final: " + finalCal);
        System.out.println("Estado: " + estado);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GradeService gs = new GradeService();

        String nombre = noVacio(sc, "Nombre del alumno: ");
        double p1 = valorCalf(sc, "Parcial 1 (0-100): ", 0, 100);
        double p2 = valorCalf(sc, "Parcial 2 (0-100): ", 0, 100);
        double p3 = valorCalf(sc, "Parcial 3 (0-100): ", 0, 100);
        int asistencia = numAsistencias(sc, "Asistencia (0-100): ", 0, 100);
        boolean entregoProyecto = proyecto(sc, "¿Entregó proyecto? (true/false): ");

        double promedio = gs.calcPromedio(p1, p2, p3);
        double finalCal = gs.calcPromFinal(promedio, asistencia);
        String estado = gs.estadoAprobReprob(finalCal, asistencia, entregoProyecto);

        imprimirReporte(nombre, p1, p2, p3, promedio, asistencia, entregoProyecto, finalCal, estado);

        sc.close();
    }
}
