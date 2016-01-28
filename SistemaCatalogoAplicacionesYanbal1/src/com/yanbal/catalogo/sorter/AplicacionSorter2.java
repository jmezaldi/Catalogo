//package com.yanbal.catalogo.sorter;
//
//import java.util.Comparator;
//
//import org.primefaces.model.SortOrder;
//
//import com.yanbal.catalogo.bean.Aplicacion;
//
//public class AplicacionSorter2 implements Comparator<Aplicacion> {
//	
//    private String sortField;    
//    private SortOrder sortOrder;
//   
//    
//	public AplicacionSorter2(String sortField, SortOrder sortOrder) {
//		super();
//		this.sortField = sortField;
//		this.sortOrder = sortOrder;
//	}
//
//	@Override
//	public int compare(Aplicacion aplicacion1, Aplicacion aplicacion2) {
//		try {
//			Object value1 = Aplicacion.class.getField(this.sortField).get(aplicacion1);
//			Object value2 = Aplicacion.class.getField(this.sortField).get(aplicacion2);
//
//			int value = ((Comparable)value1).compareTo(value2);
//            
//			return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
//
//		} catch (Exception e) {
//			throw new RuntimeException();
//		}
//		
//	}
//
//}
