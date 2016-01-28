/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yanbal.catalogo.bean;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "FRAMEWORK", schema="CATALOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Framework.findAll", query = "SELECT f FROM Framework f"),
    @NamedQuery(name = "Framework.findById", query = "SELECT f FROM Framework f WHERE f.id = :id"),
    @NamedQuery(name = "Framework.findByNombre", query = "SELECT f FROM Framework f WHERE f.nombre = :nombre"),
    @NamedQuery(name = "Framework.findByVersion", query = "SELECT f FROM Framework f WHERE f.version = :version"),
    @NamedQuery(name = "Framework.findByDescripcion", query = "SELECT f FROM Framework f WHERE f.descripcion = :descripcion")})
public class Framework implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    @NotNull
    @Column(name = "ID")
    private Long id=null;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 10)
    @Column(name = "VERSION")
    private String version;
    @Size(max = 400)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @ManyToMany(mappedBy = "frameworkCollection")
    private Collection<Aplicacion> aplicacionCollection;

    public Framework() {
    }

    public Framework(Long id) {
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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
        if (!(object instanceof Framework)) {
            return false;
        }
        Framework other = (Framework) object;
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
