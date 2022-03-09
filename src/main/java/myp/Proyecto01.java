import java.util.concurrent.ConcurrentHashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Proyecto01{
    static HashMap<String, String> cache = new HashMap<String, String>();
    
    public void procesaCsv(String archivo){
	try{
	    BufferedReader csv = new BufferedReader(new FileReader(archivo));
	    BufferedWriter out = new BufferedWriter(
                                     new OutputStreamWriter(
				         new FileOutputStream("../../../../salida.csv")));
	    String linea;
	    while((linea = csv.readLine()) != null){
		String[] viaje = linea.split(",");
		Peticion origen = new Peticion(viaje[0], viaje[2], viaje[3]);
		Peticion destino = new Peticion(viaje[1], viaje[4], viaje[5]);
		out.write(esUnaPeticionRepetida(origen) + "," + esUnaPeticionRepetida(destino));
	    }
	    out.close();
	}catch(IOException ioe){
	}
    }

    public static String esUnaPeticionRepetida(Peticion p){
	if(cache.containsKey(p.getCodeIata())){
	    return cache.get(p.getCodeIata());
	}
	else{
	    cache.put(p.getCodeIata(), p.getCodeIata()+ "," + Peticion.daFormatoCsv(p));
	    return cache.get(p.getCodeIata());
	}
    }
    
    public static void main(String[] args) {
	
    }
}
