package com.yanbal.catalogo.controller.util;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import com.yanbal.catalogo.bean.Aplicacion;
import com.yanbal.catalogo.bean.Solucion;



@ManagedBean(name = "backReportes")
@ViewScoped
public class ControladorReporte implements Serializable{

	private Connection conexion;	
	private Solucion solucion;
	private Aplicacion aplicacion;
	String rutaBase = FacesContext.getCurrentInstance().getExternalContext().getRealPath("");

	@PostConstruct
	public void inicializar() {
		System.out.println("Obteniendo la conexion.");
		conexion = UtilBaseDatos.getConexion();
		System.out.println("Conexion obtenida.");
	}
	
	public void procesarReportes()
	{
		Aplicacion();
	}

	public void Aplicacion_anterior() {	

		String path_imageFile 		= rutaBase + "resources\\images\\imagen_yanbal.jpg";
		String path_jasperFileName 	= rutaBase + "resources\\reporte\\report1.jasper";    
		String path_pdfFileName 	= rutaBase + "resources\\pdf\\aplicacion_x_solucion.pdf";
		String param_Solucion 	= "21";
		System.out.println(path_imageFile);
		System.out.println(path_jasperFileName);
		System.out.println(path_pdfFileName);
		System.out.println(param_Solucion);
		
		//cargando los datos
		HashMap<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("PARAM_SOLUCION", param_Solucion);
		
		//generando el PDF
		JasperPrint jprint;
		try {
			jprint = JasperFillManager.fillReport(path_jasperFileName, parametros, conexion);
			JasperExportManager.exportReportToPdfFile(jprint, path_pdfFileName);
		} catch (JRException e) {
			e.printStackTrace();
		}		
		//redigirPagina("reporteEfectivo.xhtml");
//		String Retorno = rutaBase +"reporteEfectivo.xhtml?faces-redirect=true";
//		return Retorno;		
	}
	

	 public void ejecutarReportePDF() {
		 
		  try {			  

				String param_Solucion 		= solucion.getId().toString();
	   
			   //Dirección donde esta tu reporte .jasper
				String path_imageFile 	= rutaBase + "resources\\images\\imagen_yanbal.jpg";
				File file = new File(rutaBase + "resources\\reporte\\Aplicacion_X_Solucion.jasper");
				//cargando los datos
				HashMap<String, Object> parametros = new HashMap<String, Object>();
				parametros.put("PARAM_IMAGEN", path_imageFile);
				parametros.put("P_SOLUCION", param_Solucion);
				
			   JasperReport reporte = (JasperReport) JRLoader
			     .loadObjectFromFile(file.getPath());
			   JasperPrint jasperPrint = JasperFillManager.fillReport(reporte,parametros, conexion);
	
			   HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			   httpServletResponse.addHeader("Content-disposition","attachment; filename=aplicacion_x_solucion.pdf");
	
			   ServletOutputStream servletStream = httpServletResponse.getOutputStream();
	
			   JasperExportManager.exportReportToPdfStream(jasperPrint,servletStream);
			   
			   FacesContext.getCurrentInstance().responseComplete();
		   
		  } catch (Exception e) {
			  
			  	e.printStackTrace();
			  	
		  }
	}
	 
