/**
 * 
 */
package co.com.hammerlab.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase encargada de almacenar las distintas utilidades empleadas en cuanto a fechas
 * @author Luis Arturo Zárate Ayala <luisarturo1989@gmail.com> 
 */
public class FechaUtils {
	
	/**
	 * Constante encargada de almacena el formato dd/MM/yyyy
	 */
	private static final String FORMATO_FECHA = "dd/MM/yyyy";

	/**
	 * Método encargado de formatear la fecha conforme a la constante FORMATO_FECHA
	 * @param fecha, Fecha a formatear
	 * @return fecha formateada
	 */
	public static String formatearfecha(Date fecha) {
		if (fecha != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat(FORMATO_FECHA);			
			return dateFormat.format(fecha);
		}
		return null;
	}
}
