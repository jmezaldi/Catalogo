/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yanbal.catalogo.bean;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "SOFTWARE_BASE", schema="CATALOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SoftwareBase.findAll", query = "SELECT s FROM SoftwareBase s"),
    @NamedQuery(name = "SoftwareBase.findById", query = "SELECT s FROM SoftwareBase s WHERE s.id = :id"),
    @NamedQuery(name = "SoftwareBase.findByNombre", query = "SELECT s FROM SoftwareBase s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "SoftwareBase.findByRelease", query = "SELECT s FROM SoftwareBase s WHERE s.release = :release")})
public class SoftwareBase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    @NotNull
    @Column(name = "ID")
    private Long id=null;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "RELEASE")
    private String release;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoftwareBase")
    private Collection<SoftwareBaseInstancia> softwareBaseInstanciaCollection;

    public SoftwareBase() {
    }

    public SoftwareBase(Long id) {
        this.id = id;
    }

    public SoftwareBase(Long id, String nombre, String release) {
        this.id = id;
        this.nombre = nombre;
        this.release = release;
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

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    @XmlTransient
    public Collection<SoftwareBaseInstancia> getSoftwareBaseInstanciaCollection() {
        return softwareBaseInstanciaCollection;
    }

    public void setSoftwareBaseInstanciaCollection(Collection<SoftwareBaseInstancia> softwareBaseInstanciaCollection) {
        this.softwareBaseInstanciaCollection = softwareBaseInstanciaCollection;
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
        if (!(object instanceof SoftwareBase)) {
            return false;
        }
        SoftwareBase other = (SoftwareBase) object;
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
