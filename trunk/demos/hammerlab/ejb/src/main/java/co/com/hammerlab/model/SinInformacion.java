package co.com.hammerlab.model;

/**
 * <b>Descripcion:</b> Clase que <br/> Enumera las opciones a registrar cuando el campo no es diligenciado
 * <b>Caso de Uso:</b> SOL_MOV- <br/>
 *
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
public enum SinInformacion {
    
    /**
     * 
     */
    NO_APLICA("No Aplica"),
    
    /**
     * 
     */
    NO_REGISTRA("No Registra");
    
    private String variable;
    
    /**
     * Constructor
     * @param variable
     */
    private SinInformacion(String variable){
        this.variable=variable;
    }

    /**
     * Devuelve el valor de variable
     * @return El valor de variable
     */
    public String getVariable() {
        return variable;
    }
    
    

}
