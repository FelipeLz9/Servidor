/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gritonserver;

import GritonServerSocket.GritonServer;
import java.io.IOException;

/**
 *
 * @author lopez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Iniciando GritonServer ...");
        
        GritonServer server = null;
        while(true){
            try{
            server = new GritonServer();
            }catch(IOException ex){
                System.out.println("Error, no se pudo levantar el servidor.");
                System.exit(1);
            }
            try {
                server.start();
            } catch (IOException ex) {
                
            }
        }
    }
    
}
