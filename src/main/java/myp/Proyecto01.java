package myp;

import java.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Proyecto01{

    static HashMap<String, String> cache = new HashMap<String, String>();

    private static void procesaCsv(String archivo){
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
	} catch(IOException ioe) {
	}
    }

    private static String esUnaPeticionRepetida(Peticion p){
	if(cache.containsKey(p.getCodeIata())){
	    return cache.get(p.getCodeIata());
	}
	else{
	    cache.put(p.getCodeIata(), p.getCodeIata()+ "," + Peticion.daFormatoCsv(p));
	    return cache.get(p.getCodeIata());
	}
    }

    private static String leerCsv(String nombreArchivo) {
	String csv = "";
	String auxiliar = "";
	try {
	    File f = new File(nombreArchivo);
	    String ruta = f.getAbsolutePath();
	    FileInputStream fileIn = new FileInputStream(nombreArchivo);
	    InputStreamReader isIn = new InputStreamReader(fileIn);
	    BufferedReader in = new BufferedReader(isIn);
	    auxiliar = in.readLine();
	    while(auxiliar != null) {
		csv = csv + "," + auxiliar;
		auxiliar = in.readLine();
	    }
	    in.close();
	} catch(IOException ioe) {
	    System.out.println(ioe.getMessage());
            System.exit(1);
	}
	return csv;
    }

    public static void main(String[] args) {
	String nombreCsv = "dataset2.csv";
        String archivo = leerCsv(nombreCsv);
	System.out.println(archivo);
    }
}
