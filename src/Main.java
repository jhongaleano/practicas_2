import java.util.Scanner;

class main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Boolean bandera = true;
        int opcion = 0;
        do{
            System.out.println("ejercicio 1");
            System.out.println("ejercicio 2");
            System.out.println("ejercicio 3");
            System.out.println("ejercicio 4");
            System.out.println("ejercicio 5");
            System.out.println("ejercicio 6");

            System.out.println("preciona 0 para salir");

            System.out.println("elija una opcion");
            opcion = sc.nextInt();

            switch (opcion){
                case 0:
                    System.out.println("saliendo...");
                    bandera = false;
                    break;
                case 1:
                    Ejercicio1.ejercicio1();
                    break;
                case 2:
                    Ejercicio2.ejercicio2();
                    break;
                case 3:
                    Ejercicio3.ejercicio3();
                    break;
                case 4:
                    Ejercicio4.ejercicio4();
                    break;
                case 5:
                    Ejercico5.ejercicio5();
                    break;
                case 6:
                    Ejercicio6.ejercicio6();
                    break;
                default:
                    System.out.println("opcion incorrecta saliendo...");
                    bandera=false;
                    break;


            }
        }while (bandera);
    }
}
