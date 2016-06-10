package servidor;

import dicionario.Dicionario;
import util.Util;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by amaraujo on 09/06/2016.
 */
public class Thread extends java.lang.Thread{

    private Socket socket;
    private String palavraCliente;
    private String resposta;

    public Thread(Socket socket) {
        this.socket = socket;
    }

    public void run(){
        try {
            Scanner cliente = new Scanner(socket.getInputStream());

            if (cliente.hasNextLine()){
                palavraCliente = cliente.nextLine();

                resposta = Dicionario.getInstance().getDicionario().get(palavraCliente.toLowerCase());

                if (resposta != null){
                    PrintStream enviarResposta = new PrintStream(socket.getOutputStream());
                    enviarResposta.println(resposta);

                }else {
                    PrintStream enviarResposta = new PrintStream(socket.getOutputStream());
                    enviarResposta.println("Significado não encontrado!");
                }
            }else {
                System.out.println("O cliente " + socket.getInetAddress().getHostAddress() + " desconectou");
            }

        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