	 public void showReporteAplicacionDetalle() {

		 try {			  

			String param_aplicacion = aplicacion.getId().toString();

		   String path_imageFile 	= rutaBase + "resources\\images\\imagen_yanbal.jpg";
		   String path_subReporte   = rutaBase + "resources\\reporte\\";
		   File file 				= new File(rutaBase + "resources\\reporte\\aplicacion_Detalle.jasper");

			HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("PARAM_IMAGEN", path_imageFile);
			parametros.put("SUBREPORT_DIR", path_subReporte);
			parametros.put("ID_APLICACION", param_aplicacion);
			
		   JasperReport reporte = (JasperReport) JRLoader
		     .loadObjectFromFile(file.getPath());
		   JasperPrint jasperPrint = JasperFillManager.fillReport(reporte,parametros, conexion);

		   HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		   httpServletResponse.addHeader("Content-disposition","attachment; filename=aplicacion_Detalle.pdf");

		   ServletOutputStream servletStream = httpServletResponse.getOutputStream();

		   JasperExportManager.exportReportToPdfStream(jasperPrint,servletStream);
		   
		   FacesContext.getCurrentInstance().responseComplete();
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
	 }
	 
	 public void showReporteAplicacionesSolucion() {

		 try {			  

			   String param_solucion 	= solucion.getId().toString();
	
			   String path_subReporte   = rutaBase + "resources\\reporte\\";
			   File file 				= new File(rutaBase + "resources\\reporte\\aplicaciones_solucion.jasper");
	
			   HashMap<String, Object> parametros = new HashMap<String, Object>();
			   parametros.put("SUBREPORT_DIR", path_subReporte);
			   parametros.put("PARAM_SOLUCION", param_solucion);
			
			   JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(file.getPath());
			   JasperPrint jasperPrint = JasperFillManager.fillReport(reporte,parametros, conexion);
	
			   HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			   httpServletResponse.addHeader("Content-disposition","attachment; filename=aplicaciones_solucion.pdf");
	
			   ServletOutputStream servletStream = httpServletResponse.getOutputStream();
	
			   JasperExportManager.exportReportToPdfStream(jasperPrint,servletStream);
			   
			   FacesContext.getCurrentInstance().responseComplete();
			   
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
	 }
	 
	public void Aplicacion() {		

		
		/**
		 * Generando Reporte Reporte_AplicacionXBaseDato.xhtml
		 * **/
		String path_jasperFileName_1 	= rutaBase + "resources\\reporte\\report_aplicacion_x_bd.jasper";    
		String path_pdfFileName_1 	= rutaBase + "resources\\pdf\\report_aplicacion_x_bd.pdf";
		//cargando los datos
		HashMap<String, Object> param1 = new HashMap<String, Object>();		
		param1.put("null", null);
		generarReporte(path_jasperFileName_1,param1,path_pdfFileName_1);
		
		/**
		 * Generando Reporte Reporte_BaseDatoXAplicacion.xhtml
		 * **/
		String path_jasperFileName_2 	= rutaBase + "resources\\reporte\\reporte_bd_x_aplicacion.jasper";    
		String path_pdfFileName_2 		= rutaBase + "resources\\pdf\\reporte_bd_x_aplicacion.pdf";
		//cargando los datos
		HashMap<String, Object> param2 	= new HashMap<String, Object>();		
		param1.put("null", null);
		generarReporte(path_jasperFileName_2,param2,path_pdfFileName_2);
		
		/**
		 * Generando Reporte Reporte_ServidorSWBaseAplicacion.xhtml
		 * **/
		String path_jasperFileName_3 	= rutaBase + "resources\\reporte\\reporte_servidor_softwarebase_aplicacion.jasper";    
		String path_pdfFileName_3 		= rutaBase + "resources\\pdf\\reporte_servidor_softwarebase_aplicacion.pdf";
		//cargando los datos
		HashMap<String, Object> param3 = new HashMap<String, Object>();		
		param1.put("null", null);
		generarReporte(path_jasperFileName_3,param3,path_pdfFileName_3);
		
	}

	public void generarReporte(String jasperName, HashMap<String, Object> param, String pdfName ){
		//generando el PDF
		JasperPrint jprint;
		try {
			jprint = JasperFillManager.fillReport(jasperName, param, conexion);
			JasperExportManager.exportReportToPdfFile(jprint, pdfName);
		} catch (JRException e) {
			e.printStackTrace();
		}	
	}
	
	private void redigirPagina(String nombrePagina) {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		try {
			ec.redirect(ec.getRequestContextPath() + "/faces/" + nombrePagina);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Solucion getSolucion() {
		return solucion;
	}

	public void setSolucion(Solucion solucion) {
		this.solucion = solucion;
	}

	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}
	
	
}
