/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yanbal.catalogo.bean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author usuario
 */
@Embeddable
public class SoftwareBaseInstanciaXServicioPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7492134211543368676L;
	@Basic(optional = false)
    @NotNull
    @Column(name = "ID_SOFTWARE_BASE_INSTANCIA")
    private long idSoftwareBaseInstancia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SERVICIO")
    private long idServicio;

    public SoftwareBaseInstanciaXServicioPK() {
    }

    public SoftwareBaseInstanciaXServicioPK(long idSoftwareBaseInstancia, long idServicio) {
        this.idSoftwareBaseInstancia = idSoftwareBaseInstancia;
        this.idServicio = idServicio;
    }

    public long getIdSoftwareBaseInstancia() {
        return idSoftwareBaseInstancia;
    }

    public void setIdSoftwareBaseInstancia(long idSoftwareBaseInstancia) {
        this.idSoftwareBaseInstancia = idSoftwareBaseInstancia;
    }

    public long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(long idServicio) {
        this.idServicio = idServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idSoftwareBaseInstancia;
        hash += (int) idServicio;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SoftwareBaseInstanciaXServicioPK)) {
            return false;
        }
        SoftwareBaseInstanciaXServicioPK other = (SoftwareBaseInstanciaXServicioPK) object;
        if (this.idSoftwareBaseInstancia != other.idSoftwareBaseInstancia) {
            return false;
        }
        if (this.idServicio != other.idServicio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yanbal.catalogo.bean.SoftwareBaseInstanciaXServicioPK[ idSoftwareBaseInstancia=" + idSoftwareBaseInstancia + ", idServicio=" + idServicio + " ]";
    }
    
}
