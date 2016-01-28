/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yanbal.catalogo.bean;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "APLICACION", schema="CATALOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aplicacion.findAll", query = "SELECT a FROM Aplicacion a"),
    @NamedQuery(name = "Aplicacion.findById", query = "SELECT a FROM Aplicacion a WHERE a.id = :id"),
    @NamedQuery(name = "Aplicacion.findByCodigo", query = "SELECT a FROM Aplicacion a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "Aplicacion.findByAreaDuenoApp", query = "SELECT a FROM Aplicacion a WHERE a.areaDuenoApp = :areaDuenoApp"),
    @NamedQuery(name = "Aplicacion.findByIdEstado", query = "SELECT a FROM Aplicacion a WHERE a.idEstado = :idEstado"),
    @NamedQuery(name = "Aplicacion.findByNombre", query = "SELECT a FROM Aplicacion a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Aplicacion.findByDescripcion", query = "SELECT a FROM Aplicacion a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Aplicacion.findByCarpetaRepositorio", query = "SELECT a FROM Aplicacion a WHERE a.carpetaRepositorio = :carpetaRepositorio"),
    @NamedQuery(name = "Aplicacion.findByRelease", query = "SELECT a FROM Aplicacion a WHERE a.release = :release"),
    @NamedQuery(name = "Aplicacion.findByComentarioInterno", query = "SELECT a FROM Aplicacion a WHERE a.comentarioInterno = :comentarioInterno")})
