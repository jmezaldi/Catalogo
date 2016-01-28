/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yanbal.catalogo.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "ATRIBUTO_X_ENTIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AtributoXEntidad.findAll", query = "SELECT a FROM AtributoXEntidad a"),
    @NamedQuery(name = "AtributoXEntidad.findById", query = "SELECT a FROM AtributoXEntidad a WHERE a.id = :id"),
    @NamedQuery(name = "AtributoXEntidad.findByIdEntidad", query = "SELECT a FROM AtributoXEntidad a WHERE a.idEntidad = :idEntidad"),
    @NamedQuery(name = "AtributoXEntidad.findByNombre", query = "SELECT a FROM AtributoXEntidad a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "AtributoXEntidad.findByDescripcion", query = "SELECT a FROM AtributoXEntidad a WHERE a.descripcion = :descripcion")})
public class AtributoXEntidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id=null;
//    @Column(name = "ID_ENTIDAD")
//    private BigInteger idEntidad;
    @JoinColumn(name = "ID_ENTIDAD", referencedColumnName = "ID")
    @ManyToOne(optional = false)    
    private Entidad idEntidad;    
    @Size(max = 254)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 254)
    @Column(name = "DESCRIPCION")
    private String descripcion;

    public AtributoXEntidad() {
    }

    public AtributoXEntidad(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public BigInteger getIdEntidad() {
//        return idEntidad;
//    }
//
//    public void setIdEntidad(BigInteger idEntidad) {
//        this.idEntidad = idEntidad;
//    }
    

    public String getNombre() {
        return nombre;
    }

	public Entidad getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(Entidad idEntidad) {
		this.idEntidad = idEntidad;
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
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtributoXEntidad)) {
            return false;
        }
        AtributoXEntidad other = (AtributoXEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
