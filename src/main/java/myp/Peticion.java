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
     * Constructor de la clase Peticion.
     * @param codeIata, código iata de la ciudad para saber su estado de tiempo.
     * @param longitud, longitud de la ciudad para saber su estado de tiempo.
     * @param latitud, latitud de la ciudad para saber su estado de tiempo
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
	public String getCodeIata() {
		return codigoIata;
	}

	/**
	 * Cambia el valor de código iata.
	 * @param codeIata, el nuevo código iata.
	 */
	public void setCodeIata(String codigoIata) {
		this.codigoIata = codigoIata;
	}
}
