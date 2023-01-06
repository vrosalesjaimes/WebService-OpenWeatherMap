package myp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Esta clase se encargará de crear un url para
 * luego hacer la petición al servidor de OpenWeatherMap
 */
public class Pe{
    /*Latitud de la ciudad*/
    private String latitud;
    /*Longitud de la ciudad*/
    private String longitud;
    /*Código iata de la ciudad*/
    private String codeIata;

    /**
     * Constructor de la clase Peticion.
     * @param codeIata, código iata de la ciudad para saber su estado de tiempo.
     * @param longitud, longitud de la ciudad para saber su estado de tiempo.
     * @param latitud, latitud de la ciudad para saber su estado de tiempo
     */
    public Peticion(String codeIata, String latitud, String longitud){
    	this.codeIata  = codeIata;
    	this.latitud   = latitud;
    	this.longitud  = longitud;
    }

    /**
     * Regresa el codigo iata de una petición.
     * @return codeIata, el código de la ciudad.
     */
    public String getCodeIata(){
	return codeIata;
    }

    /**
     * Hace una llamada al servidor de OpenWatherMap.
     * @param peticion, la peticion con la que llamaremos al servidor.
     * @return la representación en cadena de la respuesta del servidor.
     */
    public static String llamaServidor(Peticion peticion){
	if (!esValido(peticion))
		return "Error"; //Pendiente
	String urlString = "https://pro.openweathermap.org/data/2.5/onecall?lat=" + peticion.latitud + "&lon=" + peticion.longitud+ "&units=metric&exclude=hourly,daily,minutely&lang=sp&appid=5aac2dc7618e3fd43f31263400bc1788";
	String respuesta = new String();
	try{
	    URL url =  new URL(urlString);
	    URLConnection res = url.openConnection();
	    BufferedReader rd = new BufferedReader(new InputStreamReader(res.getInputStream()));
	    respuesta = rd.readLine();
	    rd.close();
	}catch(IOException e){
	    System.out.println(e.getMessage());
	}
	return respuesta;
    }

    /**
     * Da un formato a la respuesta del servidor con el fin de ser escrito en un archivo csv.
     * @param peticion, la peticion de la cual queremos convertir a una linea con comas.
     * @return representacion en cadena separada por comas de la respuesta del servidor.
     */
    public static String daFormatoCsv(Peticion peticion){
	String s = llamaServidor(peticion);
	if (s.equals("Error"))
		return "Error"; //Pendiente
	String[] respuesta = s.split(",");
	String temp = respuesta[7].replace("\"temp\":","") + "°C";
	String sensacion = respuesta[8].replace("\"feels_like\":","")+"°C";
	return temp+ ", " + sensacion + ",";
    }

	/**
	 * Analiza una instancia de {@link Peticion} y devuelve {@code true} si su
	 * latitud y longitud es válida, {@code false} en otro caso.
	 * @param p la petición a analizar,
	 * @return {@code true} si la longitud y latitud de la petición es válida,
	 * 		   {@code false} en caso contrario.
	 */
	private static boolean esValido(Peticion p){
		double latitud, longitud;
		try{
			latitud = Double.parseDouble(p.latitud);
			longitud = Double.parseDouble(p.longitud);
		} catch (NumberFormatException nfe) {
			return false;
		}
		if (latitud < -90 || latitud > 90)
			return false;
		if (longitud < -180 || longitud > 180)
			return false;
		return true;
	}
}
