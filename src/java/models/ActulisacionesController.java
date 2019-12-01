package models;


import models.util.JsfUtil;
import models.util.PaginationHelper;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import org.apache.commons.io.IOUtils;
import org.primefaces.model.UploadedFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.AjaxBehaviorEvent;

@Named("actulisacionesController")
@SessionScoped
public class ActulisacionesController implements Serializable {

    private Actulisaciones current;
    private DataModel items = null;
    @EJB
    private models.ActulisacionesFacade ejbFacade;
    @EJB
    private TrabajosFacade worksfcd;
    
    private Actulisaciones update;
    private Trabajos work;
    
    private List<Actulisaciones> updates;
    
    private List<Trabajos> works;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private UploadedFile file;
    
    
    
    public Actulisaciones getUpdate() {
        return update;
    }

    public void setUpdate(Actulisaciones update) {
        this.update = update;
    }

    public Trabajos getWork() {
        return work;
    }

    public void setWork(Trabajos work) {
        this.work = work;
    }

    public List<Actulisaciones> getUpdates() {
        return updates;
    }

    public void setUpdates(List<Actulisaciones> updates) {
        this.updates = updates;
    }

    public List<Trabajos> getWorks() {
         this.works = new ArrayList<Trabajos>();
        List<Trabajos> lp = worksfcd.findAll(); 
       
        return lp;
    }

    public void setWorks(List<Trabajos> works) {
        this.works = works;
    }
    

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
    
     public void shearchUpdates (AjaxBehaviorEvent event){
        this.updates = ejbFacade.buscar(work);
    }
    

    public ActulisacionesController() {
    }

    public Actulisaciones getSelected() {
        if (current == null) {
            current = new Actulisaciones();
            selectedItemIndex = -1;
        }
        return current;
    }

    private ActulisacionesFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Actulisaciones) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Actulisaciones();
        selectedItemIndex = -1;
        return "Create";
    }
    
    public String storageFile(int Id){
        String path = "/resources/"+Id+".jpeg";
        File file2 = new File("C:/Users/lubas/Documents/NetBeansProjects/CyberLubins/web"+path);
      try (OutputStream outputStream = new FileOutputStream(file2)) {
                IOUtils.copy(file.getInputstream(), outputStream);
                return path;
            } catch (FileNotFoundException e) {
                // handle exception here
                JsfUtil.addErrorMessage(e, "No lo encontre xD");
            } catch (IOException e) {
                // handle exception here
                JsfUtil.addErrorMessage(e,"Error x_x");

            }
        return "";
    }

    public String create() {
           System.out.println(file.getContentType());
        if(file.getContentType().equals("image/jpeg") || file.getContentType().equals("application/octet-stream")){
            try {
                current.setDescripcion(storageFile((pagination.getItemsCount())+1));
                getFacade().create(current);
                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ActulisacionesCreated"));
                return "List";
            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }
        }
        JsfUtil.addErrorMessage( ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        return prepareCreate();
    }

    public String prepareEdit() {
        current = (Actulisaciones) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        if(file.getContentType().equals("image/jpeg") || file.getContentType().equals("application/octet-stream")){
            try {
                current.setDescripcion(storageFile(current.getIdactulisaciones()));
                getFacade().edit(current);
                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ActulisacionesUpdated"));
                return "List";
            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }
        }
          JsfUtil.addErrorMessage( ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        return prepareEdit();
    }

    public String destroy() {
        current = (Actulisaciones) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ActulisacionesDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Actulisaciones getActulisaciones(java.lang.Integer id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Actulisaciones.class)
    public static class ActulisacionesControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ActulisacionesController controller = (ActulisacionesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "actulisacionesController");
            return controller.getActulisaciones(getKey(value));
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
            if (object instanceof Actulisaciones) {
                Actulisaciones o = (Actulisaciones) object;
                return getStringKey(o.getIdactulisaciones());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Actulisaciones.class.getName());
            }
        }

    }

}
