package prueba.controladores;

import prueba.entidadess.SailoPerfiles;
import prueba.controladores.util.JsfUtil;
import prueba.controladores.util.JsfUtil.PersistAction;
import prueba.backing.SailoPerfilesFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("sailoPerfilesController")
@SessionScoped
public class SailoPerfilesController implements Serializable {

    @EJB
    private prueba.backing.SailoPerfilesFacade ejbFacade;
    private List<SailoPerfiles> items = null;
    private SailoPerfiles selected;

    public SailoPerfilesController() {
    }

    public SailoPerfiles getSelected() {
        return selected;
    }

    public void setSelected(SailoPerfiles selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SailoPerfilesFacade getFacade() {
        return ejbFacade;
    }

    public SailoPerfiles prepareCreate() {
        selected = new SailoPerfiles();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SailoPerfilesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SailoPerfilesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SailoPerfilesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SailoPerfiles> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public SailoPerfiles getSailoPerfiles(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<SailoPerfiles> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SailoPerfiles> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SailoPerfiles.class)
    public static class SailoPerfilesControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SailoPerfilesController controller = (SailoPerfilesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "sailoPerfilesController");
            return controller.getSailoPerfiles(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof SailoPerfiles) {
                SailoPerfiles o = (SailoPerfiles) object;
                return getStringKey(o.getPerfilId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SailoPerfiles.class.getName()});
                return null;
            }
        }

    }

}
