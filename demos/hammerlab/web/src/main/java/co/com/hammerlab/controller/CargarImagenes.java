package co.com.hammerlab.controller;

import java.io.ByteArrayInputStream;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import co.com.hammerlab.ejb.EquipoHospitalarioBean;
import co.com.hammerlab.ejb.MantenimientoEquipoBean;
import co.com.hammerlab.model.MantenimientoEquipo;

@ManagedBean
@ApplicationScoped
public class CargarImagenes implements Serializable {


    /**
     * Inyeccion de contexto de faces
     */
    @Inject
    private FacesContext facesContext;

    @Inject   
    private MantenimientoEquipoBean controller;
    
    @Inject   
    private EquipoHospitalarioBean controllerEq;

   

    public StreamedContent getFuncionario() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
                // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
                return new DefaultStreamedContent();
            } else {
                // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
                String id = context.getExternalContext().getRequestParameterMap().get("id");
                // Image image = controller.get.find(Long.valueOf(id));
                byte[] input = controller.getByID(Long.parseLong(id)).getFirmaAprobacion();
                return new DefaultStreamedContent(new ByteArrayInputStream(input), "image/jpeg");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }

        return null;
    }

    public StreamedContent getTecnico() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
                // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
                return new DefaultStreamedContent();
            } else {
                // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
                String id = context.getExternalContext().getRequestParameterMap().get("id");
                // Image image = controller.get.find(Long.valueOf(id));
                byte[] input = controller.getByID(Long.parseLong(id)).getFirmaAprobacionTecnico();
                return new DefaultStreamedContent(new ByteArrayInputStream(input), "image/jpeg");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }

        return null;
    }

    public StreamedContent getContratista() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
                // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
                return new DefaultStreamedContent();
            } else {
                // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
                String id = context.getExternalContext().getRequestParameterMap().get("id");
                // Image image = controller.get.find(Long.valueOf(id));
                byte[] input = controller.getByID(Long.parseLong(id)).getFirmaAprobacionContrato();
                return new DefaultStreamedContent(new ByteArrayInputStream(input), "image/jpeg");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }

        return null;

    }
    
    
    public StreamedContent getfotoEquipo() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
                // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
                return new DefaultStreamedContent();
            } else {
                // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
                String id = context.getExternalContext().getRequestParameterMap().get("id");
                // Image image = controller.get.find(Long.valueOf(id));
                byte[] input = controllerEq.getByID(Long.parseLong(id)).getFotoEquipo();
                return new DefaultStreamedContent(new ByteArrayInputStream(input), "image/jpeg");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }

        return null;

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
        facesContext.addMessage(null, new FacesMessage(severidad, "", mensaje));

    }

}
