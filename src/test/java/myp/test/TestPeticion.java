package src.test.java.myp.test;

import myp.Peticion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * Clase para pruebas unitarias de la clase {@link Peticion}.
 */
public class TestPeticion {

    /** Expiración para que las pruebas no duren más de 5 segundos. */
    @Rule public Timeout timeout = Timeout.seconds(5);

    /* Una petición. */
    private Peticion peticion;

    /**
     * Crea una peticion.
     */
    public TestPeticion() {
	String latitud = "19.3371";
	String longitud = "-99.566";
	String codigoIata = "TLC";
	peticion = new Peticion(codigoIata, latitud, longitud);
    }

    /**
     * Prueba unitaria para {@link Peticion#llamaServidor}.
     */
     @Test public void testLlamaServidor() {
	String s = "{\"lat\":19.3371,\"lon\":-99.566,\"timezone\":\"America/Mexico_City\",\"timezone_offset\":-21600,\"current\":{\"dt\":1646954973,\"sunrise\":1646916644,\"sunset\":1646959590,\"temp\":22,\"feels_like\":20.67,\"pressure\":1024,\"humidity\":16,\"dew_point\":-4.39,\"uvi\":1.5,\"clouds\":0,\"visibility\":10000,\"wind_speed\":2.06,\"wind_deg\":210,\"weather\":[{\"id\":711,\"main\":\"Smoke\",\"description\":\"humo\",\"icon\":\"50d\"}]}}";
	String latitud = "\"lat\":";
	String longitud = "\"lon\":";
	String temperatura = "\"temp\":";
	String descripcion = "\"description\":";
	String json = Peticion.llamaServidor(peticion);
	Assert.assertFalse(json.equals(""));
	Assert.assertTrue(json.contains(latitud));
	Assert.assertTrue(json.contains(longitud));
	Assert.assertTrue(json.contains(temperatura));
	Assert.assertTrue(json.contains(descripcion));
    }

    /**
     * Prueba unitaria para {@link Peticion#daFormatoCsv}.
     */
     @Test public void testDaFormatoCsv() {
	String temperatura = "\"temp\":";
	String sensacion = "\"feels_like\":";
	String descripcion = "\"description\":";
	String json = Peticion.daFormatoCsv(peticion);
	Assert.assertFalse(json.equals(""));
	json = json.replaceAll("°", "");
	json = json.replaceAll(",", "");
	json = json.replaceAll(".", "");
	json = json.replaceAll(" ", "");
	json = json.replaceAll("/[A-Za-z0-9]/", "");
	Assert.assertTrue(json.equals(""));
    }

}
