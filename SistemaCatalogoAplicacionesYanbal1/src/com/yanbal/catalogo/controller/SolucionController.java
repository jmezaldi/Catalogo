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

import com.yanbal.catalogo.bean.Solucion;
import com.yanbal.catalogo.controller.util.JsfUtil;
import com.yanbal.catalogo.controller.util.PaginationHelper;
import com.yanbal.catalogo.ejb.SolucionFacade;

@ManagedBean(name = "solucionController")
@SessionScoped
public class SolucionController implements Serializable {

	private Solucion current;
	private DataModel items = null;
	@EJB
	private com.yanbal.catalogo.ejb.SolucionFacade ejbFacade;
	@EJB
	private com.yanbal.catalogo.ejb.UsuarioFacade ejbFacadeUsuario;

	private PaginationHelper pagination;
	private int selectedItemIndex;

	private List<Solucion> filteredSolucion;
	UtilController util = new UtilController();
	private FacesContext fCtx;

	public SolucionController() {
	}

	public Solucion getSelected() {
		if (current == null) {
			current = new Solucion();
			selectedItemIndex = -1;
		}
		return current;
	}

	private SolucionFacade getFacade() {
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
		current = (Solucion) getItems().getRowData();
		selectedItemIndex = pagination.getPageFirstItem()
				+ getItems().getRowIndex();
		return "View";
	}

	public String prepareCreate() {
		current = new Solucion();
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
			JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle")
					.getString("SolucionCreated"));
			util.sendEmailAccounts(email,ejbFacadeUsuario.findAll(),
					ResourceBundle.getBundle("/Bundle").getString("ADD")
							+ current.getId() + " - " + current.getNombre(),
					ResourceBundle.getBundle("/Bundle").getString("EVENTO_ADD"));
			return prepareCreate();
		} catch (Exception e) {
			e.printStackTrace();
			JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle")
					.getString("PersistenceErrorOccured"));
			return null;
		}
	}

	public String prepareEdit() {
		current = (Solucion) getItems().getRowData();
		selectedItemIndex = pagination.getPageFirstItem()
				+ getItems().getRowIndex();
		return "Edit";
	}

	public String prepareEditCust(Solucion sol) {
		current = sol;
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
			JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle")
					.getString("SolucionUpdated"));
			util.sendEmailAccounts(email,ejbFacadeUsuario.findAll(),
					ResourceBundle.getBundle("/Bundle").getString("EDIT")
							+ current.getId() + " - " + current.getNombre(),
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
		current = (Solucion) getItems().getRowData();
		selectedItemIndex = pagination.getPageFirstItem()
				+ getItems().getRowIndex();
		performDestroy();
		recreateModel();
		return "List";
	}

	public String destroyCust(Solucion sol) {
		current = sol;
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
			JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle")
					.getString("SolucionDeleted"));
			util.sendEmailAccounts(email,ejbFacadeUsuario.findAll(),
					ResourceBundle.getBundle("/Bundle").getString("DELETE")
							+ current.getId() + " - " + current.getNombre(),
					ResourceBundle.getBundle("/Bundle").getString("EVENTO_DELETE"));			
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
			filteredSolucion = new ArrayList<Solucion>(ejbFacade.findAll());
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

	@FacesConverter(forClass = Solucion.class)
	public static class SolucionControllerConverter implements Converter {

		public Object getAsObject(FacesContext facesContext,
				UIComponent component, String value) {
			if (value == null || value.length() == 0) {
				return null;
			}
			SolucionController controller = (SolucionController) facesContext
					.getApplication()
					.getELResolver()
					.getValue(facesContext.getELContext(), null,
							"solucionController");
			return controller.ejbFacade.find(getKey(value));
		}

		java.lang.Long getKey(String value) {
			java.lang.Long key;
			key = Long.valueOf(value);
			return key;
		}

		String getStringKey(java.lang.Long value) {
			StringBuffer sb = new StringBuffer();
			sb.append(value);
			return sb.toString();
		}

		public String getAsString(FacesContext facesContext,
				UIComponent component, Object object) {
			if (object == null) {
				return null;
			}
			if (object instanceof Solucion) {
				Solucion o = (Solucion) object;
				return getStringKey(o.getId());
			} else {
				throw new IllegalArgumentException("object " + object
						+ " is of type " + object.getClass().getName()
						+ "; expected type: "
						+ SolucionController.class.getName());
			}
		}
	}

	public List<Solucion> getFilteredSolucion() {
		return filteredSolucion;
	}

	public void setFilteredSolucion(List<Solucion> filteredSolucion) {
		this.filteredSolucion = filteredSolucion;
	}

}
