/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yanbal.catalogo.bean;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "CERTIFICACION", schema="CATALOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Certificacion.findAll", query = "SELECT c FROM Certificacion c"),
    @NamedQuery(name = "Certificacion.findById", query = "SELECT c FROM Certificacion c WHERE c.id = :id"),
    @NamedQuery(name = "Certificacion.findByFecha", query = "SELECT c FROM Certificacion c WHERE c.fecha = :fecha")})
public class Certificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id=null;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "ID_PLATAFORMA_CLIENTE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PlataformaCliente idPlataformaCliente;
    @JoinColumn(name = "ID_APLICACION", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Aplicacion idAplicacion;

    public Certificacion() {
    }

    public Certificacion(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public PlataformaCliente getIdPlataformaCliente() {
        return idPlataformaCliente;
    }

    public void setIdPlataformaCliente(PlataformaCliente idPlataformaCliente) {
        this.idPlataformaCliente = idPlataformaCliente;
    }

    public Aplicacion getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(Aplicacion idAplicacion) {
        this.idAplicacion = idAplicacion;
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
        if (!(object instanceof Certificacion)) {
            return false;
        }
        Certificacion other = (Certificacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return fecha.toString() ;
    }
    
}
