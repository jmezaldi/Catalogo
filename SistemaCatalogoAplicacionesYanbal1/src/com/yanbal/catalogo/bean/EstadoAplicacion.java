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
@Table(name = "ESTADO_APLICACION", schema="CATALOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoAplicacion.findAll", query = "SELECT e FROM EstadoAplicacion e"),
    @NamedQuery(name = "EstadoAplicacion.findById", query = "SELECT e FROM EstadoAplicacion e WHERE e.id = :id"),
    @NamedQuery(name = "EstadoAplicacion.findByNombre", query = "SELECT e FROM EstadoAplicacion e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EstadoAplicacion.findByDescripcion", query = "SELECT e FROM EstadoAplicacion e WHERE e.descripcion = :descripcion")})
public class EstadoAplicacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    @NotNull
    @Column(name = "ID")
    private Long id=null;
    @Size(max = 40)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 400)
    @Column(name = "DESCRIPCION")
    private String descripcion;

    public EstadoAplicacion() {
    }

    public EstadoAplicacion(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoAplicacion)) {
            return false;
        }
        EstadoAplicacion other = (EstadoAplicacion) object;
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
