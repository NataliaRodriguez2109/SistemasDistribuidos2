/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuclearPlant.elements;

import java.io.Serializable;

/**
 *
 * @author Jesus David Otero
 */
public class Plant implements Serializable{    
    private Reactor reactores[];

    public Plant() {
        this.reactores = new Reactor[3];
        reactores[0] = new Reactor();
        reactores[1] = new Reactor();
        reactores[2] = new Reactor();
    }

    public Reactor[] getReactores() {
        return reactores;
    }

    public void setReactores(Reactor[] reactores) {
        this.reactores = reactores;
    }
    
    public Reactor getReactor(int pos){
        return reactores[pos];
    }
    
       
}
