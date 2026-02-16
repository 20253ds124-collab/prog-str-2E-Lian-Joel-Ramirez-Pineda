import java.util.Scanner;
public class Main {
    static Alumno[]alumnos=new Alumno[25];
    static int contador =0;
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int opcion;
        do {
            System.out.println("MENU");
            System.out.println("1) Alta");
            System.out.println("2) Buscar ID");
            System.out.println("3) Actualizar promedio");
            System.out.println("4) Baja de ID");
            System.out.println("5) Lista de activos");
            System.out.println("6) Reportes");
            System.out.println("0) Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion) {
                case 1: alta(sc); break;
                case 2: buscar(sc); break;
                case 3: actualizarProm(sc); break;
                case 4: baja(sc); break;
                case 5: listaDeActivos(); break;
                case 6: reportes(); break;
                case 0: System.out.println("Saliendo.............."); break;
                default: System.out.println("Opcion invalida");
            }
        } while(opcion != 0);
    }
    static void alta(Scanner sc){
        if(contador>=alumnos.length){
            System.out.println("Sistema lleno");
            return;
        }
        System.out.print("ID: ");
        int id=sc.nextInt();sc.nextLine();
        if(id<=0 || existeId(id)){
            System.out.println("ID invalido");
            return;
        }
        System.out.print("Nombre: ");
        String nombre=sc.nextLine();
        if(nombre.trim().isEmpty()){
            System.out.println("Nombre vacio");
            return;
        }
        System.out.print("Promedio: ");
        double prom=sc.nextDouble();
        if (prom<0 || prom>10){
            System.out.println("Promedio invalido");
            return;
        }
        alumnos[contador++]=new Alumno(id, nombre, prom);
        System.out.println("Alumno asignado");
    }
    static boolean existeId(int id){
        for (int i=0; i<contador;i++){
            if(alumnos[i].id==id)return true;
        } return false;
    }
    static void buscar(Scanner sc){
        System.out.print("ID: ");
        int id=sc.nextInt();
        for(int i=0;i<contador;i++){
            if (alumnos[i].id==id && alumnos[i].activo){
                System.out.println("Alumno: " + alumnos[i].nombre + " Promedio: " + alumnos[i].promedio);
                return;
            }
        } System.out.println("No se encontro");
    }
    static void actualizarProm(Scanner sc){
        System.out.print("ID: ");
        int id=sc.nextInt();
        for (int i=0;i<contador;i++){
            if (alumnos[i].id==id && alumnos[i].activo){
                System.out.print("Nuevo promedio: ");
                double prom=sc.nextDouble();
                if (prom>=0 && prom<=10){
                    alumnos[i].promedio=prom;
                    System.out.println("Promedio actualizado");
                }else{
                    System.out.println("Promedio invalido");
                } return;
            }
        } System.out.println("No encontrado");
    }
    static void baja(Scanner sc){
        System.out.print("ID: ");
        int id=sc.nextInt();
        for (int i=0;i<contador;i++){
            if (alumnos[i].id==id && alumnos[i].activo){
                alumnos[i].activo=false;
                System.out.println("Alumno dado de baja");
                return;
            }
        } System.out.println("No encontrado");
    }
    static void listaDeActivos(){
        for (int i=0;i<contador;i++){
            if (alumnos[i].activo){
                System.out.println(alumnos[i].id+"-"+alumnos[i].nombre+"-"+alumnos[i].promedio);
            }
        }
    }
    static void reportes(){
        double suma=0;
        int activos=0;
        Alumno mayor=null;
        Alumno menor=null;
        int con8=0;
        for(int i=0;i<contador;i++){
            if (alumnos[i].activo){
                suma+=alumnos[i].promedio;
                activos++;
                if (mayor==null || alumnos[i].promedio>mayor.promedio)mayor=alumnos[i];
                if (menor==null || alumnos[i].promedio<menor.promedio)menor=alumnos[i];
                if (alumnos[i].promedio>=8.0) con8++;
            }
        } if (activos==0){
            System.out.println("No hay alumnos activos");
            return;
        }
        System.out.println("Promedio general: " + (suma/activos));
        System.out.println("Mayor promedio: " + mayor.id + " " + mayor.nombre + " " + mayor.promedio);
        System.out.println("Menor promedio: " + menor.id + " " + menor.nombre + " " + menor.promedio);
        System.out.println("Alumnos con promedio >= 8: " + con8);
    }
}
