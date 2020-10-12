/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuclearPlant.tools;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import nuclearPlant.comunications.Message;
import nuclearPlant.comunications.MessageProtocol;
import nuclearPlant.elements.Plant;

/**
 *
 * @author Jesus David Otero
 */
public class HiloRecibir extends Thread {

    Socket cliente;
    Plant planta;

    public HiloRecibir(Socket cliente, Plant planta) {
        this.cliente = cliente;
        this.planta = planta;
    }

    @Override
    public void run() {

        try {
            ObjectInputStream obj = new ObjectInputStream(cliente.getInputStream());
            Message men = (Message) obj.readObject();
            System.out.println(men.getContenido()[0]);
            MessageProtocol.interpretar(planta, men);            
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public Socket getCliente() {
        return cliente;
    }

    public Plant getPlanta() {
        return planta;
    }
}
