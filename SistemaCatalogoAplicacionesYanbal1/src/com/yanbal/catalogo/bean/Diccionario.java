package com.yanbal.catalogo.bean;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "DICCIONARIO", schema="CATALOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diccionario.findAll", query = "SELECT d FROM Diccionario d"),
    @NamedQuery(name = "Diccionario.findById", query = "SELECT d FROM Diccionario d WHERE d.id = :id"),
    @NamedQuery(name = "Diccionario.findByNombre", query = "SELECT d FROM Diccionario d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Diccionario.findByDescripcion", query = "SELECT d FROM Diccionario d WHERE d.descripcion = :descripcion")})
    //@NamedQuery(name = "Diccionario.findByDescripcionLarga", query = "SELECT d FROM Diccionario d WHERE e.descripcionLarga = :descripcionLarga")})
public class Diccionario implements Serializable, Comparable<Diccionario> {
	
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Basic(optional = false)
//    @NotNull
    @Column(name = "ID")
    private Long id=null;
    

	/**
	 * 
	 */
	private static final long serialVersionUID = 8372036806702286905L;
	
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
	private String nombre;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DESCRIPCION")
	private String descripcion;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "DESCRIPCION_LARGA")
	private String descripcionLarga;
	


	public Diccionario() {
	}
	
	public Diccionario(Long id,String nombre, String descripcion, String descripcionLarga) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.descripcion = descripcionLarga;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((descripcionLarga == null) ? 0 : descripcionLarga.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Diccionario other = (Diccionario) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (descripcionLarga == null) {
			if (other.descripcionLarga != null)
				return false;
		} else if (!descripcionLarga.equals(other.descripcionLarga))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcionLarga() {
		return descripcionLarga;
	}

	public void setDescripcionLarga(String descripcionLarga) {
		this.descripcionLarga = descripcionLarga;
	}

	@Override
	public String toString() {
		return "Diccionario [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", descripcionLarga="
				+ descripcionLarga + "]";
	}

	public int compareTo(Diccionario diccionario) {
		return this.getNombre().compareTo(diccionario.getNombre());
	}
	
	
}
