package nuclearPlant.comunications;

import java.io.DataOutputStream;
import java.net.Socket;
import nuclearPlant.tools.IPScanner;
import java.util.ArrayList;

public class ConsolaAdmin
{
    private ArrayList<String> dirs;
    private int port;
    
    public ConsolaAdmin() {
        new IPScanner();
        this.port = IPScanner.getPort();
        try {
            new IPScanner();
            this.dirs = (ArrayList<String>)IPScanner.checkHosts("25.109.206");
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public void emit(final String dirIP) {
        try {
            final Socket socket = new Socket(dirIP, this.port);
            socket.setSoTimeout(2000);
            socket.setKeepAlive(true);
            final String cadena = "hola";
            final DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeChars(cadena);
            socket.close();
        }
        catch (Exception e) {
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
