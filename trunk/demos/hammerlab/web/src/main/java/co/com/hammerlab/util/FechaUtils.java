/**
 * 
 */
package co.com.hammerlab.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase encargada de almacenar las distintas utilidades empleadas en cuanto a
 * fechas
 * 
 * @author Luis Arturo Zárate Ayala <luisarturo1989@gmail.com>
 */
public class FechaUtils {

	/**
	 * Constante encargada de almacena el formato de fecha dd/MM/yyyy
	 */
	private static final String FORMATO_FECHA = "dd/MM/yyyy";
	
	/**
	 * Constante encargada de almacena el formato de fecha dd-MM-yyyy
	 */
	private static final String FORMATO_FECHA_GUION = "dd-MM-yyyy";

	/**
	 * Constante encargada de almacenar el formato de hora HH:mm:ss
	 */
	private static final String FORMATO_HORA = "HH:mm:ss";
	
	/**
	 * Constante encargada de almacenar el formato de hora HH:mm:ss
	 */
	private static final String FORMATO_HORA_GUION = "HH-mm-ss";

	/**
	 * Método encargado de formatear la fecha conforme a la constante
	 * FORMATO_FECHA
	 * 
	 * @param fecha
	 *            , Fecha a formatear
	 * @return fecha formateada
	 */
	public static String formatearfechaSinHora(Date fecha) {
		if (fecha != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat(FORMATO_FECHA);
			return dateFormat.format(fecha);
		}
		return null;
	}

	/**
	 * Método encargado de formatear la fecha conforme a la constante
	 * FORMATO_FECHA
	 * 
	 * @param fecha
	 *            , Fecha a formatear
	 * @return fecha formateada
	 */
	public static String formatearfechaConHora(Date fecha) {
		if (fecha != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat(FORMATO_FECHA
					+ " " + FORMATO_HORA);
			return dateFormat.format(fecha);
		}
		return null;
	}
	
	/**
	 * Método encargado de formatear la fecha conforme a la constante
	 * FORMATO_FECHA
	 * 
	 * @param fecha
	 *            , Fecha a formatear
	 * @return fecha formateada
	 */
	public static String formatearfechaConHoraGuion(Date fecha) {
		if (fecha != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat(FORMATO_FECHA_GUION
					+ "_" + FORMATO_HORA_GUION);
			return dateFormat.format(fecha);
		}
		return null;
	}

}
