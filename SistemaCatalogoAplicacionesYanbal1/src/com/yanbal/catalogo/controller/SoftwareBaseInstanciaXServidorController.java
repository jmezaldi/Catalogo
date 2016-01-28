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
import com.yanbal.catalogo.bean.SoftwareBaseInstanciaXServidor;
import com.yanbal.catalogo.ejb.SoftwareBaseInstanciaXServidorFacade;
import com.yanbal.catalogo.controller.util.JsfUtil;
import com.yanbal.catalogo.controller.util.PaginationHelper;

@ManagedBean(name = "softwareBaseInstanciaXServidorController")
@SessionScoped
public class SoftwareBaseInstanciaXServidorController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2573200173085520142L;
	private SoftwareBaseInstanciaXServidor current;
	private DataModel items = null;
	@EJB
	private com.yanbal.catalogo.ejb.SoftwareBaseInstanciaXServidorFacade ejbFacade;
	@EJB
	private com.yanbal.catalogo.ejb.UsuarioFacade ejbFacadeUsuario;
	private PaginationHelper pagination;
	private int selectedItemIndex;

	private List<SoftwareBaseInstanciaXServidor> filteredItems;
	UtilController util = new UtilController();
	private FacesContext fCtx;

	public SoftwareBaseInstanciaXServidorController() {
	}

	public SoftwareBaseInstanciaXServidor getSelected() {
		if (current == null) {
			current = new SoftwareBaseInstanciaXServidor();
			current.setSoftwareBaseInstanciaXServidorPK(new com.yanbal.catalogo.bean.SoftwareBaseInstanciaXServidorPK());
			selectedItemIndex = -1;
		}
		return current;
	}

	private SoftwareBaseInstanciaXServidorFacade getFacade() {
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
		current = (SoftwareBaseInstanciaXServidor) getItems().getRowData();
		selectedItemIndex = pagination.getPageFirstItem()
				+ getItems().getRowIndex();
		return "View";
	}

	public String prepareCreate() {
		current = new SoftwareBaseInstanciaXServidor();
		current.setSoftwareBaseInstanciaXServidorPK(new com.yanbal.catalogo.bean.SoftwareBaseInstanciaXServidorPK());
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
					+ current.getSoftwareBaseInstancia().getNombre()
					+ " - "
					+ current.getServidor().getNombre(), ResourceBundle
					.getBundle("/Bundle").getString("EVENTO_ADD"));
			return prepareCreate();
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle")
					.getString("PersistenceErrorOccured"));
			return null;
		}
	}

	public String prepareEdit() {
		current = (SoftwareBaseInstanciaXServidor) getItems().getRowData();
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
					+ current.getSoftwareBaseInstancia().getNombre()
					+ " - "
					+ current.getServidor().getNombre(), ResourceBundle
					.getBundle("/Bundle").getString("EVENTO_EDIT"));
			return "View";
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle")
					.getString("PersistenceErrorOccured"));
			return null;
		}
	}

	public String destroy() {
		current = (SoftwareBaseInstanciaXServidor) getItems().getRowData();
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
					+ current.getSoftwareBaseInstancia().getNombre()
					+ " - "
					+ current.getServidor().getNombre(),
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
			filteredItems = new ArrayList<SoftwareBaseInstanciaXServidor>(
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

	@FacesConverter(forClass = SoftwareBaseInstanciaXServidor.class)
	public static class SoftwareBaseInstanciaXServidorControllerConverter
			implements Converter {

		private static final String SEPARATOR = "#";
		private static final String SEPARATOR_ESCAPED = "\\#";

		public Object getAsObject(FacesContext facesContext,
				UIComponent component, String value) {
			if (value == null || value.length() == 0) {
				return null;
			}
			SoftwareBaseInstanciaXServidorController controller = (SoftwareBaseInstanciaXServidorController) facesContext
					.getApplication()
					.getELResolver()
					.getValue(facesContext.getELContext(), null,
							"softwareBaseInstanciaXServidorController");
			return controller.ejbFacade.find(getKey(value));
		}

		com.yanbal.catalogo.bean.SoftwareBaseInstanciaXServidorPK getKey(
				String value) {
			com.yanbal.catalogo.bean.SoftwareBaseInstanciaXServidorPK key;
			String values[] = value.split(SEPARATOR_ESCAPED);
			key = new com.yanbal.catalogo.bean.SoftwareBaseInstanciaXServidorPK();
			key.setIdServidor(Long.parseLong(values[0]));
			key.setIdSoftwareBaseInstancia(Long.parseLong(values[1]));
			return key;
		}

		String getStringKey(
				com.yanbal.catalogo.bean.SoftwareBaseInstanciaXServidorPK value) {
			StringBuffer sb = new StringBuffer();
			sb.append(value.getIdServidor());
			sb.append(SEPARATOR);
			sb.append(value.getIdSoftwareBaseInstancia());
			return sb.toString();
		}

		public String getAsString(FacesContext facesContext,
				UIComponent component, Object object) {
			if (object == null) {
				return null;
			}
			if (object instanceof SoftwareBaseInstanciaXServidor) {
				SoftwareBaseInstanciaXServidor o = (SoftwareBaseInstanciaXServidor) object;
				return getStringKey(o.getSoftwareBaseInstanciaXServidorPK());
			} else {
				throw new IllegalArgumentException(
						"object "
								+ object
								+ " is of type "
								+ object.getClass().getName()
								+ "; expected type: "
								+ SoftwareBaseInstanciaXServidorController.class
										.getName());
			}
		}
	}

	public String prepareEditCust(SoftwareBaseInstanciaXServidor obj) {
		current = obj;
		selectedItemIndex = pagination.getPageFirstItem()
				+ getItems().getRowIndex();
		return "Edit";
	}

	public String destroyCust(SoftwareBaseInstanciaXServidor obj) {

		current = obj;
		selectedItemIndex = pagination.getPageFirstItem()
				+ getItems().getRowIndex();
		performDestroy();
		recreateModel();

		return "List";
	}

	public List<SoftwareBaseInstanciaXServidor> getFilteredItems() {
		return filteredItems;
	}

	public void setFilteredItems(
			List<SoftwareBaseInstanciaXServidor> filteredItems) {
		this.filteredItems = filteredItems;
	}
}
