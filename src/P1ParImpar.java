import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1ParImpar {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        List<Integer> numeros = new ArrayList<>();
        System.out.println("Introduce números mayores de 0, -1 para terminar:");
        while (true) {
            int numero = s.nextInt();
            if (numero == -1) break;
            numeros.add(numero);
        }

        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream("entrada.txt"))
        ) {
            dos.writeInt(numeros.size());
            for (Integer in : numeros) {
                dos.writeFloat(in);
            }
        }

        try (DataInputStream dis = new DataInputStream(
                new FileInputStream("entrada.txt"))
        ) {
            int cantidad = dis.readInt();
            if (cantidad > 0) {

              int contadorPares = 0;
              int contadorImpares = 0;
                for (int i = 0; i < cantidad; i++) {
                    int numero = dis.readInt();
                    if (numero % 2 == 0){
                        contadorPares++;
                    }else {
                        contadorImpares++;
                    }
                    System.out.println("Pares: " + contadorPares + ", impares: " + contadorImpares);

                }
                System.out.println("FIN");
            } else {
                System.out.println("No hay ninguna");
            }
        }

    }
}
