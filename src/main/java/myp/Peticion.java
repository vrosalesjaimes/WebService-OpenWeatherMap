package myp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Esta clase se encargará de crear una petición
 * y así llamar al servidor de OpenWeatherMap
 */
public class Peticion {

	/*Latitud de la ciudad*/
    private String latitud;
    /*Longitud de la ciudad*/
    private String longitud;
    /*Código iata de la ciudad*/
    private String codigoIata;

    /**
     * Constructor 
     * @param codigoIata, código Iata de la petición.
     * @param latitud, longitud de la petición.
     * @param longitud, longitud de la petición.
     */
    public Peticion(String codigoIata, String latitud, String longitud){
    	this.codigoIata  = codigoIata;
    	this.latitud   = latitud;
    	this.longitud  = longitud;
    }
    
    /**
     * Regresa la latitud de la petición.
     * @return la latitud de la petición.
     */
	public String getLatitud() {
		return latitud;
	}

	/**
	 * Cambia el valor de la latitud.
	 * @param latitud, la nueva latitud.
	 */
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	/**
	 * Regresa la longitud de la petición. 
	 * @return la longitud de la petición.
	 */
	public String getLongitud() {
		return longitud;
	}

	/**
	 * Cambia el valor de la longitud.
	 * @param longitud, la nueva longitud.
	 */
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	/**
	 * Regresa el código iata de la petición. 
	 * @return el código iata de la petición.
	 */
	public String getCodigoIata() {
		return codigoIata;
	}

	/**
	 * Cambia el valor de código iata.
	 * @param codigoIata, el nuevo código iata.
	 */
	public void setCodigoIata(String codigoIata) {
		this.codigoIata = codigoIata;
	}
	
	/**
	 * Regresa true si la petición es válida, falso en otro caso
	 * @return {@code true} si la longitud y latitud de la petición es válida,
	 * 		   {@code false} en caso contrario.
	 */
	public boolean esValido(){
		double latitud, longitud;
		
		try{
			latitud = Double.parseDouble(this.latitud);
			longitud = Double.parseDouble(this.longitud);
		} catch (NumberFormatException nfe) {
			return false;
		}
		
		if (latitud < -90 || latitud > 90)
			return false;
		if (longitud < -180 || longitud > 180)
			return false;
		
		return true;
	}
	
	/**
	 * Hace una petición al servidor de OpenWeatherMap.
	 * @return, regresa una Respuesta.
	 * @throws Exception
	 */
	public Respuesta get() throws Exception {
		if (!this.esValido()) {
			throw new Exception("La petición no es válida");
		}
		
		String urlString = "https://api.openweathermap.org/data/2.5/onecall?lat=" + this.latitud + "&lon=" + this.longitud+ "&units=metric&exclude=hourly,daily,minutely&lang=sp&appid=5aac2dc7618e3fd43f31263400bc1788";
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
		
		return new Respuesta(respuesta);
	}
	
	/**
	 * Regresa una representación en cadena de una petición.
	 * @return una representación en cadena de una petición.
	 */
	@Override
	public String toString() {
		String s = "";
		try {
			Respuesta r = this.get();
			s = this.codigoIata + "," + r.toString();
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error inesperado");
			System.exit(-1);
		}
		return s;
	}
}
