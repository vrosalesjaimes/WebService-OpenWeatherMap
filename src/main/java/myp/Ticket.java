import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.*;
import com.google.gson.reflect.*;
/**
 * Esta clase se encargará de crear un url para
 * luego hacer la petición al servidor de OpenWeatherMap
 */
public class Ticket{
    /*Latitud de la ciudad*/
    private String latitud;
    /*Longitud de la ciudad*/
    private String longitud;
    /*Código iata de la ciudad*/
    private String codeIata;

    //Constructor
    public Ticket(String latitud, String longitud, String codeIata){
	this.latitud   = latitud;
	this.longitud  = longitud;
	this.codeIata  = codeIata;
    }

    /**
     * Hacemos la petición y la guardamos ne un StringBuffer, en el video que vi
     * hacía con StringBuilder, pero ví que con StringBuffer es que tiene su métodos 
     * sincronizados y podemos trabajar con varios hilos.
     */
    public StringBuffer peticion(Ticket ticket){
	String urlString = "https://api.openweathermap.org/data/2.5/onecall?lat=" + ticket.latitud + "&lon=" + ticket.longitud+ "&units=metric&exclude=hourly,daily,alerts,minutely&lang=sp&appid=5aac2dc7618e3fd43f31263400bc1788";
	 StringBuffer respuesta = new StringBuffer();
	try{
	    URL url =  new URL(urlString);
	    URLConnection res = url.openConnection();
	    BufferedReader rd = new BufferedReader(new InputStreamReader(res.getInputStream()));
	    String line;
	    while((line = rd.readLine()) != null){
		respuesta.append(line);
            }
	    rd.close();
	}catch(IOException e){
	    System.out.println(e.getMessage());
	}
	return respuesta;

    }

    /**
     * En este método le daremos formato a la respuesta del servidor
     */
    public Map<String, Object> jsonToMap(String str){
	Map<String, Object> map = new Gson().fromJson(					                        str, new TypeToken<HashMap<String, Object>>() {}.getType()
														);
	return map;
    }
}
