import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class P2RegistrarReservas {
    private static final Scanner s = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        File fichero = new File("reservas.dat");


        if (!fichero.exists()) {
            try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
                for (int i = 0; i < 31; i++) {
                    raf.writeDouble(Double.NaN);
                    System.out.println("Inicializando reservas");
                    hacerReserva(s, raf);
                }
            }
        }else {
            System.out.println("Abriendo reservas");
        }

    }

    private static void hacerReserva(Scanner s, RandomAccessFile raf) throws IOException {
        long dia = pedirDia(s);

            long posicion = Double.BYTES * (dia - 1);
            int contador = 0;
            raf.seek(posicion);
            double invitados = raf.readDouble();
            if (!Double.isNaN(invitados)) {
                contador++;
                System.out.format("Día %02d:  %.2f\n", dia, invitados);
                System.out.println("Hay " + contador + "aperturas este mes");
            }
            invitados = pedirInvitados(s);
            raf.seek(posicion);
            raf.writeDouble(invitados);

    }

    private static long pedirDia(Scanner s) {
        long dia;
        while (true) {
            System.out.print("Día: ");
            try {
                dia = s.nextInt();
                if (dia >= 1 && dia <= 31) break;
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Día incorrecto");
        }
        return dia;
    }

    private static double pedirInvitados(Scanner s) {
        double invitados;
        while (true) {
            System.out.print("¿Cuántos invitados nuevos?: ");
            try {
                invitados = s.nextDouble();
                break;
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Debe ser mayor que 0");
        }
         return invitados;
    }
}
