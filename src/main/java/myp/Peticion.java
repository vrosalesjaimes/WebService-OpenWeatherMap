package myp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Esta clase se encargará de crear un url para
 * luego hacer la petición al servidor de OpenWeatherMap
 */
public class Peticion{
    /*Latitud de la ciudad*/
    private String latitud;
    /*Longitud de la ciudad*/
    private String longitud;
    /*Código iata de la ciudad*/
    private String codeIata;

    //Constructor
    public Peticion(String codeIata, String latitud, String longitud){
	this.codeIata  = codeIata;
	this.latitud   = latitud;
	this.longitud  = longitud;
    }

    public String getCodeIata(){
	return codeIata;
    }

    /**
     * Hacemos la petición y la guardamos en un StringBuffer, en el video que vi
     * hacía con StringBuilder, pero ví que con StringBuffer es que tiene su métodos
     * sincronizados y podemos trabajar con varios hilos.
     */
    public static String llamaServidor(Peticion p){
	String urlString = "https://pro.openweathermap.org/data/2.5/onecall?lat=" + p.latitud + "&lon=" + p.longitud+ "&units=metric&exclude=hourly,daily,minutely&lang=sp&appid=5aac2dc7618e3fd43f31263400bc1788";
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

    public static String daFormatoCsv(Peticion p){
	String s = llamaServidor(p);
	String[] respuesta = s.split(",");
	String temp = respuesta[7].replace("\"temp\":","") + "°C";
	String sensacion = respuesta[8].replace("\"feels_like\":","")+"°C";
	String descripcion =  respuesta[20].replaceAll("\"description\":","").replace("\"","");
	return temp+ ", " + sensacion + ", " + descripcion + ",";
    }
}
