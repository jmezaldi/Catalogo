/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yanbal.catalogo.bean;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "PLATAFORMA_CLIENTE", schema="CATALOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlataformaCliente.findAll", query = "SELECT p FROM PlataformaCliente p"),
    @NamedQuery(name = "PlataformaCliente.findById", query = "SELECT p FROM PlataformaCliente p WHERE p.id = :id"),
    @NamedQuery(name = "PlataformaCliente.findByNombre", query = "SELECT p FROM PlataformaCliente p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "PlataformaCliente.findByRelease", query = "SELECT p FROM PlataformaCliente p WHERE p.release = :release")})
public class PlataformaCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id=null;
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 20)
    @Column(name = "RELEASE")
    private String release;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlataformaCliente")
    private Collection<Certificacion> certificacionCollection;

    public PlataformaCliente() {
    }

    public PlataformaCliente(Long id) {
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

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    @XmlTransient
    public Collection<Certificacion> getCertificacionCollection() {
        return certificacionCollection;
    }

    public void setCertificacionCollection(Collection<Certificacion> certificacionCollection) {
        this.certificacionCollection = certificacionCollection;
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
        if (!(object instanceof PlataformaCliente)) {
            return false;
        }
        PlataformaCliente other = (PlataformaCliente) object;
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
