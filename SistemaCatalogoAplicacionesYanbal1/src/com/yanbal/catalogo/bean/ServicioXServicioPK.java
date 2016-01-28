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
public class ServicioXServicioPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -221771438547659928L;
	@Basic(optional = false)
    @NotNull
    @Column(name = "ID_SERVICIO_DEPENDIENTE")
    private long idServicioDependiente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SERVICIO_BASE")
    private long idServicioBase;

    public ServicioXServicioPK() {
    }

    public ServicioXServicioPK(long idServicioDependiente, long idServicioBase) {
        this.idServicioDependiente = idServicioDependiente;
        this.idServicioBase = idServicioBase;
    }

    public long getIdServicioDependiente() {
        return idServicioDependiente;
    }

    public void setIdServicioDependiente(long idServicioDependiente) {
        this.idServicioDependiente = idServicioDependiente;
    }

    public long getIdServicioBase() {
        return idServicioBase;
    }

    public void setIdServicioBase(long idServicioBase) {
        this.idServicioBase = idServicioBase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idServicioDependiente;
        hash += (int) idServicioBase;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicioXServicioPK)) {
            return false;
        }
        ServicioXServicioPK other = (ServicioXServicioPK) object;
        if (this.idServicioDependiente != other.idServicioDependiente) {
            return false;
        }
        if (this.idServicioBase != other.idServicioBase) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yanbal.catalogo.bean.ServicioXServicioPK[ idServicioDependiente=" + idServicioDependiente + ", idServicioBase=" + idServicioBase + " ]";
    }
    
}
