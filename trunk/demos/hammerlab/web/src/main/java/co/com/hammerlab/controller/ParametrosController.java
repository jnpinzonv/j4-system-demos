/**
 * 
 */
package co.com.hammerlab.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import co.com.hammerlab.ejb.ParametrosGeneralesBean;
import co.com.hammerlab.model.CategoriasParametros;
import co.com.hammerlab.model.MantenimientoEquipo;
import co.com.hammerlab.model.ParametrosGenerales;
import co.com.hammerlab.util.ConstantesUtil;

/**
 * Clase encargada de controlar los parametros generales
 * @author Luis Arturo Zarate Ayala <luisarturo1989@gmail.com>
 */
@Named("parametrosController")
@ConversationScoped
public class ParametrosController implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -2469814807608614659L;
	
	@Inject
	private Conversation conversation;
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private ParametrosGeneralesBean parametrosGeneralesBean;
	
	/**
	 * 
	 */
	private List<ParametrosGenerales> listaParametrosGenerales;
	
	/**
	 * 
	 */
	private List<ParametrosGenerales> selectParametrosGenerales;
	
	/**
	 * 
	 */
	private ParametrosGenerales parametrosGenerales;
	
	/**
	 * 
	 */
	private List<SelectItem> categoriaList;
	
    /**
     * Variable de control de conversacion
     */
    private boolean bandera = Boolean.FALSE;
    
    /**
     * 
     */
    private boolean editMode;
    
    /**
     * 
     */
    private String refer;
	
	public void init (){
		if (bandera == Boolean.FALSE) {
			if (conversation.isTransient()) {
				conversation.begin();
			}
			bandera = Boolean.TRUE;
			editMode = Boolean.FALSE;
			listaParametrosGenerales = parametrosGeneralesBean.getAll();
			parametrosGenerales = new ParametrosGenerales();
			List<CategoriasParametros> categorias = parametrosGeneralesBean.getListaCategorias();
			categoriaList = new ArrayList<SelectItem>();
			for (CategoriasParametros categoria : categorias) {
				SelectItem item = new SelectItem();
				item.setValue(categoria);
				item.setLabel(categoria.getVariable());
				categoriaList.add(item);
			}
		}				
	}

	public String crear(){
		try {
			parametrosGeneralesBean.save(parametrosGenerales);
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito!",
	                "Se guardo un registro de una Parametrizacion General"));
			inicializarValores();
			busqueda();
			return ConstantesUtil.ATRAS;
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
            addMessage(FacesMessage.SEVERITY_ERROR, errorMessage);
            return "";
		}		
	}
	
	public String actualizar(){
		try {
			parametrosGeneralesBean.update(parametrosGenerales);
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito!",
	                "Se actualizo la informacion de un parametro general"));
			inicializarValores();
			busqueda();
			return ConstantesUtil.ATRAS;
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
            addMessage(FacesMessage.SEVERITY_ERROR, errorMessage);
            return "";
		}		
	}
	
    public void addMessage(Severity severidad, String mensaje) {
        facesContext.addMessage(null, new FacesMessage(severidad, "", mensaje));
    }
	
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
	
	private void inicializarValores(){
		selectParametrosGenerales = null;
		parametrosGenerales = new ParametrosGenerales();
		editMode = Boolean.FALSE;
	}
	
	/**
	 * 
	 */
	public void busqueda() {
		listaParametrosGenerales = parametrosGeneralesBean.getAllSearch(parametrosGenerales);
	}
	
	/**
	 * 
	 */
	public String reiniciar(){
		parametrosGenerales = new ParametrosGenerales ();
		
		return ConstantesUtil.ATRAS;
	}
	
	public String initVistaModo() {
		parametrosGenerales = selectParametrosGenerales.get(0);
		return ConstantesUtil.VER;
	}
	
	public String cancelar() {
        parametrosGenerales = new ParametrosGenerales();
        selectParametrosGenerales = null;
        busqueda();
        return ConstantesUtil.ATRAS;
    }
	
	public String initCrearModo(){
		editMode = Boolean.FALSE;
		parametrosGenerales = new ParametrosGenerales();
		return ConstantesUtil.CREAR_ACTU;
	}
	
	public String initEditarModo() {
		editMode = Boolean.TRUE;
		parametrosGenerales = selectParametrosGenerales.get(0);
		return ConstantesUtil.CREAR_ACTU;
	}
	
	public String eliminar() {
		editMode = Boolean.FALSE;
		parametrosGenerales = new ParametrosGenerales();
		return ConstantesUtil.CREAR_ACTU;
	}
	
	/**
	 * Metodo encargado de obtener el valor de la variable listaParametrosGenerales
	 * @return el valor de la variable listaParametrosGenerales 
	 */
	public List<ParametrosGenerales> getListaParametrosGenerales() {
		return listaParametrosGenerales;
	}

	/**
	 * Metodo encargado de asignar el valor de parametro listaParametrosGenerales a la variable listaParametrosGenerales 
	 * @param listaParametrosGenerales valor a asignar a la variable almidon
	 */
	public void setListaParametrosGenerales(
			List<ParametrosGenerales> listaParametrosGenerales) {
		this.listaParametrosGenerales = listaParametrosGenerales;
	}

	/**
	 * Metodo encargado de obtener el valor de la variable selectParametrosGenerales
	 * @return el valor de la variable selectParametrosGenerales 
	 */
	public List<ParametrosGenerales> getSelectParametrosGenerales() {
		return selectParametrosGenerales;
	}

	/**
	 * Metodo encargado de asignar el valor de parametro selectParametrosGenerales a la variable selectParametrosGenerales 
	 * @param selectParametrosGenerales valor a asignar a la variable almidon
	 */
	public void setSelectParametrosGenerales(
			List<ParametrosGenerales> selectParametrosGenerales) {
		this.selectParametrosGenerales = selectParametrosGenerales;
	}

	/**
	 * Metodo encargado de obtener el valor de la variable parametrosGenerales
	 * @return el valor de la variable parametrosGenerales 
	 */
	public ParametrosGenerales getParametrosGenerales() {
		return parametrosGenerales;
	}

	/**
	 * Metodo encargado de asignar el valor de parametro parametrosGenerales a la variable parametrosGenerales 
	 * @param parametrosGenerales valor a asignar a la variable almidon
	 */
	public void setParametrosGenerales(ParametrosGenerales parametrosGenerales) {
		this.parametrosGenerales = parametrosGenerales;
	}

	/**
	 * Metodo encargado de obtener el valor de la variable parametrosGeneralesBean
	 * @return el valor de la variable parametrosGeneralesBean 
	 */
	public ParametrosGeneralesBean getParametrosGeneralesBean() {
		return parametrosGeneralesBean;
	}

	/**
	 * Metodo encargado de asignar el valor de parametro parametrosGeneralesBean a la variable parametrosGeneralesBean 
	 * @param parametrosGeneralesBean valor a asignar a la variable almidon
	 */
	public void setParametrosGeneralesBean(
			ParametrosGeneralesBean parametrosGeneralesBean) {
		this.parametrosGeneralesBean = parametrosGeneralesBean;
	}

	/**
	 * Metodo encargado de obtener el valor de la variable categoriaList
	 * @return el valor de la variable categoriaList 
	 */
	public List<SelectItem> getCategoriaList() {
		return categoriaList;
	}

	/**
	 * Metodo encargado de asignar el valor de parametro categoriaList a la variable categoriaList 
	 * @param categoriaList valor a asignar a la variable almidon
	 */
	public void setCategoriaList(List<SelectItem> categoriaList) {
		this.categoriaList = categoriaList;
	}

	/**
	 * Metodo encargado de obtener el valor de la variable bandera
	 * @return el valor de la variable bandera 
	 */
	public boolean isBandera() {
		return bandera;
	}

	/**
	 * Metodo encargado de asignar el valor de parametro bandera a la variable bandera 
	 * @param bandera valor a asignar a la variable almidon
	 */
	public void setBandera(boolean bandera) {
		this.bandera = bandera;
	}

	/**
	 * Metodo encargado de obtener el valor de la variable refer
	 * @return el valor de la variable refer 
	 */
	public String getRefer() {
		return refer;
	}

	/**
	 * Metodo encargado de asignar el valor de parametro refer a la variable refer 
	 * @param refer valor a asignar a la variable almidon
	 */
	public void setRefer(String refer) {
		this.refer = refer;
	}

	/**
	 * Metodo encargado de obtener el valor de la variable editMode
	 * @return el valor de la variable editMode 
	 */
	public boolean isEditMode() {
		return editMode;
	}

	/**
	 * Metodo encargado de asignar el valor de parametro editMode a la variable editMode 
	 * @param editMode valor a asignar a la variable almidon
	 */
	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}
}
