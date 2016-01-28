/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yanbal.catalogo.bean;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "SOFTWARE_BASE_INSTANCIA_X_SERVICIO", schema="CATALOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SoftwareBaseInstanciaXServicio.findAll", query = "SELECT s FROM SoftwareBaseInstanciaXServicio s"),
    @NamedQuery(name = "SoftwareBaseInstanciaXServicio.findByIdSoftwareBaseInstancia", query = "SELECT s FROM SoftwareBaseInstanciaXServicio s WHERE s.softwareBaseInstanciaXServicioPK.idSoftwareBaseInstancia = :idSoftwareBaseInstancia"),
    @NamedQuery(name = "SoftwareBaseInstanciaXServicio.findByIdServicio", query = "SELECT s FROM SoftwareBaseInstanciaXServicio s WHERE s.softwareBaseInstanciaXServicioPK.idServicio = :idServicio")})
public class SoftwareBaseInstanciaXServicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SoftwareBaseInstanciaXServicioPK softwareBaseInstanciaXServicioPK;
    
    @JoinColumn(name = "ID_SOFTWARE_BASE_INSTANCIA", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SoftwareBaseInstancia softwareBaseInstancia;    

    @JoinColumn(name = "ID_SERVICIO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Servicio servicio;    
    
    public SoftwareBaseInstanciaXServicio() {
    }

    public SoftwareBaseInstanciaXServicio(SoftwareBaseInstanciaXServicioPK softwareBaseInstanciaXServicioPK) {
        this.softwareBaseInstanciaXServicioPK = softwareBaseInstanciaXServicioPK;
    }

    public SoftwareBaseInstanciaXServicio(long idSoftwareBaseInstancia, long idServicio) {
        this.softwareBaseInstanciaXServicioPK = new SoftwareBaseInstanciaXServicioPK(idSoftwareBaseInstancia, idServicio);
    }

    public SoftwareBaseInstanciaXServicioPK getSoftwareBaseInstanciaXServicioPK() {
        return softwareBaseInstanciaXServicioPK;
    }

    public void setSoftwareBaseInstanciaXServicioPK(SoftwareBaseInstanciaXServicioPK softwareBaseInstanciaXServicioPK) {
        this.softwareBaseInstanciaXServicioPK = softwareBaseInstanciaXServicioPK;
    }

	public SoftwareBaseInstancia getSoftwareBaseInstancia() {
		return softwareBaseInstancia;
	}

	public void setSoftwareBaseInstancia(SoftwareBaseInstancia softwareBaseInstancia) {
		softwareBaseInstanciaXServicioPK.setIdSoftwareBaseInstancia(softwareBaseInstancia.getId());
		this.softwareBaseInstancia = softwareBaseInstancia;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		softwareBaseInstanciaXServicioPK.setIdServicio(servicio.getId());
		this.servicio = servicio;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (softwareBaseInstanciaXServicioPK != null ? softwareBaseInstanciaXServicioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SoftwareBaseInstanciaXServicio)) {
            return false;
        }
        SoftwareBaseInstanciaXServicio other = (SoftwareBaseInstanciaXServicio) object;
        if ((this.softwareBaseInstanciaXServicioPK == null && other.softwareBaseInstanciaXServicioPK != null) || (this.softwareBaseInstanciaXServicioPK != null && !this.softwareBaseInstanciaXServicioPK.equals(other.softwareBaseInstanciaXServicioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yanbal.catalogo.bean.SoftwareBaseInstanciaXServicio[ softwareBaseInstanciaXServicioPK=" + softwareBaseInstanciaXServicioPK + " ]";
    }
    
}
