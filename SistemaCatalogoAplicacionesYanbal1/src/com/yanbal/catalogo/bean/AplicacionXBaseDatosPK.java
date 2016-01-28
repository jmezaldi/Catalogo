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
public class AplicacionXBaseDatosPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 364964814411182840L;
	@Basic(optional = false)
    @NotNull
    @Column(name = "ID_APLICACION")
    private long idAplicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_BASE_DATOS")
    private long idBaseDatos;

    public AplicacionXBaseDatosPK() {
    }

    public AplicacionXBaseDatosPK(long idAplicacion, long idBaseDatos) {
        this.idAplicacion = idAplicacion;
        this.idBaseDatos = idBaseDatos;
    }

    public long getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(long idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    public long getIdBaseDatos() {
        return idBaseDatos;
    }

    public void setIdBaseDatos(long idBaseDatos) {
        this.idBaseDatos = idBaseDatos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAplicacion;
        hash += (int) idBaseDatos;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AplicacionXBaseDatosPK)) {
            return false;
        }
        AplicacionXBaseDatosPK other = (AplicacionXBaseDatosPK) object;
        if (this.idAplicacion != other.idAplicacion) {
            return false;
        }
        if (this.idBaseDatos != other.idBaseDatos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yanbal.catalogo.bean.AplicacionXBaseDatosPK[ idAplicacion=" + idAplicacion + ", idBaseDatos=" + idBaseDatos + " ]";
    }
    
}
