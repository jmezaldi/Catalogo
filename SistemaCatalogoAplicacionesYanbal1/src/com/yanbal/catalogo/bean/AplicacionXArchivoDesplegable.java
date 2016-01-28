package com.yanbal.catalogo.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the APLICACION_X_ARCHIVO_DESPLEGABLE database table.
 * 
 */
@Entity
@Table(name="APLICACION_X_ARCHIVO_DESPLEGABLE", schema="CATALOGO")
public class AplicacionXArchivoDesplegable implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AplicacionXArchivoDesplegablePK aplicacionXArchivoDesplegablePK;

    @JoinColumn(name = "ID_ARCHIVO_DESPLEGABLE", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ArchivoDesplegable archivoDesplegable;
    
    @JoinColumn(name = "ID_APLICACION", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aplicacion aplicacion;
    
    public AplicacionXArchivoDesplegable() {
    }

    public AplicacionXArchivoDesplegable(AplicacionXArchivoDesplegablePK aplicacionXArchivoDesplegablePK) {
        this.aplicacionXArchivoDesplegablePK = aplicacionXArchivoDesplegablePK;
    }

    public AplicacionXArchivoDesplegable(long idAplicacion, long idArchivoDesplegable) {
        this.aplicacionXArchivoDesplegablePK = new AplicacionXArchivoDesplegablePK(idAplicacion, idArchivoDesplegable);
    }
    
	public AplicacionXArchivoDesplegablePK getAplicacionXArchivoDesplegablePK() {
		return aplicacionXArchivoDesplegablePK;
	}

	public void setAplicacionXArchivoDesplegablePK(
			AplicacionXArchivoDesplegablePK aplicacionXArchivoDesplegablePK) {
		this.aplicacionXArchivoDesplegablePK = aplicacionXArchivoDesplegablePK;
	}

	public ArchivoDesplegable getArchivoDesplegable() {
		return archivoDesplegable;
	}

	public void setArchivoDesplegable(ArchivoDesplegable archivoDesplegable) {
		aplicacionXArchivoDesplegablePK.setIdArchivoDesplegable(archivoDesplegable.getId());
		this.archivoDesplegable = archivoDesplegable;
	}

	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		aplicacionXArchivoDesplegablePK.setIdAplicacion(aplicacion.getId());
		this.aplicacion = aplicacion;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (aplicacionXArchivoDesplegablePK != null ? aplicacionXArchivoDesplegablePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AplicacionXArchivoDesplegable)) {
            return false;
        }
        AplicacionXArchivoDesplegable other = (AplicacionXArchivoDesplegable) object;
        if ((this.aplicacionXArchivoDesplegablePK == null && other.aplicacionXArchivoDesplegablePK != null) || (this.aplicacionXArchivoDesplegablePK != null && !this.aplicacionXArchivoDesplegablePK.equals(other.aplicacionXArchivoDesplegablePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yanbal.catalogo.bean.AplicacionXArchivoDesplegablePK[ aplicacionXArchivoDesplegablePK=" + aplicacionXArchivoDesplegablePK + " ]";
    }	

}