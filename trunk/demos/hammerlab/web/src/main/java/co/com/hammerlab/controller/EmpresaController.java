package co.com.hammerlab.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import co.com.hammerlab.ejb.EmpresaBean;
import co.com.hammerlab.model.Empresa;
/**
 * <b>Descripcion:</b> Clase que <br/> se encarga de controlar los datos de un Empresa
 * <b>Caso de Uso:</b> SOL_MOV- <br/> CreacionModeloBaseDatosPagoUso
 * 
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@Named("empresaController")
@ConversationScoped
public class EmpresaController implements Serializable {

    /**
     * Serialziacion 
     */
    private static final long serialVersionUID = -8515841786261886008L;
    
    @Inject
    private Conversation conversation;
    /**
     * Inyeccion de contexto de faces
     */
    @Inject
    private FacesContext facesContext;
    /**
     * Realcion con el EJB que controla las transacciones del objeto
     */
    @Inject
    private EmpresaBean EmpresaBean;
    /**
     * Entidad sobre la que se gestiona la transaccion
     */
    private Empresa newObject;
    /**
     * Variable de control
     */
    private boolean editEmpresa;
    
    /**
     * Variable de control de conversacion 
     */
    private boolean bandera= Boolean.FALSE;

    /**
     * Devuelve el valor de editEmpresa
     * 
     * @return El valor de editEmpresa
     */
     public boolean iseditEmpresa() {
        return editEmpresa;
    }

      /**
     * Devuelve el valor de newUsuario
     * 
     * @return El valor de newUsuario
     */   
    public Empresa getNewObject() {
        return newObject;
    }
    
    private List<Empresa> listaEmpresa;
    
    private List<Empresa> selectEmpresas;
    
    public void busqueda(){
    	
    }
    /**
     * Asigna el valor del objeto seleccionado pra su edicion
     * @param userId Identificador del objeto Seleccionado
     * @return Retorna regla de nevagacion
     */
    public void cargarEmpresaEditar(Long objectId) {
        editEmpresa = Boolean.TRUE;
        newObject = EmpresaBean.getByID(objectId);
    }
    /**
     * Actualiza un objeto en la base de datos
     * @return Retorna regla de nevagacion
     */
    public void actualizarEmpresa() {
        try {
            EmpresaBean.update(newObject);
            editEmpresa = Boolean.FALSE;
            initNewObject();
        } catch (Exception e) {
            String errorMessage = getRootErrorMessage(e);
            addMessage(FacesMessage.SEVERITY_ERROR, errorMessage);            
        }
    }
    /**
     * Elimina un objeto en base de datos
     * @param id Identificador del objeto a eliminar
     * @return Retorna regla de nevagacion
     */
    public void eliminarEmpresa(Long idObject) {
        try {
            EmpresaBean.delete(idObject);
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Empresa Eliminada!", "Exito!!"));
        } catch (Exception e) {
            String errorMessage = getRootErrorMessage(e);
            addMessage(FacesMessage.SEVERITY_ERROR, errorMessage);
            
        }
    }
    /**
     * Registra un nuevo objeto en Base de datos
     *@return Retorna regla de nevagacion
     * @throws Exception Lanza una excepcion si hay un error en la transacciòn 
     */
    public String register(){
        try {
            EmpresaBean.save(newObject);
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito!", "Se realizo un resgistro exitoso de Empresa"));
            initNewObject();
            return "";
        } catch (Exception e) {
            String errorMessage = getRootErrorMessage(e);
           addMessage(FacesMessage.SEVERITY_ERROR, errorMessage);
           
        }
        return "";
    }
    /**
     * Inicializa el bakinbean de control
     */   
    public void initNewObject() {
       // TODO pendienta para inicializar el estado de editaod se deve mover
        if (editEmpresa == Boolean.FALSE) {
            newObject = new Empresa();
        }
        
        if(bandera == Boolean.FALSE){
            if (conversation.isTransient()) {
                conversation.begin();
            }
            bandera = Boolean.TRUE;
        }
        
        
    }
    /**
     * Realiza transformacion de mensaje para el control del log
     * @param e Excepcion generada
     * @return Retorna el mensaje de error
     */
    private String getRootErrorMessage(Exception e) {
        // Default to general error message that registration failed.
        String errorMessage = "Registration failed. See server log for more information";
        if (e == null) {
            // This shouldn't happen, but return the default messages
            return errorMessage;
        }

        // Start with the exception and recurse to find the root cause
        Throwable t = e;
        while (t != null) {
            // Get the message from the Throwable class instance
            errorMessage = t.getLocalizedMessage();
            t = t.getCause();
        }
        // This is the root cause message
        return errorMessage;
    }
    
    /**
     * Genera un mensaje al contexto
     * 
     * @param severidad
     *            , Severidad del mensaje
     * @param mensaje
     *            Clave del mensaje
     */
    public void addMessage(Severity severidad, String mensaje) {
        facesContext.addMessage(null, new FacesMessage(severidad, "",mensaje));

    }
    
    /**
     * Lista de objetos a ser consultados y visualizados en pantalla
     * @return Retorna una lista de obejtos
     */
    public List< Empresa > getListaEmpresa() {
        return EmpresaBean.getAll();
    }

	/**
	 * @return the selectEmpresas
	 */
	public List<Empresa> getSelectEmpresas() {
		if(selectEmpresas==null){
			selectEmpresas= new ArrayList<Empresa>();
		}
		return selectEmpresas;
	}

	/**
	 * @param selectEmpresas the selectEmpresas to set
	 */
	public void setSelectEmpresas(List<Empresa> selectEmpresas) {
		this.selectEmpresas = selectEmpresas;
	}

	/**
	 * @param listaEmpresa the listaEmpresa to set
	 */
	public void setListaEmpresa(List<Empresa> listaEmpresa) {
		this.listaEmpresa = listaEmpresa;
	}
    
	
    
}
