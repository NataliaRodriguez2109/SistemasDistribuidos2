/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuclearPlant.elements;

import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author nata_
 */
public class Reactor implements Serializable{
    private boolean switchedOn;
    private int charge;
    
    private State state = new State();

    public Reactor() {
        charge = 0;
        switchedOn = false;
    }

    public boolean isSwitchedOn() {
        return switchedOn;
    }

    public void setSwitchOn(boolean switchedOn) {
        this.switchedOn = switchedOn;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public boolean turnOn() {
        switchedOn = true;
        return switchedOn;
    }
    
    public boolean turnOff() {
        switchedOn = false;            
        return switchedOn;
    }
    
    
    public void repair() {
        state.changeLabel();
    }

    public State getState() {
        return state;
    }
    
    
    public int chargeReactor(int value) {
        if (switchedOn == true){
                
                charge = charge + value;   
                if(charge > 100){
                    dañar();
                }
        }else {
            JOptionPane.showMessageDialog(null, "El reactor se encuentra apagado, debe encender antes de cargar", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        return charge;
    }
    
    public void dañar(){
        state.changeLabel();
        //charge = 0;
    }
    
    public int dischargeReactor(int value) {
        if (switchedOn == true) {
                if (charge == 0) {
                JOptionPane.showMessageDialog(null, "El reactor ya está completamente descargado", "Error", JOptionPane.WARNING_MESSAGE);
            } else
            {
                if((charge - value) < 0){
                    charge = 0;
                    JOptionPane.showMessageDialog(null, "La carga es de: " + charge + "% el valor ingresado es demasiado alto", "Error", JOptionPane.WARNING_MESSAGE);
                }else {
                    charge = charge - value; 
                }
                   
            }
        }else {
            JOptionPane.showMessageDialog(null, "El reactor se encuentra apagado, debe encender antes de descargar", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return charge;
    }
}
