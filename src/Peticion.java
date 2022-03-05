import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class Peticion{
    public static void main(String[] args){
	try{
	String API_KEY =  "5aac2dc7618e3fd43f31263400bc1788";
	String LOCATION = "Raleigh,NC";
	String urlString =  "https://api.openweathermap.org/data/2.5/onecall?lat=33.44&lon=-94.04&units=metric&exclude=hourly,daily,alerts,minutely&lang=sp&appid=5aac2dc7618e3fd43f31263400bc1788";

	StringBuilder resultado = new StringBuilder();
	URL url = new URL(urlString);
	URLConnection conn = url.openConnection();
	BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	String line;
	while((line = rd.readLine()) != null){
	    resultado.append(line);
	}
	rd.close();
	System.out.println(resultado);
    }catch(IOException e){
	System.out.println(e.getMessage());
    }
    }
}
