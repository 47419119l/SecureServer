import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;

/**
 * Created by 47419119l on 13/04/16.
 */
// java -Djavax.net.ssl.keyStore=millave -Djavax.net.ssl.trustStore=millave -Djavax.net.ssl.keyStorePassword=dionis SecureClient

public class SecureServer {
    /**
     * Metode que s'inicia al executar la classe.
     * @param args
     */
    public static void main(String[] args)throws IOException
    {
        boolean guay = true;

        System.out.println("obtenint factoria servidor");
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        System.out.println("Creant socket servidor");
        SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket();
        System.out.println("BINDING");
        InetSocketAddress address = new InetSocketAddress("0.0.0.0", 5556);
        serverSocket.bind(address);

            /**
             * Aquí és donde el servidor se quedará escoltat
             */

        while(guay){
            SSLSocket ss = (SSLSocket) serverSocket.accept();
            ServerSecureHilo th = new ServerSecureHilo(ss);
            th.start();

        }
        System.out.println("Tancat!");
        serverSocket.close();

    }
}
