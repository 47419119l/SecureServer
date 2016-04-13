
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
// java -Djavax.net.ssl.keyStore=millave -Djavax.net.ssl.trustStore=millave -Djavax.net.ssl.keyStorePassword=dionis SecureClient

/**
 * Created by 47419119l on 13/04/16.
 */
public class SecureClient {
    /**
     * Metodo main s'inicia al executar la clase
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println("client");
        SSLSocketFactory ssf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        System.out.println("client");
        SSLSocket cliente = (SSLSocket) ssf.createSocket();
        InetSocketAddress address = new InetSocketAddress("localhost", 5556);
        cliente.connect(address);
        OutputStream os = cliente.getOutputStream();
        System.out.println("enviat");
        String mensage = "2+2";
        os.write(mensage.getBytes());
        cliente.close();
    }

}
