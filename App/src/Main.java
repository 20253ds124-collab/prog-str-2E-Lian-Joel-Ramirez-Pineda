import java.util.Random;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner= new Scanner(System.in);
        Random random= new Random();
        int min=1;
        int max=100;
        int intentos=0;
        int limiteIntentos=7;
        int secreto = random.nextInt(max)+min; //1...100
        System.out.println(secreto);
        boolean gano=false; //bandera para saber si gano o no

        System.out.println("Adivina el numero entre (1-100) tienes: "+limiteIntentos);

        while(intentos<limiteIntentos && !gano){
            int valor=obtenerNumeroValido(min, max, scanner, "Intento: "+(intentos+1));
            intentos++;
            if(valor == secreto){
                System.out.println("Ganaste en el "+intentos+" intento");
                gano=true;

            }else if(valor>secreto){
                System.out.println("El numero es menor");
            }else{
                System.out.println("El numero es mayor");
            }

        }
        if(!gano){
            System.out.println("Perdiste, el numero secreto era: "+secreto);
        }
        scanner.close();

    }

    public static int obtenerNumeroValido(int min, int max, Scanner scanner, String mensaje){
        int valor;
//ciclo indefinido
        while(true){ // lo vamos a usar para pedir datos de forma indefinida, hasta que el usuario ingrese un dato valido (1-100)
            System.out.println(mensaje);
            if(scanner.hasNextInt()){ //averiguar el dato de entrada es numerico
//determina si la entrada esta dentro del rango (1-100)
                valor = scanner.nextInt();
                if(valor>=min && valor<=max){
                    return valor;
                }
                System.out.println("Numero fuera de rango debe de ser entre "+min+" y"+max);
            }else{
                System.out.println("El dato que ingresaste no es un numero");
                scanner.next();
            }


        }

    }
}