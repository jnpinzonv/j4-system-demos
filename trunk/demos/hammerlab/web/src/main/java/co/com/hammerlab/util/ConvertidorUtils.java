/**
 * 
 */
package co.com.hammerlab.util;

/**
 * Clase encargada de almacenar las distintas utilidades empleadas en cuanto a
 * convertir datos
 * 
 * @author Luis Arturo Zárate Ayala <luisarturo1989@gmail.com>
 */
public class ConvertidorUtils {
	
	private static final char UNDERSCORE = '_';
	
	private static final char ESPACIO = ' ';

	/**
	 * Método encargado de convertir a cadenas un numero ingresado
	 * @param numero, numero ingresado
	 * @return valor en cadenas
	 */
	public static String convertirACadenas(Long numero){
		if (numero != null) {
			return numero.toString();
		}
		return null;
	}
	
	/**
	 * Método encargado de convertir los espacios en guiones bajos
	 * @param datos, el valor a cambiar
	 * @return los datos reemplazando los espacios con guiones bajos
	 */
	public static String convertirEspaciosAUnderscore(String datos){
		if (datos!=null && !datos.trim().equals("")) {
			return datos.replace(ESPACIO, UNDERSCORE);
		}
		return null;
	}
	
}
