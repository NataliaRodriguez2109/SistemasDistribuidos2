/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuclearPlant.elements;

import java.io.IOException;
import java.net.Socket;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;

public class PlantControl
{
    private ServerSocket servidor;
    private Plant planta;
    
    public PlantControl() {
        this.servidor = null;
        try {
            final InetAddress direccion = InetAddress.getLocalHost();
            this.planta = new Plant();
        }
        catch (Exception ex) {}
        try {
            this.servidor = new ServerSocket(32645);
        }
        catch (Exception ex2) {}
    }
    
    public void iniciarServidor() {
        while (true) {
            try {
                String nombreArchivo;
                do {
                    final Socket cliente = this.servidor.accept();
                    final DataInputStream dis = new DataInputStream(cliente.getInputStream());
                    nombreArchivo = dis.readUTF().toString();
                    final int tam = dis.readInt();
                    final byte[] buffer = new byte[tam];
                    cliente.close();
                } while (!nombreArchivo.contains("secci"));
            }
            catch (Exception e) {
                System.out.println(e.toString());
                continue;
            }
            break;
        }
    }
    
    public static void main(final String[] arguments) throws IOException {
        new PlantControl().iniciarServidor();
    }
}