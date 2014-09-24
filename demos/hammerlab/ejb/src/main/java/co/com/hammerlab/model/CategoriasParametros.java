package co.com.hammerlab.model;

/**
 * <b>Descripcion:</b> Clase que <br/>
 * <b>Caso de Uso:</b> SOL_MOV- <br/>
 *
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
public enum CategoriasParametros {
     
    /**
     * 
     */
    UBICACION("Ubicacion"),

    /**
     * 
     */
    UNIDADES_MEDIDA("Unidades de Medida"),
    
    TECNOLOGIA ("Tecnologia"),
    
    DECRETO_4725("Decreto 4725b de 2005"),
    
    RECOMENDACIONES("Recomendaciones");

    private String variable;

    /**
     * Constructor
     * 
     * @param variable
     */
    private CategoriasParametros(String variable) {
        this.variable = variable;
    }

    /**
     * Devuelve el valor de variable
     * 
     * @return El valor de variable
     */
    public String getVariable() {
        return variable;
    }
}
