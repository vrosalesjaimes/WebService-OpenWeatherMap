package myp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Proyecto01{
    /*Cache de peticiones*/
    static HashMap<String, String> cache = new HashMap<String, String>();

    /**
     * Lee un archivo de tipo csv, crea dos objectos de tipo Peticion
     * para imprimir una linea con el clima de la ciudad origen y ciudad destino.
     * @param archivo, el nombre del archivo.
     */
    private static void procesaCsv(String archivo){
	try{
	    BufferedReader csv = new BufferedReader(new InputStreamReader(new FileInputStream(archivo)));
	    BufferedWriter out = new BufferedWriter(
				     new OutputStreamWriter(
					 new FileOutputStream("salida.csv")));
	    out.write("Origen, Temperatura, Sensación térmica, Destino, Temperatura, Sensación términa" + "\n");
	    String linea = csv.readLine();
	    while((linea = csv.readLine()) != null){
		String[] viaje = linea.split(",");
		Peticion origen = new Peticion(viaje[0].trim(), viaje[2], viaje[3]);
		Peticion destino = new Peticion(viaje[1].trim(), viaje[4], viaje[5]);
		out.write(esUnaPeticionRepetida(origen) + esUnaPeticionRepetida(destino)+ "\n");
	    }
	    out.close();
	} catch(IOException ioe) {
	}
    }

    /**
     * Revisa si ya se ha creado un objecto de tipo Peticiony se ha añadido al cache, 
     * en caso de que no lo añade.
     * @param peticion, la peticion a buscar o añadir al cache.
     * @return representación en cadena separado por comas del estado de
     * tiempo en lasss ciudades de origen y destino.
     */
    private static String esUnaPeticionRepetida(Peticion p){
	if(cache.containsKey(p.getCodeIata())){
	    return cache.get(p.getCodeIata());
	}
	else{
	    cache.put(p.getCodeIata(), p.getCodeIata()+ "," + Peticion.daFormatoCsv(p));
	    return cache.get(p.getCodeIata());
	}
    }


    public static void main(String[] args) {
	Runnable runnable = new Runnable() {
		@Override public void run() {
		    while (true) {
			try {
			    Thread.sleep(360000);
			    procesaCsv("dataset1.csv");
			} catch (InterruptedException e) {
			    System.out.println("Algo inesperado ha ocurrido");
			    System.exit(1);
			}
		    }
		}
	    };
	Thread hilo = new Thread(runnable);
	hilo.start();
	procesaCsv("dataset1.csv");
    }
}
