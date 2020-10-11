package nuclearPlant.comunications;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import nuclearPlant.tools.IPScanner;
import java.util.ArrayList;
import nuclearPlant.elements.Plant;
import views.AdmConsole;

public class AdminManager {

    private Socket socket;
    private ArrayList<String> dirs;
    private int port;
    private AdmConsole consola;
    Plant planta;

    public AdminManager(AdmConsole consola) {

        this.consola = consola;
        this.port = IPScanner.getPort();
        HiloScanner elHilo = new HiloScanner();
        elHilo.start();
    }

    public class HiloScanner extends Thread {

        @Override
        public void run() {
            try {
                new IPScanner();
                IPScanner.checkHosts("192.168.56", consola.getLista());//////******192.168.1
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    };
    public class HiloOperacion extends Thread {

        @Override
        public void run() {
            try {
                new IPScanner();
                IPScanner.checkHosts("192.168.56", consola.getLista());//////******
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    };

    public void conect(String dirIP) {
        try {
            socket = new Socket(dirIP, this.port);
            socket.setSoTimeout(2000);
            socket.setKeepAlive(true);
            ObjectInputStream perEnt = new ObjectInputStream(socket.getInputStream());
            planta = (Plant) perEnt.readObject();            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public Plant getPlanta() {
        return planta;
    }
    
     
    
    
    public void disConect(){
        try{            
            socket.close();
        } catch(Exception e){
            System.out.println("Error al desconectar");
        }
    }

    public void emit(Message me) {
        try {            
            final ObjectOutputStream dos = new ObjectOutputStream(socket.getOutputStream());
            dos.writeObject(me);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
        

    public ArrayList<String> getDirs() {
        return this.dirs;
    }

    public int getPort() {
        return this.port;
    }
}
