package com.yanbal.catalogo.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//import com.ibm.ws.webservices.xml.waswebservices.min;

public class Utilitarios {

	public static final Date sumarRestarDiasFecha(Date fecha, int dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha); 
		calendar.add(Calendar.DAY_OF_YEAR, dias); 
		return calendar.getTime(); 
	}

	
	public static final long DiasDiferenciaFecha(Date fechaAnterior, Date fechaPosterior) {
		long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;
		long diferencia= ( fechaAnterior.getTime() - fechaPosterior.getTime() )/ MILLSECS_PER_DAY;
		return diferencia;
	}
	
	public static final String nombrarArchivos_confechaActual(){

        Date fechaActual = new Date();

        //Formateando la fecha:
        DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        
        //Fecha actual desglosada:
        Calendar fecha = Calendar.getInstance();
        int anio = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH) + 1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);
        
        return dia+"_"+mes+"_"+anio+"_"+hora+""+minuto+""+segundo;
	}
}
