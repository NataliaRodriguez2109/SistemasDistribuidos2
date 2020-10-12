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
    private ArrayList<HiloRecibir> hrs;

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

    public void iniciarServidor() {
        while (true) {
            try {
                final Socket cliente = this.servidor.accept();
                
                ObjectOutputStream obj = new ObjectOutputStream(cliente.getOutputStream());
                obj.writeObject(planta);
                HiloRecibir hr = new HiloRecibir(cliente, this.planta);
                hr.run();
                hrs.add(hr);
                iniciarServidor();
                System.out.println(hrs.size());
            } catch (Exception e) {
                System.out.println(e.toString());

            }
        }
    }          
    
    
    public void emit(Socket cliente, Message men){
        try {
            HiloEnviar he = new HiloEnviar(cliente, men);                        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(final String[] arguments) throws IOException {
        new PlantControl().iniciarServidor();
    }
}
