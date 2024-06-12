import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class P2ListarReservas {

    private static final Scanner s = new Scanner(System.in);
    public static void main(String[] args) throws IOException{
        File fichero = new File("reservas.dat");

        if (fichero.exists()) {
            try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
                for (int i = 0; i < 31; i++) {
                    recuperarTemperatura(s, raf);
                    listarInvitados(raf);
                }
            }
        }
    }

    private static void recuperarTemperatura(Scanner s, RandomAccessFile raf) throws IOException {
        long dia = pedirDia(s);
        raf.seek(Double.BYTES * (dia - 1));
        double temperatura = raf.readDouble();
        if (!Double.isNaN(temperatura)) {
            System.out.format("Día %02d: %.2f\n", dia, temperatura);
        } else {
            System.out.println("No hay temperatura registrada ese día");
        }
    }

    private static void listarInvitados(RandomAccessFile raf) throws IOException {

        raf.seek(0);
        for (int i = 0; i < 31; i++) {
            double invitados = raf.readDouble();

            if (!Double.isNaN(invitados)) {
                System.out.format("Día %02d: %.2f\n", i + 1, invitados);
            }
        }
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

}
