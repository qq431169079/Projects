import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.net.ssl.SSLSocket;

public class WorkerRunnable implements Runnable {

    protected SSLSocket clientSocket = null;
    protected String 	serverText   = null;

    public WorkerRunnable(SSLSocket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText   = serverText;
    }

    public void run() {
        try {
            InputStream input  = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            Scanner inputScanner = new Scanner(input);
            
            while (inputScanner.hasNext())
            	System.out.println(inputScanner.next());
            
            //long time = System.currentTimeMillis();
            output.write(("HTTP/1.1 200 OK\n\nWorkerRunnable: " + this.serverText).getBytes());
            //output.close();
            //input.close();
            //System.out.println("Request processed: " + time);
        } catch (IOException e) {
            //report exception somewhere.
            e.printStackTrace();
        }
    }
}
