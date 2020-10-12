/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuclearPlant.comunications;

import nuclearPlant.comunications.Message;
import nuclearPlant.elements.Plant;
import nuclearPlant.elements.Reactor;

/**
 *
 * @author Jesus David Otero
 */
public class MessageProtocol {
    
    public static void interpretar(Plant planta, Message message){
        Reactor r = planta.getReactor(Integer.parseInt(message.getContenido()[0]));
        if (message.getContenido()[1].equals("cargar")) {
            r.chargeReactor(Integer.parseInt(message.getContenido()[2]));
        } else if (message.getContenido()[1].equals("descargar")) {
            r.dischargeReactor(Integer.parseInt(message.getContenido()[2]));
        } else if (message.getContenido()[1].equals("encender")) {
            r.turnOn();
        } else if (message.getContenido()[1].equals("apagar")) {
            r.turnOff();
        } else if (message.getContenido()[1].equals("reparar")) {
            r.repair();
        }
    }
    
}
