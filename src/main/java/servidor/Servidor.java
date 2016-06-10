package servidor;

import util.Util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by amaraujo on 09/06/2016.
 */
public class Servidor {

    public static final int PORTA = 1001;

    public static void main(String[] args) {
        executarSevidor();
    }

    public static void executarSevidor(){

        try {
            ServerSocket servidor = new ServerSocket(PORTA);
            System.out.println("Servidor Online!");

            while (true){
                Socket cliente = servidor.accept();
                System.out.println("O cliente " + cliente.getInetAddress().getHostAddress() + " está conectado!");
                new Thread(cliente).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
