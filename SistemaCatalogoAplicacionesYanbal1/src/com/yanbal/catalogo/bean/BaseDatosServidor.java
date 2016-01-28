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
@Table(name = "BASE_DATOS_SERVIDOR", schema="CATALOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BaseDatosServidor.findAll", query = "SELECT b FROM BaseDatosServidor b"),
    @NamedQuery(name = "BaseDatosServidor.findByIdServidor", query = "SELECT b FROM BaseDatosServidor b WHERE b.baseDatosServidorPK.idServidor = :idServidor"),
    @NamedQuery(name = "BaseDatosServidor.findByIdBaseDatos", query = "SELECT b FROM BaseDatosServidor b WHERE b.baseDatosServidorPK.idBaseDatos = :idBaseDatos")})
public class BaseDatosServidor implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BaseDatosServidorPK baseDatosServidorPK;

    @JoinColumn(name = "ID_SERVIDOR", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Servidor servidor;
    
    @JoinColumn(name = "ID_BASE_DATOS", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private BaseDatos basedatos;
    
    public BaseDatosServidor() {
    }

    public BaseDatosServidor(BaseDatosServidorPK baseDatosServidorPK) {
        this.baseDatosServidorPK = baseDatosServidorPK;
    }

    public BaseDatosServidor(long idServidor, long idBaseDatos) {
        this.baseDatosServidorPK = new BaseDatosServidorPK(idServidor, idBaseDatos);
    }
    public BaseDatosServidorPK getBaseDatosServidorPK() {
        return baseDatosServidorPK;
    }

    public void setBaseDatosServidorPK(BaseDatosServidorPK baseDatosServidorPK) {
        this.baseDatosServidorPK = baseDatosServidorPK;
    }    
    
    public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		baseDatosServidorPK.setIdServidor(servidor.getId());
		this.servidor = servidor;
	}

	public BaseDatos getBasedatos() {
		return basedatos;
	}

	public void setBasedatos(BaseDatos basedatos) {
		baseDatosServidorPK.setIdBaseDatos(basedatos.getId());
		this.basedatos = basedatos;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (baseDatosServidorPK != null ? baseDatosServidorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BaseDatosServidor)) {
            return false;
        }
        BaseDatosServidor other = (BaseDatosServidor) object;
        if ((this.baseDatosServidorPK == null && other.baseDatosServidorPK != null) || (this.baseDatosServidorPK != null && !this.baseDatosServidorPK.equals(other.baseDatosServidorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yanbal.catalogo.bean.BaseDatosServidor[ baseDatosServidorPK=" + baseDatosServidorPK + " ]";
    }
    
}
