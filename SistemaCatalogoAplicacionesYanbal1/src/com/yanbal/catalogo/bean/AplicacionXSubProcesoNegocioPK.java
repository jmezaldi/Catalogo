/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yanbal.catalogo.bean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author usuario
 */
@Embeddable
public class AplicacionXSubProcesoNegocioPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1224782413388211836L;
	@Basic(optional = false)
    @NotNull
    @Column(name = "ID_APLICACION")
    private long idAplicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SUB_PROCESO")
    private long idSubProceso;
    
    public AplicacionXSubProcesoNegocioPK() {
    }
    
    public AplicacionXSubProcesoNegocioPK(long idAplicacion, long idSubProceso) {
        this.idAplicacion = idAplicacion;
        this.idSubProceso = idSubProceso;
    }

    public long getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(long idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    public long getIdSubProceso() {
        return idSubProceso;
    }

    public void setIdSubProceso(long idSubProceso) {
        this.idSubProceso = idSubProceso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAplicacion;
        hash += (int) idSubProceso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AplicacionXSubProcesoNegocioPK)) {
            return false;
        }
        AplicacionXSubProcesoNegocioPK other = (AplicacionXSubProcesoNegocioPK) object;
        if (this.idAplicacion != other.idAplicacion) {
            return false;
        }
        if (this.idSubProceso != other.idSubProceso) {
            return false;
        }
        return true;
    }


	@Override
    public String toString() {
        return "com.yanbal.catalogo.bean.AplicacionXSubProcesoNegocioPK[ idAplicacion=" + idAplicacion + ", idSubProceso=" + idSubProceso + " ]";
    }
    
}
