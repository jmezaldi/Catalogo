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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "SOFTWARE_BASE_INSTANCIA", schema="CATALOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SoftwareBaseInstancia.findAll", query = "SELECT s FROM SoftwareBaseInstancia s"),
    @NamedQuery(name = "SoftwareBaseInstancia.findById", query = "SELECT s FROM SoftwareBaseInstancia s WHERE s.id = :id"),
    @NamedQuery(name = "SoftwareBaseInstancia.findByComentarioInterno", query = "SELECT s FROM SoftwareBaseInstancia s WHERE s.comentarioInterno = :comentarioInterno"),
    @NamedQuery(name = "SoftwareBaseInstancia.findByNombre", query = "SELECT s FROM SoftwareBaseInstancia s WHERE s.nombre = :nombre")})
public class SoftwareBaseInstancia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id=null;
    @Size(max = 1000)
    @Column(name = "COMENTARIO_INTERNO")
    private String comentarioInterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOMBRE")
    private String nombre;
    @ManyToMany(mappedBy = "softwareBaseInstanciaCollection")
    private Collection<Aplicacion> aplicacionCollection;
    @ManyToMany(mappedBy = "softwareBaseInstanciaCollection")
    private Collection<Servidor> servidorCollection;
    @JoinColumn(name = "ID_SOFTWARE_BASE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private SoftwareBase idSoftwareBase;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "softwareBaseInstancia")
    private Collection<SoftwareBaseInstanciaXServicio> softwareBaseInstanciaXServicioCollection;

    public SoftwareBaseInstancia() {
    }

    public SoftwareBaseInstancia(Long id) {
        this.id = id;
    }

    public SoftwareBaseInstancia(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentarioInterno() {
        return comentarioInterno;
    }

    public void setComentarioInterno(String comentarioInterno) {
        this.comentarioInterno = comentarioInterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Aplicacion> getAplicacionCollection() {
        return aplicacionCollection;
    }

    public void setAplicacionCollection(Collection<Aplicacion> aplicacionCollection) {
        this.aplicacionCollection = aplicacionCollection;
    }

    @XmlTransient
    public Collection<Servidor> getServidorCollection() {
        return servidorCollection;
    }

    public void setServidorCollection(Collection<Servidor> servidorCollection) {
        this.servidorCollection = servidorCollection;
    }

    public SoftwareBase getIdSoftwareBase() {
        return idSoftwareBase;
    }

    public void setIdSoftwareBase(SoftwareBase idSoftwareBase) {
        this.idSoftwareBase = idSoftwareBase;
    }

    @XmlTransient
    public Collection<SoftwareBaseInstanciaXServicio> getSoftwareBaseInstanciaXServicioCollection() {
        return softwareBaseInstanciaXServicioCollection;
    }

    public void setSoftwareBaseInstanciaXServicioCollection(Collection<SoftwareBaseInstanciaXServicio> softwareBaseInstanciaXServicioCollection) {
        this.softwareBaseInstanciaXServicioCollection = softwareBaseInstanciaXServicioCollection;
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
        if (!(object instanceof SoftwareBaseInstancia)) {
            return false;
        }
        SoftwareBaseInstancia other = (SoftwareBaseInstancia) object;
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
