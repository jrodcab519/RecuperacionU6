import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class P3Transportes {
    private static final Scanner s = new Scanner(System.in);
    public static void main(String[] args) {

            int opcion;
            do {
                opcion = mostrarMenu(s);
                switch (opcion) {
                    case 1:
                        gestionarMatriculas(s);
                        break;
                    case 2:
                        listarFlota();
                        break;
                    case 3:
                        eliminarCamiones();
                        break;
                    case 4:
                        break;
                    
                }
            } while (opcion != 4);
        }

    private static void eliminarCamiones() {
    }

    private static void listarFlota() {
        
    }

    private static void gestionarMatriculas(Scanner s) {
        System.out.println("Introduzca una matricula (FIN = salir:)");
        s.nextLine();
        String matricula = s.nextLine();
        String nombre;
        int capacidad;
        while(!matricula.equals("FIN")){
            System.out.println("Nombre de la empresa:");
            nombre = s.nextLine();
            System.out.println("Capacidad:");
            capacidad = s.nextInt();
            s.nextLine();
        }
    }

    private static int mostrarMenu(Scanner s) {
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("1. Gestionar matriculas");
        System.out.println("2. Listar flota");
        System.out.println("3. Elminar todos los camiones");
        System.out.println("4. Salir");
        
        return s.nextInt();
    }
}
