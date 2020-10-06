/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuclearPlant.elements;

import java.io.IOException;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketException;
import nuclearPlant.comunications.Message;

public class PlantControl {

    private ServerSocket servidor;
    private Plant planta;

    public PlantControl() {
        this.servidor = null;
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
                cliente.close();
            } catch (Exception e) {
                System.out.println(e.toString());
                continue;
            }
        }
    }

    public void interpretar(Message me) {
        Reactor r = planta.getReactor(Integer.parseInt(me.getContenido()[0]));
        if (me.getContenido()[1].equals("cargar")) {
            r.chargeReactor(Integer.parseInt(me.getContenido()[2]));
        } else if (me.getContenido()[1].equals("descargar")) {
            
        } else if (me.getContenido()[1].equals("encender")) {
            r.turnOn();
        } else if (me.getContenido()[1].equals("apagar")) {

        } else if (me.getContenido()[1].equals("reparar")) {

        }
    }

    public static void main(final String[] arguments) throws IOException {
        new PlantControl().iniciarServidor();
    }
}
