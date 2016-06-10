package cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by amaraujo on 09/06/2016.
 */
public class Cliente {

    private static final String HOST = "localhost";
    private static final int PORTA = 1001;

    public static void main(String[] args) {
        executarCliente();
    }

    public static void executarCliente() {

        System.out.println("Palavras cadastradas: misógino - transeunte - escusa - deixar - renunciar - atrás " +
                "- vertente - insensato - remeter - revogado - disseminação\n");

        while (true) {
            try {
                Socket cliente = new Socket(HOST, PORTA);
                Scanner resposta = new Scanner(cliente.getInputStream());
                PrintStream enviarPalavra = new PrintStream(cliente.getOutputStream());

                System.out.print("Digite a palavra: ");
                Scanner scanner = new Scanner(System.in);

                String palavra = scanner.nextLine();
                enviarPalavra.println(palavra);

                String significado = resposta.nextLine();
                System.out.println("Significado: " + significado + "\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
