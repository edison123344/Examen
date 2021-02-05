package ExamenFinal.Fereteria.On;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;


import ExamenFinal.Fereteria.Modelo.Provedor;

/**
 * clase que visualisara el stok
 * @author edison
 *
 */
@Stateless
public class GestionProvedorON {


public Provedor ListarProvedorCodigo(int codigo) throws Exception{
	try {

        URL url = new URL("http://localhost:8080/Fereteria/ws/Provedores/listarPrvedores?Codigo="+codigo);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("Get");
        conn.setRequestProperty("Content-Type", "application/json");

        //String input = ;
        OutputStream os = conn.getOutputStream();
        //os.
        //os.flush();

        if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
            throw new RuntimeException("Failed : HTTP error code : "
                + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }

        conn.disconnect();

      } catch (MalformedURLException e) {

        e.printStackTrace();

      } catch (IOException e) {

        e.printStackTrace();

        }
	return null;
}
}