public class Aplicacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
    @Column(name = "ID")
    private Long id=null;    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "CODIGO")
    private String codigo;
    @Size(max = 50)
    @Column(name = "AREA_DUENO_APP")
    private String areaDuenoApp;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "ID_ESTADO")
    @JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID")
    @ManyToOne(optional = false)    
    private EstadoAplicacion idEstado;
    @Size(max = 200)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 800)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 1000)
    @Column(name = "CARPETA_REPOSITORIO")
    private String carpetaRepositorio;
    @Size(max = 20)
    @Column(name = "RELEASE")
    private String release;
    @Size(max = 1000)
    @Column(name = "COMENTARIO_INTERNO")
    private String comentarioInterno;
    @JoinTable(name = "APLICACION_X_CARACTERISTICA", joinColumns = {
        @JoinColumn(name = "ID_APLICACION", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_CARACTERISTICA_APLICACION", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<CaractetisticaAplicacion> caractetisticaAplicacionCollection;
    @JoinTable(name = "APLICACION_X_ARCHIVO_DESPLEGABLE", joinColumns = {
        @JoinColumn(name = "ID_APLICACION", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_ARCHIVO_DESPLEGABLE", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<ArchivoDesplegable> archivoDesplegableCollection;
    @JoinTable(name = "SOFTWARE_BASE_INSTANCIA_X_APLICACION", joinColumns = {
        @JoinColumn(name = "ID_APLICACION", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_SOFTWARE_BASE_INSTANCIA", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<SoftwareBaseInstancia> softwareBaseInstanciaCollection;
    @JoinTable(name = "FRAMEWORK_X_APLICACION", joinColumns = {
        @JoinColumn(name = "ID_APLICACION", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_FRAMEWORK", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Framework> frameworkCollection;
    @JoinTable(name = "PAIS_X_APLICACION", joinColumns = {
        @JoinColumn(name = "ID_APLICACION", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_PAIS", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Pais> paisCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aplicacion")
    private Collection<AplicacionXBaseDatos> aplicacionXBaseDatosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aplicacion")
    private Collection<InterfaceBatch> interfaceBatchCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aplicacion1")
    private Collection<InterfaceBatch> interfaceBatchCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAplicacion")
    private Collection<AplicacionInterfaceConsume> aplicacionInterfaceConsumeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAplicacion")
    private Collection<Certificacion> certificacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAplicacion")
    private Collection<AplicacionXSolucion> aplicacionXSolucionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aplicacion")
    private Collection<AplicacionXSubProcesoNegocio> aplicacionXSubProcesoNegocioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAplicacion")
    private Collection<AplicacionInterfaceExpone> aplicacionInterfaceExponeCollection;

    public Aplicacion() {
    }

    public Aplicacion(Long id) {
        this.id = id;
    }

    public Aplicacion(Long id, String codigo, String areaDuenoApp,
			EstadoAplicacion idEstado, String nombre, String descripcion,
			String carpetaRepositorio, String release, String comentarioInterno) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.areaDuenoApp = areaDuenoApp;
		this.idEstado = idEstado;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.carpetaRepositorio = carpetaRepositorio;
		this.release = release;
		this.comentarioInterno = comentarioInterno;
	}

	public Aplicacion(Long id, String codigo, EstadoAplicacion idEstado) {
        this.id = id;
        this.codigo = codigo;
        this.idEstado = idEstado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getAreaDuenoApp() {
        return areaDuenoApp;
    }

    public void setAreaDuenoApp(String areaDuenoApp) {
        this.areaDuenoApp = areaDuenoApp;
    }

//    public long getIdEstado() {
//        return idEstado;
//    }
//
//    public void setIdEstado(long idEstado) {
//        this.idEstado = idEstado;
//    }

    public EstadoAplicacion getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(EstadoAplicacion idEstado) {
		this.idEstado = idEstado;
	}

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCarpetaRepositorio() {
        return carpetaRepositorio;
    }

    public void setCarpetaRepositorio(String carpetaRepositorio) {
        this.carpetaRepositorio = carpetaRepositorio;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getComentarioInterno() {
        return comentarioInterno;
    }

    public void setComentarioInterno(String comentarioInterno) {
        this.comentarioInterno = comentarioInterno;
    }

    @XmlTransient
    public Collection<CaractetisticaAplicacion> getCaractetisticaAplicacionCollection() {
        return caractetisticaAplicacionCollection;
    }

    public void setCaractetisticaAplicacionCollection(Collection<CaractetisticaAplicacion> caractetisticaAplicacionCollection) {
        this.caractetisticaAplicacionCollection = caractetisticaAplicacionCollection;
    }

    @XmlTransient
    public Collection<ArchivoDesplegable> getArchivoDesplegableCollection() {
        return archivoDesplegableCollection;
    }

    public void setArchivoDesplegableCollection(Collection<ArchivoDesplegable> archivoDesplegableCollection) {
        this.archivoDesplegableCollection = archivoDesplegableCollection;
    }

    @XmlTransient
    public Collection<SoftwareBaseInstancia> getSoftwareBaseInstanciaCollection() {
        return softwareBaseInstanciaCollection;
    }

    public void setSoftwareBaseInstanciaCollection(Collection<SoftwareBaseInstancia> softwareBaseInstanciaCollection) {
        this.softwareBaseInstanciaCollection = softwareBaseInstanciaCollection;
    }

    @XmlTransient
    public Collection<Framework> getFrameworkCollection() {
        return frameworkCollection;
    }

    public void setFrameworkCollection(Collection<Framework> frameworkCollection) {
        this.frameworkCollection = frameworkCollection;
    }

    @XmlTransient
    public Collection<Pais> getPaisCollection() {
        return paisCollection;
    }

    public void setPaisCollection(Collection<Pais> paisCollection) {
        this.paisCollection = paisCollection;
    }

    @XmlTransient
    public Collection<AplicacionXBaseDatos> getAplicacionXBaseDatosCollection() {
        return aplicacionXBaseDatosCollection;
    }

    public void setAplicacionXBaseDatosCollection(Collection<AplicacionXBaseDatos> aplicacionXBaseDatosCollection) {
        this.aplicacionXBaseDatosCollection = aplicacionXBaseDatosCollection;
    }

    @XmlTransient
    public Collection<InterfaceBatch> getInterfaceBatchCollection() {
        return interfaceBatchCollection;
    }

    public void setInterfaceBatchCollection(Collection<InterfaceBatch> interfaceBatchCollection) {
        this.interfaceBatchCollection = interfaceBatchCollection;
    }

    @XmlTransient
    public Collection<InterfaceBatch> getInterfaceBatchCollection1() {
        return interfaceBatchCollection1;
    }

    public void setInterfaceBatchCollection1(Collection<InterfaceBatch> interfaceBatchCollection1) {
        this.interfaceBatchCollection1 = interfaceBatchCollection1;
    }

    @XmlTransient
    public Collection<AplicacionInterfaceConsume> getAplicacionInterfaceConsumeCollection() {
        return aplicacionInterfaceConsumeCollection;
    }

    public void setAplicacionInterfaceConsumeCollection(Collection<AplicacionInterfaceConsume> aplicacionInterfaceConsumeCollection) {
        this.aplicacionInterfaceConsumeCollection = aplicacionInterfaceConsumeCollection;
    }

    @XmlTransient
    public Collection<Certificacion> getCertificacionCollection() {
        return certificacionCollection;
    }

    public void setCertificacionCollection(Collection<Certificacion> certificacionCollection) {
        this.certificacionCollection = certificacionCollection;
    }

    @XmlTransient
    public Collection<AplicacionXSolucion> getAplicacionXSolucionCollection() {
        return aplicacionXSolucionCollection;
    }

    public void setAplicacionXSolucionCollection(Collection<AplicacionXSolucion> aplicacionXSolucionCollection) {
        this.aplicacionXSolucionCollection = aplicacionXSolucionCollection;
    }

    @XmlTransient
    public Collection<AplicacionXSubProcesoNegocio> getAplicacionXSubProcesoNegocioCollection() {
        return aplicacionXSubProcesoNegocioCollection;
    }

    public void setAplicacionXSubProcesoNegocioCollection(Collection<AplicacionXSubProcesoNegocio> aplicacionXSubProcesoNegocioCollection) {
        this.aplicacionXSubProcesoNegocioCollection = aplicacionXSubProcesoNegocioCollection;
    }

    @XmlTransient
    public Collection<AplicacionInterfaceExpone> getAplicacionInterfaceExponeCollection() {
        return aplicacionInterfaceExponeCollection;
    }

    public void setAplicacionInterfaceExponeCollection(Collection<AplicacionInterfaceExpone> aplicacionInterfaceExponeCollection) {
        this.aplicacionInterfaceExponeCollection = aplicacionInterfaceExponeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aplicacion)) {
            return false;
        }
        Aplicacion other = (Aplicacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
