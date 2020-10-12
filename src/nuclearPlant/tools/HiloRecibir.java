/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuclearPlant.tools;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import nuclearPlant.comunications.AdminManager;
import nuclearPlant.comunications.Message;
import nuclearPlant.comunications.MessageProtocol;
import nuclearPlant.comunications.PlantControl;
import nuclearPlant.elements.Plant;
import views.AdmConsole;

/**
 *
 * @author Jesus David Otero
 */
public class HiloRecibir extends Thread {

    private Socket cliente;
    private Plant planta;
    private Message men;
    private AdmConsole adm;
    private PlantControl control;

    public HiloRecibir(Socket cliente, Plant planta, PlantControl control) {
        this.cliente = cliente;
        this.planta = planta;
        this.control = control;
    }

    public HiloRecibir(Socket cliente, Plant planta, AdmConsole adm) {
        this.cliente = cliente;
        this.planta = planta;
        this.adm = adm;
    }

    @Override
    public void run() {
        while (true) {
            try {
                ObjectInputStream obj = new ObjectInputStream(cliente.getInputStream());
                men = (Message) obj.readObject();
                System.out.println(men.getContenido()[0]);
                if (control == null) {
                    MessageProtocol.interpretar(planta, men, adm);
                } else {
                    MessageProtocol.interpretar(planta, men, control);
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }

    }

    public Socket getCliente() {
        return cliente;
    }

    public Plant getPlanta() {
        return planta;
    }

    public Message getMen() {
        return men;
    }

}
