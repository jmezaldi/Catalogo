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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "APLICACION_INTERFACE_EXPONE", schema="CATALOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AplicacionInterfaceExpone.findAll", query = "SELECT a FROM AplicacionInterfaceExpone a"),
    @NamedQuery(name = "AplicacionInterfaceExpone.findById", query = "SELECT a FROM AplicacionInterfaceExpone a WHERE a.id = :id"),
    @NamedQuery(name = "AplicacionInterfaceExpone.findByNombreComponente", query = "SELECT a FROM AplicacionInterfaceExpone a WHERE a.nombreComponente = :nombreComponente")})
public class AplicacionInterfaceExpone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id=null;
    @Size(max = 200)
    @Column(name = "NOMBRE_COMPONENTE")
    private String nombreComponente;
    @OneToMany(mappedBy = "idInterfaceidBase")
    private Collection<Servicio> servicioCollection;
    @JoinColumn(name = "ID_APLICACION", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Aplicacion idAplicacion;
    @JoinColumn(name = "ID_SERVICIO_EXPONE", referencedColumnName = "ID")
    @ManyToOne(optional = false)    
    private Servicio idServicioExpone;    

    public AplicacionInterfaceExpone() {
    }

    public AplicacionInterfaceExpone(Long id) {
        this.id = id;
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

    @XmlTransient
    public Collection<Servicio> getServicioCollection() {
        return servicioCollection;
    }

    public void setServicioCollection(Collection<Servicio> servicioCollection) {
        this.servicioCollection = servicioCollection;
    }

    public Aplicacion getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(Aplicacion idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    public Servicio getIdServicioExpone() {
		return idServicioExpone;
	}

	public void setIdServicioExpone(Servicio idServicioExpone) {
		this.idServicioExpone = idServicioExpone;
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
        if (!(object instanceof AplicacionInterfaceExpone)) {
            return false;
        }
        AplicacionInterfaceExpone other = (AplicacionInterfaceExpone) object;
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
