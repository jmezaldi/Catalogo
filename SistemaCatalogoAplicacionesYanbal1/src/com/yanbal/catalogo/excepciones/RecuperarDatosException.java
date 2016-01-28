package com.yanbal.catalogo.excepciones;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class RecuperarDatosException extends Exception {
	
	public RecuperarDatosException() {
	}
	
	public RecuperarDatosException(String mensaje) {
		super(mensaje);
	}
}
