/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuclearPlant.comunications;

import java.io.IOException;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.ArrayList;
import nuclearPlant.comunications.Message;
import nuclearPlant.elements.Plant;
import nuclearPlant.elements.Reactor;
import nuclearPlant.tools.HiloEnviar;
import nuclearPlant.tools.HiloRecibir;
import nuclearPlant.tools.IPScanner;

public class PlantControl {

    private ServerSocket servidor;
    private Plant planta;
    private ArrayList<Socket> hrs;

    public PlantControl() {
        this.servidor = null;
        hrs = new ArrayList<>();
        this.planta = new Plant();
        try {
            this.servidor = new ServerSocket(32645);
        } catch (Exception ex2) {
            System.out.println(ex2.getMessage());
        }
    }

    public ArrayList<Socket> getHrs() {
        return hrs;
    }
    
    

    public void iniciarServidor() {
        while (true) {
            try {                
                final Socket cliente = this.servidor.accept();                
                ObjectOutputStream obj = new ObjectOutputStream(cliente.getOutputStream());
                obj.writeObject(planta);                   
                HiloRecibir hr = new HiloRecibir(cliente, this.planta, this);
                hr.start();
                hrs.add(cliente);             
                System.out.println(hrs.size());
            } catch (Exception e) {
                System.out.println(e.toString());

            }            
        }
    }          
    
    public void updateAll(Message men){
        for (int i = 0; i < hrs.size(); i++) {
            emit(hrs.get(i), men);
        }
    }
    
    public void emit(Socket cliente, Message men){
        try {
            HiloEnviar he = new HiloEnviar(cliente, men);  
            he.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(final String[] arguments) throws IOException {
        new PlantControl().iniciarServidor();
    }
}
