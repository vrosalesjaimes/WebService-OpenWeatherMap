package myp;

import java.util.HashMap;

/**
 * Clase que representa un Caché.
 */
public class Cache {
	/*Colección del cache*/
	private HashMap<String,String> cache;

	/**
	 * Constructor
	 */
	public Cache() {
		this.cache = new HashMap<String,String>();
	}

	/**
	 * Regresa el diccionario que contiene al caché.
	 * @return el diccionario que contiene al caché.
	 */
	public HashMap<String, String> getCache() {
		return cache;
	}

	/**
	 * Cambia el diccionario que contiene al caché.
	 * @param cache, el nuevo caché.
	 */
	public void setCache(HashMap<String, String> cache) {
		this.cache = cache;
	}
	
	/**
	 * Regresa el elemento identificado con la llave key.
	 * @param key, la llave del valor buscado.
	 * @return el valor de la llave key.
	 */
	public String get(String key) {
		return this.cache.get(key);
	}
	
	/**
	 * Agrega un elemento al caché.
	 * @param key, la llave del nuevo elemento en el caché.
	 * @param value, el valor del nuevo elemento en el caché.
	 */
	public void put(String key, String  value) {
		this.cache.put(key,value);
	}
	
	/**
	 * Regresa true si exise un elemento con la llave proporcionada, 
	 * false en otro caso.
	 * @param key, la llave que se busca en el cache.
	 * @return el elemento de la llave key.
	 */
	public boolean containsKey(String key) {
		return this.cache.containsKey(key);
	}

}
