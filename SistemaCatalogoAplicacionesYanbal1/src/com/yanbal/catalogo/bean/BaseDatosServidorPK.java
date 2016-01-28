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
public class BaseDatosServidorPK implements Serializable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = -5397865712370778031L;

	//    @JoinColumn(name = "ID_SERVIDOR", referencedColumnName = "ID")
//    @ManyToOne(optional = false)    
//    private Servidor idServidor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SERVIDOR")
    private long idServidor;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_BASE_DATOS")
    private long idBaseDatos;
//    @JoinColumn(name = "ID_BASE_DATOS", referencedColumnName = "ID")
//    @ManyToOne(optional = false)    
//    private BaseDatos idBaseDatos;    

    public BaseDatosServidorPK() {
    }

    public BaseDatosServidorPK(Long idServidor, Long idBaseDatos) {
        this.idServidor = idServidor;
        this.idBaseDatos = idBaseDatos;
    }

    public long getIdServidor() {
        return idServidor;
    }

    public void setIdServidor(long idServidor) {
        this.idServidor = idServidor;
    }

    public long getIdBaseDatos() {
        return idBaseDatos;
    }

    public void setIdBaseDatos(long idBaseDatos) {
        this.idBaseDatos = idBaseDatos;
    }

//    public Servidor getIdServidor() {
//		return idServidor;
//	}
//
//	public void setIdServidor(Servidor idServidor) {
//		this.idServidor = idServidor;
//	}
//
//	public BaseDatos getIdBaseDatos() {
//		return idBaseDatos;
//	}
//
//	public void setIdBaseDatos(BaseDatos idBaseDatos) {
//		this.idBaseDatos = idBaseDatos;
//	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idServidor;
        hash += (int) idBaseDatos;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BaseDatosServidorPK)) {
            return false;
        }
        BaseDatosServidorPK other = (BaseDatosServidorPK) object;
        if (this.idServidor != other.idServidor) {
            return false;
        }
        if (this.idBaseDatos != other.idBaseDatos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yanbal.catalogo.bean.BaseDatosServidorPK[ idServidor=" + idServidor + ", idBaseDatos=" + idBaseDatos + " ]";
    }
    
}
