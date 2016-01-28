/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yanbal.catalogo.bean;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "ARCHIVO_DESPLEGABLE", schema="CATALOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArchivoDesplegable.findAll", query = "SELECT a FROM ArchivoDesplegable a"),
    @NamedQuery(name = "ArchivoDesplegable.findById", query = "SELECT a FROM ArchivoDesplegable a WHERE a.id = :id"),
    @NamedQuery(name = "ArchivoDesplegable.findByNombre", query = "SELECT a FROM ArchivoDesplegable a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "ArchivoDesplegable.findByDescripcion", query = "SELECT a FROM ArchivoDesplegable a WHERE a.descripcion = :descripcion")})
public class ArchivoDesplegable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id=null;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 400)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @ManyToMany(mappedBy = "archivoDesplegableCollection")
    private Collection<Aplicacion> aplicacionCollection;

    public ArchivoDesplegable() {
    }

    public ArchivoDesplegable(Long id) {
        this.id = id;
    }

    public ArchivoDesplegable(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    @XmlTransient
    public Collection<Aplicacion> getAplicacionCollection() {
        return aplicacionCollection;
    }

    public void setAplicacionCollection(Collection<Aplicacion> aplicacionCollection) {
        this.aplicacionCollection = aplicacionCollection;
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
        if (!(object instanceof ArchivoDesplegable)) {
            return false;
        }
        ArchivoDesplegable other = (ArchivoDesplegable) object;
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
