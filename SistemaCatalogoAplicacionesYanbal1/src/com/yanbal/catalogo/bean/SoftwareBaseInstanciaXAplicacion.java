package com.yanbal.catalogo.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SOFTWARE_BASE_INSTANCIA_X_APLICACION database table.
 * 
 */
@Entity
@Table(name="SOFTWARE_BASE_INSTANCIA_X_APLICACION", schema="CATALOGO")
public class SoftwareBaseInstanciaXAplicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SoftwareBaseInstanciaXAplicacionPK softwareBaseInstanciaXAplicacionPK;
	
    @JoinColumn(name = "ID_APLICACION", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aplicacion aplicacion;
    
    @JoinColumn(name = "ID_SOFTWARE_BASE_INSTANCIA", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SoftwareBaseInstancia softwareBaseInstancia;
    
    public SoftwareBaseInstanciaXAplicacion() {
    }
    
    public SoftwareBaseInstanciaXAplicacion(SoftwareBaseInstanciaXAplicacionPK softwareBaseInstanciaXAplicacionPK) {
        this.softwareBaseInstanciaXAplicacionPK = softwareBaseInstanciaXAplicacionPK;
    }

    public SoftwareBaseInstanciaXAplicacion(long idAplicacion, long idSoftwareBaseInstancia) {
        this.softwareBaseInstanciaXAplicacionPK = new SoftwareBaseInstanciaXAplicacionPK(idAplicacion, idSoftwareBaseInstancia);
    }

	public SoftwareBaseInstanciaXAplicacionPK getSoftwareBaseInstanciaXAplicacionPK() {
		return softwareBaseInstanciaXAplicacionPK;
	}

	public void setSoftwareBaseInstanciaXAplicacionPK(
			SoftwareBaseInstanciaXAplicacionPK softwareBaseInstanciaXAplicacionPK) {
		this.softwareBaseInstanciaXAplicacionPK = softwareBaseInstanciaXAplicacionPK;
	}

	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public SoftwareBaseInstancia getSoftwareBaseInstancia() {
		return softwareBaseInstancia;
	}

	public void setSoftwareBaseInstancia(SoftwareBaseInstancia softwareBaseInstancia) {
		softwareBaseInstanciaXAplicacionPK.setIdSoftwareBaseInstancia(softwareBaseInstancia.getId());				
		this.softwareBaseInstancia = softwareBaseInstancia;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		softwareBaseInstanciaXAplicacionPK.setIdAplicacion(aplicacion.getId());
		this.aplicacion = aplicacion;
	}
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (softwareBaseInstanciaXAplicacionPK != null ? softwareBaseInstanciaXAplicacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SoftwareBaseInstanciaXAplicacion)) {
            return false;
        }
        SoftwareBaseInstanciaXAplicacion other = (SoftwareBaseInstanciaXAplicacion) object;
        if ((this.softwareBaseInstanciaXAplicacionPK == null && other.softwareBaseInstanciaXAplicacionPK != null) || (this.softwareBaseInstanciaXAplicacionPK != null && !this.softwareBaseInstanciaXAplicacionPK.equals(other.softwareBaseInstanciaXAplicacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yanbal.catalogo.bean.SoftwareBaseInstanciaXAplicacion[ softwareBaseInstanciaXAplicacionPK=" + softwareBaseInstanciaXAplicacionPK + " ]";
    }
}