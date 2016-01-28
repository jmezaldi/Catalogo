package com.yanbal.catalogo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import com.yanbal.catalogo.bean.BaseDatos;
import com.yanbal.catalogo.bean.FrameworkXAplicacion;
import com.yanbal.catalogo.ejb.FrameworkXAplicacionFacade;
import com.yanbal.catalogo.controller.util.JsfUtil;
import com.yanbal.catalogo.controller.util.PaginationHelper;

@ManagedBean(name = "frameworkXAplicacionController")
@SessionScoped
public class FrameworkXAplicacionController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2573200173085520142L;
	private FrameworkXAplicacion current;
	private DataModel items = null;
	@EJB
	private com.yanbal.catalogo.ejb.FrameworkXAplicacionFacade ejbFacade;
	@EJB
	private com.yanbal.catalogo.ejb.UsuarioFacade ejbFacadeUsuario;
	private PaginationHelper pagination;
	private int selectedItemIndex;

	private List<FrameworkXAplicacion> filteredItems;
	UtilController util = new UtilController();
	private FacesContext fCtx;

	public FrameworkXAplicacionController() {
	}

	public FrameworkXAplicacion getSelected() {
		if (current == null) {
			current = new FrameworkXAplicacion();
			current.setFrameworkXAplicacionPK(new com.yanbal.catalogo.bean.FrameworkXAplicacionPK());
			selectedItemIndex = -1;
		}
		return current;
	}

	private FrameworkXAplicacionFacade getFacade() {
		return ejbFacade;
	}

	public PaginationHelper getPagination() {
		if (pagination == null) {
			pagination = new PaginationHelper(ejbFacade.count() + 100) {

				@Override
				public int getItemsCount() {
					return getFacade().count();
				}

				@Override
				public DataModel createPageDataModel() {
					return new ListDataModel(getFacade().findRange(
							new int[] { getPageFirstItem(),
									getPageFirstItem() + getPageSize() }));
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
		current = (FrameworkXAplicacion) getItems().getRowData();
		selectedItemIndex = pagination.getPageFirstItem()
				+ getItems().getRowIndex();
		return "View";
	}

	public String prepareCreate() {
		current = new FrameworkXAplicacion();
		current.setFrameworkXAplicacionPK(new com.yanbal.catalogo.bean.FrameworkXAplicacionPK());
		selectedItemIndex = -1;
		return "Create";
	}

	public String create() {
		fCtx = FacesContext.getCurrentInstance();
		Map<String, String> reqMap = fCtx.getExternalContext()
				.getRequestParameterMap();
		String email = (String) reqMap.get("email_account");
		try {
			getFacade().create(current);
			JsfUtil.addSuccessMessage("Se registró satisfactoriamente!");
			util.sendEmailAccounts(email,ejbFacadeUsuario.findAll(), ResourceBundle.getBundle("/Bundle")
					.getString("ADD")
					+ current.getFramework().getNombre()
					+ " - " + current.getAplicacion().getNombre(),
					ResourceBundle.getBundle("/Bundle").getString("EVENTO_ADD"));
			return prepareCreate();
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle")
					.getString("PersistenceErrorOccured"));
			return null;
		}
	}

	public String prepareEdit() {
		current = (FrameworkXAplicacion) getItems().getRowData();
		selectedItemIndex = pagination.getPageFirstItem()
				+ getItems().getRowIndex();
		return "Edit";
	}

	public String update() {
		fCtx = FacesContext.getCurrentInstance();
		Map<String, String> reqMap = fCtx.getExternalContext()
				.getRequestParameterMap();
		String email = (String) reqMap.get("email_account");
		try {
			getFacade().edit(current);
			JsfUtil.addSuccessMessage("Se actualizo con éxito!");
			util.sendEmailAccounts(email,ejbFacadeUsuario.findAll(), ResourceBundle.getBundle("/Bundle")
					.getString("EDIT")
					+ current.getFramework().getNombre()
					+ " - " + current.getAplicacion().getNombre(),
					ResourceBundle.getBundle("/Bundle")
							.getString("EVENTO_EDIT"));
			return "View";
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle")
					.getString("PersistenceErrorOccured"));
			return null;
		}
	}

	public String destroy() {
		current = (FrameworkXAplicacion) getItems().getRowData();
		selectedItemIndex = pagination.getPageFirstItem()
				+ getItems().getRowIndex();
		performDestroy();
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
		fCtx = FacesContext.getCurrentInstance();
		Map<String, String> reqMap = fCtx.getExternalContext().getRequestParameterMap();
		String email = (String) reqMap.get("email_account");			
		try {
			getFacade().remove(current);
			JsfUtil.addSuccessMessage("Se elimino con éxito!");
			util.sendEmailAccounts(email,ejbFacadeUsuario.findAll(), ResourceBundle.getBundle("/Bundle")
					.getString("DELETE")
					+ current.getFramework().getNombre()
					+ " - " + current.getAplicacion().getNombre(), ResourceBundle
					.getBundle("/Bundle").getString("EVENTO_DELETE"));			
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle")
					.getString("PersistenceErrorOccured"));
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
			current = getFacade().findRange(
					new int[] { selectedItemIndex, selectedItemIndex + 1 })
					.get(0);
		}
	}

	public DataModel getItems() {
		if (items == null) {
			items = getPagination().createPageDataModel();
			filteredItems = new ArrayList<FrameworkXAplicacion>(
					ejbFacade.findAll());
		}
		return items;
	}

	private void recreateModel() {
		items = null;
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

	@FacesConverter(forClass = FrameworkXAplicacion.class)
	public static class FrameworkXAplicacionControllerConverter implements
			Converter {

		private static final String SEPARATOR = "#";
		private static final String SEPARATOR_ESCAPED = "\\#";

		public Object getAsObject(FacesContext facesContext,
				UIComponent component, String value) {
			if (value == null || value.length() == 0) {
				return null;
			}
			FrameworkXAplicacionController controller = (FrameworkXAplicacionController) facesContext
					.getApplication()
					.getELResolver()
					.getValue(facesContext.getELContext(), null,
							"frameworkXAplicacionController");
			return controller.ejbFacade.find(getKey(value));
		}

		com.yanbal.catalogo.bean.FrameworkXAplicacionPK getKey(String value) {
			com.yanbal.catalogo.bean.FrameworkXAplicacionPK key;
			String values[] = value.split(SEPARATOR_ESCAPED);
			key = new com.yanbal.catalogo.bean.FrameworkXAplicacionPK();
			key.setIdFramework(Long.parseLong(values[0]));
			key.setIdAplicacion(Long.parseLong(values[1]));
			return key;
		}

		String getStringKey(
				com.yanbal.catalogo.bean.FrameworkXAplicacionPK value) {
			StringBuffer sb = new StringBuffer();
			sb.append(value.getIdFramework());
			sb.append(SEPARATOR);
			sb.append(value.getIdAplicacion());
			return sb.toString();
		}

		public String getAsString(FacesContext facesContext,
				UIComponent component, Object object) {
			if (object == null) {
				return null;
			}
			if (object instanceof FrameworkXAplicacion) {
				FrameworkXAplicacion o = (FrameworkXAplicacion) object;
				return getStringKey(o.getFrameworkXAplicacionPK());
			} else {
				throw new IllegalArgumentException("object " + object
						+ " is of type " + object.getClass().getName()
						+ "; expected type: "
						+ FrameworkXAplicacionController.class.getName());
			}
		}
	}

	public String prepareEditCust(FrameworkXAplicacion obj) {
		current = obj;
		selectedItemIndex = pagination.getPageFirstItem()
				+ getItems().getRowIndex();
		return "Edit";
	}

	public String destroyCust(FrameworkXAplicacion obj) {

		current = obj;
		selectedItemIndex = pagination.getPageFirstItem()
				+ getItems().getRowIndex();
		performDestroy();
		recreateModel();

		return "List";
	}

	public List<FrameworkXAplicacion> getFilteredItems() {
		return filteredItems;
	}

	public void setFilteredItems(List<FrameworkXAplicacion> filteredItems) {
		this.filteredItems = filteredItems;
	}
}
