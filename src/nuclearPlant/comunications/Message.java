/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuclearPlant.comunications;

import java.io.Serializable;

public class Message implements Serializable{

    String contenido[] = new String[4];

    public Message(String[] contenido) {
        this.contenido = contenido;
    }
    

    public String[] getContenido() {
        return contenido;
    }

    public void setContenido(String[] contenido) {
        this.contenido = contenido;
    }

}
