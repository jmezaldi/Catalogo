package com.yanbal.catalogo.controller;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
/*import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;*/
import javax.servlet.ServletContext;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.yanbal.catalogo.bean.Usuario;
import com.yanbal.catalogo.controller.util.JsfUtil;
import com.yanbal.catalogo.util.Utilitarios;

@ManagedBean(name = "utilController")
@ViewScoped
public class UtilController implements Serializable {

	private static final long serialVersionUID = 1195608410052028903L;
	private String nombre_con_fechaActual;
	
	private static Logger logger = Logger.getLogger(UtilController.class.getName());

	public UtilController() {
		nombre_con_fechaActual = Utilitarios.nombrarArchivos_confechaActual();
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

	public void sendEmailAccounts(String strEmailFrom, String strMessage,
			String strEvento){
		
	}
	
	public void sendEmailAccountsLocal(String strEmailFrom, List<Usuario> allUsuarios, String strMessage,String strEvento){
	/*	
		ListIterator<Usuario> litr_usuario = allUsuarios.listIterator();

		try {				
			String correos = ""; 
			while(litr_usuario.hasNext()){
				Usuario elemento = litr_usuario.next();
				String strEMail=elemento.getCorreo();
				//if(!strEMail.equals(null)) {	
					correos +=elemento.getCorreo()+",";
				//}
			}
			logger.info("Enviando correo " + strEvento + " de " + strEmailFrom);
			logger.info("Enviando a "+correos.substring(0, correos.length()-1));
		//	InternetAddress[] distributionList = InternetAddress.parse(correos.substring(0, correos.length()-1),false);
		//	InternetAddress[] distributionList = InternetAddress.parse(ResourceBundle.getBundle("/Bundle").getString("EMAIL_TO"),false);
			String from;
			if(strEmailFrom!=null){
				from = strEmailFrom;
			}else{
				from = "SIN REGISTRAR";
			}
			
			String subject = ResourceBundle.getBundle("/Bundle").getString("SUBJECT_SISTEMA_CATALOGO");

			Properties props = new Properties();
			props.put("mail.smtp.host", "localhost");
			props.put("mail.smtp.port", "25");
			Session session = Session.getDefaultInstance(props, null);
			session.setDebug(false);
			Message msg = new MimeMessage(session);
			String message = "<div style=\"color:red;\">"
					+ strEvento
					+ "</br></br><table border=\"1\" style=\"width:20%\"><tr><td>"
					+ strMessage + "</td></tr></table></div>";
			msg.setContent(message, "text/html; charset=utf-8");
			msg.setFrom(new InternetAddress(from));
			msg.setRecipients(Message.RecipientType.TO, distributionList);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			
			// Look up mail session
//			javax.naming.Context context = new javax.naming.InitialContext();
//			javax.mail.Session mailSession = (javax.mail.Session) context.lookup("mail/yanbalMailSession");
//			javax.mail.Message msg = new javax.mail.internet.MimeMessage(mailSession);
//			msg.setFrom(new javax.mail.internet.InternetAddress(from));
//			msg.setRecipients(javax.mail.Message.RecipientType.TO, distributionList);
			//////msg.setRecipients(javax.mail.Message.RecipientType.TO, javax.mail.internet.InternetAddress.parse(toEmail));
//			msg.setSubject(subject);
//			msg.setText("mailBody");
//			javax.mail.Transport.send(msg); 
			//javax.mail.Transport.send(msg);
			System.out.println("Message Sent");
			
			
			Transport.send(msg);
			JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("SUCCESS_EMAIL"));
		} catch (Exception ex) {
			ex.printStackTrace();
			JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("ERROR_EMAIL") + " " + strEvento);

		}*/
	}
	
	public void sendEmailAccounts(String strEmailFrom, List<Usuario> allUsuarios, String strMessage,String strEvento){
		
/*		ListIterator<Usuario> litr_usuario = allUsuarios.listIterator();

		try {				
			String correos = ""; 
			while(litr_usuario.hasNext()){
				Usuario elemento = litr_usuario.next();
				String strEMail=elemento.getCorreo();
				//if(!strEMail.equals(null)) {	
					correos +=elemento.getCorreo()+",";
				//}
			}
			logger.info("Enviando correo " + strEvento + " de " + strEmailFrom);
			logger.info("Enviando a "+correos.substring(0, correos.length()-1));
			InternetAddress[] distributionList = InternetAddress.parse(correos.substring(0, correos.length()-1),false);
			String from;
			if(strEmailFrom!=null){
				from = strEmailFrom;
			}else{
				from = "SIN REGISTRAR";
			}			
			String subject = ResourceBundle.getBundle("/Bundle").getString("SUBJECT_SISTEMA_CATALOGO");
		
			// Look up mail session
			javax.naming.Context context = new javax.naming.InitialContext();
			javax.mail.Session mailSession = (javax.mail.Session) context.lookup("mail/yanbalMailSession");
			javax.mail.Message msg = new javax.mail.internet.MimeMessage(mailSession);
			msg.setFrom(new javax.mail.internet.InternetAddress(from));
			msg.setRecipients(javax.mail.Message.RecipientType.TO, distributionList);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setText("mailBody");
			javax.mail.Transport.send(msg); 
			JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("SUCCESS_EMAIL"));
		} catch (Exception ex) {
			ex.printStackTrace();
			JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("ERROR_EMAIL") + " " + strEvento);

		}*/
	}

}
