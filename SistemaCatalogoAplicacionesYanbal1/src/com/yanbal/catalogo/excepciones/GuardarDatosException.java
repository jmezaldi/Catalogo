package com.yanbal.catalogo.excepciones;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class GuardarDatosException extends Exception {
	
	public GuardarDatosException() {
	}
	
	public GuardarDatosException(String mensaje) {
		super(mensaje);
	}
}
