import java.util.Scanner;

public class ActividadSwitchCalculadora {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Que quieres hacer hoy?");
        System.out.println("1) Sumar");
        System.out.println("2) Restar");
        System.out.println("3) Multiplicar");
        System.out.println("4) Dividir");

        System.out.println("Ingresa una opción");
        int opcion = sc.nextInt();

        System.out.println("ingresa el valor a ");
        double a = sc.nextDouble();

        System.out.println("ingresa el valor b ");
        double b = sc.nextDouble();

        double resultado;

        switch (opcion) {
            case 1:
                resultado = a + b;
                System.out.println("SUMA");
                System.out.println(" a = " + a + "b = " + b);
                System.out.println("El resultado es: " + resultado);
                break;

            case 2:
                resultado = a - b;
                System.out.println("RESTA");
                System.out.println("a = " + a + "b = " + b);
                System.out.println("El resultado es: " + resultado);
                break;
            case 3:
                resultado = a * b;
                System.out.println("MULTIPLICACION");
                System.out.println("a = " + a + "b = " + b);
                System.out.println("El resultado es:" + resultado);
                break;

            case 4:
                if (b == 0){
                    System.out.println("Operacion invalida");
                    System.out.println("No se puede dividir entre 0");
                } else {
                    resultado = a/b;
                    System.out.println("DIVICION");
                    System.out.println("a = " + a + "b = "+ b);
                    System.out.println("El resultado es:" + resultado);

                }
                break;
            default:
                System.out.println("Numero invalido");
                System.out.println("Selecciona una opcion valida");
                break;
        }

        sc.close();
        }


    }

