/**
 * Esta clase se encargará de crear un url para
 * luego hacer la petición al servidor de OpenWeatherMap
 */
public class Ticket{
    /*Latitud de la ciudad origen*/
    private String latitudOrigen;
    /*Longitud de la ciudad origen*/
    private String longitudOrigen;
    /*Código iata de la ciudad origen*/
    private String codeIataOrigen;
    /*Latitud de la ciudad destino*/
    private String latitudDestino;
    /*Longitud de la ciudad destino*/
    private String longitudDestino;
    /*Código iata de la ciudad destino*/
    private String codeIataDestino;

    public Ticket(String latitudOrigen, String longitudOrigen, String codeIataOrigen,
		  String latitudDestino, String longitudDestino, String codeIataDestino){
	this.latitudOrigen   = latitudOrigen;
	this.longitudOrigen  = longitudOrigen;
	this.codeIataOrigen  = codeIataOrigen;
	this.latitudDestino  = latitudDestino;
	this.longitudDestino = longitudDestino;
	this.codeIataDestino = codeIataDestino;
    }   
}
