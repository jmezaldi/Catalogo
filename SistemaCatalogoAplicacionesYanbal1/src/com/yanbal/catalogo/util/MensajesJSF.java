package com.yanbal.catalogo.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MensajesJSF {
	public static void mostrarMensaje(String resumen, String detalle) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, resumen, detalle);
        FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public static void mostrarError(String resumen, String detalle) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, resumen, detalle);
        FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
