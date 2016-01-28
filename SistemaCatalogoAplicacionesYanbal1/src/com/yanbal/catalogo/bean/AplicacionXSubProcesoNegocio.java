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
@Table(name = "APLICACION_X_SUB_PROCESO_NEGOCIO", schema="CATALOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AplicacionXSubProcesoNegocio.findAll", query = "SELECT a FROM AplicacionXSubProcesoNegocio a"),
    @NamedQuery(name = "AplicacionXSubProcesoNegocio.findByIdAplicacion", query = "SELECT a FROM AplicacionXSubProcesoNegocio a WHERE a.aplicacionXSubProcesoNegocioPK.idAplicacion = :idAplicacion"),
    @NamedQuery(name = "AplicacionXSubProcesoNegocio.findByIdSubProceso", query = "SELECT a FROM AplicacionXSubProcesoNegocio a WHERE a.aplicacionXSubProcesoNegocioPK.idSubProceso = :idSubProceso")})
public class AplicacionXSubProcesoNegocio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AplicacionXSubProcesoNegocioPK aplicacionXSubProcesoNegocioPK;
    @JoinColumn(name = "ID_APLICACION", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aplicacion aplicacion;
    
    @JoinColumn(name = "ID_SUB_PROCESO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SubProcesoNegocio subProceso;

    public AplicacionXSubProcesoNegocio() {
    }

    public AplicacionXSubProcesoNegocio(AplicacionXSubProcesoNegocioPK aplicacionXSubProcesoNegocioPK) {
        this.aplicacionXSubProcesoNegocioPK = aplicacionXSubProcesoNegocioPK;
    }

    public AplicacionXSubProcesoNegocio(long idAplicacion, long idSubProceso) {
        this.aplicacionXSubProcesoNegocioPK = new AplicacionXSubProcesoNegocioPK(idAplicacion, idSubProceso);
    }

    public AplicacionXSubProcesoNegocioPK getAplicacionXSubProcesoNegocioPK() {
        return aplicacionXSubProcesoNegocioPK;
    }

    public void setAplicacionXSubProcesoNegocioPK(AplicacionXSubProcesoNegocioPK aplicacionXSubProcesoNegocioPK) {
        this.aplicacionXSubProcesoNegocioPK = aplicacionXSubProcesoNegocioPK;
    }

    public Aplicacion getAplicacion() {    	
        return aplicacion;
    }

    public void setAplicacion(Aplicacion aplicacion) {
    	aplicacionXSubProcesoNegocioPK.setIdAplicacion(aplicacion.getId());
        this.aplicacion = aplicacion;
    }

    public SubProcesoNegocio getSubProceso() {
		return subProceso;
	}

	public void setSubProceso(SubProcesoNegocio subProceso) {
    	aplicacionXSubProcesoNegocioPK.setIdSubProceso(subProceso.getId());
		this.subProceso = subProceso;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (aplicacionXSubProcesoNegocioPK != null ? aplicacionXSubProcesoNegocioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AplicacionXSubProcesoNegocio)) {
            return false;
        }
        AplicacionXSubProcesoNegocio other = (AplicacionXSubProcesoNegocio) object;
        if ((this.aplicacionXSubProcesoNegocioPK == null && other.aplicacionXSubProcesoNegocioPK != null) || (this.aplicacionXSubProcesoNegocioPK != null && !this.aplicacionXSubProcesoNegocioPK.equals(other.aplicacionXSubProcesoNegocioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yanbal.catalogo.bean.AplicacionXSubProcesoNegocio[ aplicacionXSubProcesoNegocioPK=" + aplicacionXSubProcesoNegocioPK + " ]";
    }
    
}
