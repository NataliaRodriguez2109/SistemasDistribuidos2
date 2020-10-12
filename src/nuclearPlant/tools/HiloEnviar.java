/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuclearPlant.tools;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import nuclearPlant.comunications.Message;
import nuclearPlant.comunications.MessageProtocol;
import nuclearPlant.elements.Plant;

/**
 *
 * @author Jesus David Otero
 */
public class HiloEnviar extends Thread {

    private Socket cliente;
    private Message men;

    public HiloEnviar(Socket cliente, Message men) {
        this.cliente = cliente;
        this.men = men;
    }

    @Override
    public void run() {
        try {            
            ObjectOutputStream obj = new ObjectOutputStream(cliente.getOutputStream());
            obj.writeObject(men);
            stop();
        } catch (Exception e) {
            System.out.println(e.getMessage() + "hola");
        }
    }

    public Socket getCliente() {
        return cliente;
    }
};
