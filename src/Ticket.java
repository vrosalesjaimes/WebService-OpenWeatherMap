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

    public Ticket(String latitud, String longitud, String codeIata){
	this.latitud   = latitud;
	this.longitud  = longitud;
	this.codeIata  = codeIata;
    }

    public StringBuffer peticion(Ticket ticker){
	String urlString = "https://api.openweathermap.org/data/2.5/onecall?lat=" + p.latitud + "&lon=" + p.longitud+ "&units=metric&exclude=hourly,daily,alerts,minutely&lang=sp&appid=5aac2dc7618e3fd43f31263400bc1788";
	try{
	    StringBuffer resultado = new StringBuffer();
	    URL url =  new URL(urlString);
	    URLConnection res = url.openConnection();
	    BufferedReader rd = new BufferedReader(new InputStreamReader(res.getInputStream()));
	    while((line = rd.readLine()) != null){
		resultado.append(line);
            }
	    rd.close();
	    return resultado;
	}catch(IOException e){
	    System.out.println(e.getMessage());
	}
	return respuesta;

    }

    public 
}
