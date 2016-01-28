package com.yanbal.catalogo.excepciones;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class ServicioException extends Exception {
	
	public ServicioException() {
	}
	
	public ServicioException(String mensaje) {
		super(mensaje);
	}
}
