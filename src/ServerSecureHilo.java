import javax.net.ssl.SSLSocket;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by 47419119l on 13/04/16.
 */
public class ServerSecureHilo extends Thread {
    SSLSocket socketescuchado;

    public ServerSecureHilo(SSLSocket s){
        socketescuchado = s;
    }
    @Override
    public void run() {
        try {
            InputStream is = socketescuchado.getInputStream();
            byte[] mensaje = new byte[25];
            is.read(mensaje);
            OutputStream os = socketescuchado.getOutputStream();
            System.out.println(socketescuchado.getInetAddress().toString());
            System.out.println("Operació rebuda : "+new String(mensaje));
            System.out.println("Resposta : "+calcular(new String(mensaje)));


        }catch (Exception e){

        }
    }
    /**
     * Metode per calcular.
     * @param operacio -Operació amb String
     * @return - String amb solució
     */
    public static String calcular(String operacio)
    {
        String [] ok =operacio.split(",");
        double  num1 = Double.parseDouble(ok[0]);
        String operador = String.valueOf(ok[1].charAt(0));
        double num2 = Double.parseDouble(ok[1].replace(operador,""));

        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String result = "No es pot fer aquest càlcul";
        try {
            result = engine.eval(num1+operador+num2).toString();
        }
        catch (ScriptException e) {

        }
        return result;
    }

}
