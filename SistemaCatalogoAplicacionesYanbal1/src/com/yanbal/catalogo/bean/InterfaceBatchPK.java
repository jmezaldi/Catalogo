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
public class InterfaceBatchPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4779736763408837178L;
	@Basic(optional = false)
    @NotNull
    @Column(name = "ID_APLICACION_FUENTE")
    private long idAplicacionFuente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_APLICACION_DESTINO")
    private long idAplicacionDestino;

    public InterfaceBatchPK() {
    }

    public InterfaceBatchPK(long idAplicacionFuente, long idAplicacionDestino) {
        this.idAplicacionFuente = idAplicacionFuente;
        this.idAplicacionDestino = idAplicacionDestino;
    }

    public long getIdAplicacionFuente() {
        return idAplicacionFuente;
    }

    public void setIdAplicacionFuente(long idAplicacionFuente) {
        this.idAplicacionFuente = idAplicacionFuente;
    }

    public long getIdAplicacionDestino() {
        return idAplicacionDestino;
    }

    public void setIdAplicacionDestino(long idAplicacionDestino) {
        this.idAplicacionDestino = idAplicacionDestino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAplicacionFuente;
        hash += (int) idAplicacionDestino;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterfaceBatchPK)) {
            return false;
        }
        InterfaceBatchPK other = (InterfaceBatchPK) object;
        if (this.idAplicacionFuente != other.idAplicacionFuente) {
            return false;
        }
        if (this.idAplicacionDestino != other.idAplicacionDestino) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yanbal.catalogo.bean.InterfaceBatchPK[ idAplicacionFuente=" + idAplicacionFuente + ", idAplicacionDestino=" + idAplicacionDestino + " ]";
    }
    
}
