//package com.yanbal.catalogo.datatable;
//
//import java.lang.reflect.Field;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//import org.primefaces.model.LazyDataModel;
//import org.primefaces.model.SortOrder;
//
//import com.yanbal.catalogo.bean.Aplicacion;
//import com.yanbal.catalogo.sorter.AplicacionSorter2;
//
//public class LazyAplicacionDataModel extends LazyDataModel<Aplicacion> {
//	
//	 private List<Aplicacion> datasource;
//     
//	    public LazyAplicacionDataModel(List<Aplicacion> datasource) {
//	        this.datasource = datasource;
//	    }
//	     
//	    @Override
//	    public Aplicacion getRowData(String rowKey) {
//	        for(Aplicacion app : datasource) {
//	            if(app.getId().equals(rowKey))
//	                return app;
//	        }
//	 
//	        return null;
//	    }
//	 
//	    @Override
//	    public Object getRowKey(Aplicacion app) {
//	        return app.getId();
//	    }
//	 
//	    @Override
//	    public List<Aplicacion> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
//	        List<Aplicacion> data = new ArrayList<Aplicacion>();
//	 
//	        //filter
//	        for(Aplicacion app : datasource) {
//	            boolean match = true;
//	 
//	            if (filters != null) {
//	                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
//	                    try {
//	                        String filterProperty = it.next();
//	                        Object filterValue = filters.get(filterProperty);
//	                        Field field = app.getClass().getDeclaredField(filterProperty);
//	                        field.setAccessible(true);
//	                        //field.get(app);
//	                        String fieldValue = String.valueOf(field.get(app));
//	 
//	                        if(filterValue == null || fieldValue.startsWith(filterValue.toString())) {
//	                            match = true;
//	                    }
//	                    else {
//	                            match = false;
//	                            break;
//	                        }
//	                    } catch(Exception e) {
//	                    	e.printStackTrace();
//	                        match = false;
//	                    }
//	                }
//	            }
//	            if(match) {
//	                data.add(app);
//	            }
//	        }
//	 
//	        //sort
//	        if(sortField != null) {
//	            Collections.sort(data, new AplicacionSorter2(sortField, sortOrder));
//	        }
//	 
//	        //rowCount
//	        int dataSize = data.size();
//	        this.setRowCount(dataSize);
//	 
//	        //paginate
//	        if(dataSize > pageSize) {
//	            try {
//	                return data.subList(first, first + pageSize);
//	            }
//	            catch(IndexOutOfBoundsException e) {
//	                return data.subList(first, first + (dataSize % pageSize));
//	            }
//	        }
//	        else {
//	            return data;
//	        }
//	    }
//}
