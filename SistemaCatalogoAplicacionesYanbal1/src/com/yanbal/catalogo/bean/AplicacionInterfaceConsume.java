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
@Table(name = "APLICACION_INTERFACE_CONSUME", schema="CATALOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AplicacionInterfaceConsume.findAll", query = "SELECT a FROM AplicacionInterfaceConsume a"),
    @NamedQuery(name = "AplicacionInterfaceConsume.findById", query = "SELECT a FROM AplicacionInterfaceConsume a WHERE a.id = :id"),
    @NamedQuery(name = "AplicacionInterfaceConsume.findByNombreComponente", query = "SELECT a FROM AplicacionInterfaceConsume a WHERE a.nombreComponente = :nombreComponente"),
    @NamedQuery(name = "AplicacionInterfaceConsume.findByIdServicioConsume", query = "SELECT a FROM AplicacionInterfaceConsume a WHERE a.idServicioConsume = :idServicioConsume")})
public class AplicacionInterfaceConsume implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id=null;
    @Size(max = 200)
    @Column(name = "NOMBRE_COMPONENTE")
    private String nombreComponente;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "ID_SERVICIO_CONSUME")
//    private long idServicioConsume;
    @JoinColumn(name = "ID_SERVICIO_CONSUME", referencedColumnName = "ID")
    @ManyToOne(optional = false)    
    private Servicio idServicioConsume;
    @JoinColumn(name = "ID_APLICACION", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Aplicacion idAplicacion;

    public AplicacionInterfaceConsume() {
    }

    public AplicacionInterfaceConsume(Long id) {
        this.id = id;
    }

    public AplicacionInterfaceConsume(Long id, Servicio idServicioConsume) {
        this.id = id;
        this.idServicioConsume = idServicioConsume;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreComponente() {
        return nombreComponente;
    }

    public void setNombreComponente(String nombreComponente) {
        this.nombreComponente = nombreComponente;
    }

//    public long getIdServicioConsume() {
//        return idServicioConsume;
//    }
//
//    public void setIdServicioConsume(long idServicioConsume) {
//        this.idServicioConsume = idServicioConsume;
//    }

    public Aplicacion getIdAplicacion() {
        return idAplicacion;
    }

    public Servicio getIdServicioConsume() {
		return idServicioConsume;
	}

	public void setIdServicioConsume(Servicio idServicioConsume) {
		this.idServicioConsume = idServicioConsume;
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
        if (!(object instanceof AplicacionInterfaceConsume)) {
            return false;
        }
        AplicacionInterfaceConsume other = (AplicacionInterfaceConsume) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreComponente;
    }
    
}
