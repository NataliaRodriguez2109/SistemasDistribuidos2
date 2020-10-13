/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author nata_
 */
public class EmptyValueException extends RuntimeException{

    public EmptyValueException(String mesg) {
        super(mesg);
    }
}
