import java.util.Scanner;

public class main {
    static Personas[] personas = new Personas[20];
    static int contador = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("MENU:");
            System.out.println("1) Alta");
            System.out.println("2) Buscar por ID ");
            System.out.println("3) Baja por ID");
            System.out.println("4) Listar activas");
            System.out.println("5) Actualizar nombre por ID ");
            System.out.println("0) Salir");
            System.out.print("Elige  una opción :) ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion) {
                case 1: alta(sc); break;
                case 2: buscar(sc); break;
                case 3: baja(sc); break;
                case 4: listar(); break;
                case 5: actualizar(sc); break;
                case 0: System.out.println("Saliendo ..."); break;
                default: System.out.println("Selecciona una opcion valida.");
            }
        } while(opcion != 0);
    }

    static void alta(Scanner sc) {
        if (contador >= personas.length){
            System.out.println("Se a alcanzado el limite de altas.");
            return;
        }

        System.out.print("El ID debe ser mayor a 0");
        int id = sc.nextInt();
        sc.nextLine();

        if (id <= 0) {
            System.out.println("ID inválido.");
            return;
        }

        for (int i = 0; i < contador; i++) {
            if (personas[i].id == id) {
                System.out.println("ID repetido.");
                return;
            }
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        if (nombre.trim().isEmpty()) {
            System.out.println("Nombre vacío.");
            return;
        }

        personas[contador++] = new Personas(id, nombre);
        System.out.println("Persona registrada.");
    }

    static void buscar(Scanner sc) {
        System.out.print("ID a buscar: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < contador; i++) {
            if (personas[i].id == id && personas[i].activa) {
                System.out.println("ID: " + personas[i].id + ", Nombre " + personas[i].nombre);
                return;
            }
        }
        System.out.println("ID no registrado ");
    }

    static void baja(Scanner sc) {
        System.out.print("ID para baja: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < contador; i++) {
            if (personas[i].id == id && personas[i].activa) {
                personas[i].activa = false;
                System.out.println("Persona dada de baja.");
                return;
            }
        }
        System.out.println("No encontrada.");
    }
    static void listar() {
        System.out.println("Personas activas:");
        for (int i = 0; i < contador; i++) {
            if (personas[i].activa) {
                System.out.println("ID: " + personas[i].id + ", Nombre: " + personas[i].nombre);
            }
        }
    }
    static void actualizar(Scanner sc) {
        System.out.print("ID para actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < contador; i++) {
            if (personas[i].id == id && personas[i].activa) {
                System.out.print("Nombre: ");
                String nuevo = sc.nextLine();
                if (nuevo.trim().isEmpty()) {
                    System.out.println("Nombre vacío.");
                    return;
                }
                personas[i].nombre = nuevo;
                System.out.println("Nombre actualizado.");
                return;
            }
        }
        System.out.println("No encontrada .");
    }
}
