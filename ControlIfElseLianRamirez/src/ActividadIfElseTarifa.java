import java.util.Scanner;
public class ActividadIfElseTarifa {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("ingresa tu edad");
        int edad=sc.nextInt();

        if (edad < 0 || edad > 120) {
            System.out.println("Edad invalida");
            return;
        }

        System.out.println("Eres estudiante? (true , False)");
        boolean estudiante = sc.nextBoolean();

        int tarifa;



        if (edad<12){
            tarifa = 50;
        } else if (edad<=17){
            if (estudiante){
                tarifa=60;
            } else {
                tarifa=80;
            }
        } else {
            if (estudiante){
                tarifa=90;
            } else{
                tarifa=120;
            }
        }
        System.out.println("Edad :" + edad);
        System.out.println("Eres estudiante? :" + estudiante);
        System.out.println("Tarifa: "+ tarifa);
    }
}