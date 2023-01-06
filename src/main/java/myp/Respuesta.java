package myp;

import org.json.JSONObject;
import org.json.JSONException;

/**
 * Clase que representa una respuesta de una petición
 */
public class Respuesta {
	/* La repuesta de la petición*/
	private String respuesta;
	
	/**
	 * Constructor
	 * @param respuesta, al respuesta.
	 */
	public Respuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	/**
	 * Regresa la respuesta del objeto.
	 * @return la respuesta del objeto.
	 */
	public String getRespuesta() {
		return respuesta;
	}

	/**
	 * Cambia la respuesta.
	 * @param respuesta, la nueva respuesta.
	 */
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
	/**
	 * Crea a partir de una cadena un json.
	 * @return la respuesta en formato json.
	 */
	public JSONObject aJson() {
		try {
			JSONObject json = new JSONObject(this.respuesta);
			return json;
		} catch (JSONException err) {
            System.out.println("Ha ocurrido un error");
            System.exit(-1);
		}
		return null;
	}

	/**
	 * Regresa una representación en cadena de la respuesta.
	 * @return una representación en cadena de la respuesta.
	 */
	@Override
	public String toString() {
		JSONObject json = this.aJson();
		JSONObject current = json.getJSONObject("current");
		String temperatura = current.getDouble("temp") + "°C";
		String sensacion = current.getDouble("feels_like") + "°C";
		return temperatura + "," + sensacion + ",";
		
	}
}
