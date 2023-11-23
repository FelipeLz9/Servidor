/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GritonServerSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author lopez
 */
public class GritonServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public GritonServer() throws IOException {
        serverSocket = new ServerSocket(3366);
    }
    
    public boolean start() throws IOException{
        try {
            clientSocket = serverSocket.accept();
            
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(
                            new InputStreamReader(clientSocket.getInputStream()));
            
            String message = in.readLine();
            
            if(!message.equalsIgnoreCase("holis")){
                out.write("Not accepted :-( \n");
                out.flush();
                close();
                return false;
            }
            
            while(!(message = in.readLine()).equalsIgnoreCase("chao")){
                String messageProcessed = process(message);
                out.write(messageProcessed + "\n");
                out.flush();
            }
            
        } catch (IOException ex) {
            System.out.println("Problemas conectando al cliente" + ex.getMessage());
        }
        return true;
    }
    
    public String process(String message){
        return message.toUpperCase() + " Pc Felipe";
    }
    
    public void close() throws IOException{
        in.close();
        out.close();
        clientSocket.close();
    }
    
}
