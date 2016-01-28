package com.yanbal.catalogo.controller;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.yanbal.catalogo.bean.Ambiente;
import com.yanbal.catalogo.bean.AplicacionInterfaceConsume;
import com.yanbal.catalogo.controller.util.JsfUtil;
import com.yanbal.catalogo.controller.util.PaginationHelper;
import com.yanbal.catalogo.ejb.AplicacionInterfaceConsumeFacade;
import com.yanbal.catalogo.util.Utilitarios;

import java.io.File;
import java.io.IOException;
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
import javax.servlet.ServletContext;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

@ManagedBean(name = "aplicacionInterfaceConsumeController")
@SessionScoped
public class AplicacionInterfaceConsumeController implements Serializable {

	private AplicacionInterfaceConsume current;
	private DataModel items = null;
	@EJB
	private com.yanbal.catalogo.ejb.AplicacionInterfaceConsumeFacade ejbFacade;
	@EJB
	private com.yanbal.catalogo.ejb.UsuarioFacade ejbFacadeUsuario;
	private PaginationHelper pagination;
	private int selectedItemIndex;

	private List<AplicacionInterfaceConsume> filteredAplicacionInterfaceConsume;
	private String nombre_con_fechaActual;

	UtilController util = new UtilController();
	private FacesContext fCtx;

	public AplicacionInterfaceConsumeController() {
	}

	public AplicacionInterfaceConsume getSelected() {
		if (current == null) {
			current = new AplicacionInterfaceConsume();
			selectedItemIndex = -1;
		}
		return current;
	}

	private AplicacionInterfaceConsumeFacade getFacade() {
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
		current = (AplicacionInterfaceConsume) getItems().getRowData();
		selectedItemIndex = pagination.getPageFirstItem()
				+ getItems().getRowIndex();
		return "View";
	}

	public String prepareCreate() {
		current = new AplicacionInterfaceConsume();
		selectedItemIndex = -1;
		return "Create";
	}

	public String create() throws NullPointerException {
		fCtx = FacesContext.getCurrentInstance();
		Map<String, String> reqMap = fCtx.getExternalContext()
				.getRequestParameterMap();
		String email = (String) reqMap.get("email_account");
		try {
			getFacade().create(current);
			JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle")
					.getString("AplicacionInterfaceConsumeCreated"));
			util.sendEmailAccounts(
					email,ejbFacadeUsuario.findAll(),
					ResourceBundle.getBundle("/Bundle").getString("ADD")
							+ current.getId() + " - "
							+ current.getNombreComponente(), ResourceBundle
							.getBundle("/Bundle").getString("EVENTO_ADD"));
			return prepareCreate();
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle")
					.getString("PersistenceErrorOccured"));
			return null;
		}
	}

	public String prepareEdit() {
		current = (AplicacionInterfaceConsume) getItems().getRowData();
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
					.getString("AplicacionInterfaceConsumeUpdated"));
			util.sendEmailAccounts(
					email,ejbFacadeUsuario.findAll(),
					ResourceBundle.getBundle("/Bundle").getString("EDIT")
							+ current.getId() + " - "
							+ current.getNombreComponente(), ResourceBundle
							.getBundle("/Bundle").getString("EVENTO_EDIT"));
			return "View";
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle")
					.getString("PersistenceErrorOccured"));
			return null;
		}
	}

	public String destroy() {
		current = (AplicacionInterfaceConsume) getItems().getRowData();
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
		Map<String, String> reqMap = fCtx.getExternalContext()
				.getRequestParameterMap();
		String email = (String) reqMap.get("email_account");		
		try {
			getFacade().remove(current);
			JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle")
					.getString("AplicacionInterfaceConsumeDeleted"));
			util.sendEmailAccounts(
					email,ejbFacadeUsuario.findAll(),
					ResourceBundle.getBundle("/Bundle").getString("DELETE")
							+ current.getId() + " - "
							+ current.getNombreComponente(), ResourceBundle
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
			filteredAplicacionInterfaceConsume = new ArrayList<AplicacionInterfaceConsume>(
					ejbFacade.findAll());
			nombre_con_fechaActual = Utilitarios
					.nombrarArchivos_confechaActual();
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

	@FacesConverter(forClass = AplicacionInterfaceConsume.class)
	public static class AplicacionInterfaceConsumeControllerConverter implements
			Converter {

		public Object getAsObject(FacesContext facesContext,
				UIComponent component, String value) {
			if (value == null || value.length() == 0) {
				return null;
			}
			AplicacionInterfaceConsumeController controller = (AplicacionInterfaceConsumeController) facesContext
					.getApplication()
					.getELResolver()
					.getValue(facesContext.getELContext(), null,
							"aplicacionInterfaceConsumeController");
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
			if (object instanceof AplicacionInterfaceConsume) {
				AplicacionInterfaceConsume o = (AplicacionInterfaceConsume) object;
				return getStringKey(o.getId());
			} else {
				throw new IllegalArgumentException("object " + object
						+ " is of type " + object.getClass().getName()
						+ "; expected type: "
						+ AplicacionInterfaceConsumeController.class.getName());
			}
		}
	}

	public String prepareEditCust(AplicacionInterfaceConsume obj) {
		current = obj;
		selectedItemIndex = pagination.getPageFirstItem()
				+ getItems().getRowIndex();
		return "Edit";
	}

	public String destroyCust(AplicacionInterfaceConsume obj) {

		current = obj;
		selectedItemIndex = pagination.getPageFirstItem()
				+ getItems().getRowIndex();
		performDestroy();
		recreateModel();
		return "List";
	}

	public List<AplicacionInterfaceConsume> getFilteredAplicacionInterfaceConsume() {
		return filteredAplicacionInterfaceConsume;
	}

	public void setFilteredAplicacionInterfaceConsume(
			List<AplicacionInterfaceConsume> filteredAplicacionInterfaceConsume) {
		this.filteredAplicacionInterfaceConsume = filteredAplicacionInterfaceConsume;
	}

	public void postProcessXLS(Object document) {
		HSSFWorkbook wb = (HSSFWorkbook) document;
		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow header = sheet.getRow(0);

		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setFillForegroundColor(HSSFColor.ORANGE.index);
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		for (int i = 0; i < header.getPhysicalNumberOfCells(); i++) {
			HSSFCell cell = header.getCell(i);

			cell.setCellStyle(cellStyle);
		}
	}

	public void preProcessPDF(Object document) throws IOException,
			BadElementException, DocumentException {
		Document pdf = (Document) document;
		pdf.open();
		pdf.setPageSize(PageSize.A4);

		ServletContext servletContext = (ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext();
		String logo = servletContext.getRealPath("") + File.separator
				+ "resources" + File.separator + "images" + File.separator
				+ "imagen_yanbal.jpg";

		pdf.add(Image.getInstance(logo));
	}

	public String getNombre_con_fechaActual() {
		return nombre_con_fechaActual;
	}

	public void setNombre_con_fechaActual(String nombre_con_fechaActual) {
		this.nombre_con_fechaActual = nombre_con_fechaActual;
	}

}
