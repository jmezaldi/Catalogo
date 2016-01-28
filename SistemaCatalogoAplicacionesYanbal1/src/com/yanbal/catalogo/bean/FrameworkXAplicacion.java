package com.yanbal.catalogo.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the FRAMEWORK_X_APLICACION database table.
 * 
 */
@Entity
@Table(name="FRAMEWORK_X_APLICACION", schema="CATALOGO")
public class FrameworkXAplicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FrameworkXAplicacionPK frameworkXAplicacionPK;

    @JoinColumn(name = "ID_APLICACION", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aplicacion aplicacion;    
    
    @JoinColumn(name = "ID_FRAMEWORK", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Framework framework;
    
    public FrameworkXAplicacion() {
    }

    public FrameworkXAplicacion(FrameworkXAplicacionPK frameworkXAplicacionPK) {
        this.frameworkXAplicacionPK = frameworkXAplicacionPK;
    }

    public FrameworkXAplicacion(long idFramework, long idAplicacion) {
        this.frameworkXAplicacionPK = new FrameworkXAplicacionPK(idFramework, idAplicacion);
    }
    
	public FrameworkXAplicacionPK getFrameworkXAplicacionPK() {
		return frameworkXAplicacionPK;
	}

	public void setFrameworkXAplicacionPK(
			FrameworkXAplicacionPK frameworkXAplicacionPK) {
		this.frameworkXAplicacionPK = frameworkXAplicacionPK;
	}

	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		frameworkXAplicacionPK.setIdAplicacion(aplicacion.getId());		
		this.aplicacion = aplicacion;
	}	

	public Framework getFramework() {
		return framework;
	}

	public void setFramework(Framework framework) {
		frameworkXAplicacionPK.setIdFramework(framework.getId());
		this.framework = framework;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (frameworkXAplicacionPK != null ? frameworkXAplicacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FrameworkXAplicacion)) {
            return false;
        }
        FrameworkXAplicacion other = (FrameworkXAplicacion) object;
        if ((this.frameworkXAplicacionPK == null && other.frameworkXAplicacionPK != null) || (this.frameworkXAplicacionPK != null && !this.frameworkXAplicacionPK.equals(other.frameworkXAplicacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yanbal.catalogo.bean.FrameworkXAplicacion[ frameworkXAplicacionPK=" + frameworkXAplicacionPK + " ]";
    }
}