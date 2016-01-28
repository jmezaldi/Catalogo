/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yanbal.catalogo.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "SERVICIO", schema="CATALOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicio.findAll", query = "SELECT s FROM Servicio s"),
    @NamedQuery(name = "Servicio.findById", query = "SELECT s FROM Servicio s WHERE s.id = :id"),
    @NamedQuery(name = "Servicio.findByNombre", query = "SELECT s FROM Servicio s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "Servicio.findByDescripcion", query = "SELECT s FROM Servicio s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "Servicio.findByUrlServicio", query = "SELECT s FROM Servicio s WHERE s.urlServicio = :urlServicio"),
    @NamedQuery(name = "Servicio.findByCodigo", query = "SELECT s FROM Servicio s WHERE s.codigo = :codigo"),
    @NamedQuery(name = "Servicio.findByDocumentacion", query = "SELECT s FROM Servicio s WHERE s.documentacion = :documentacion"),
    @NamedQuery(name = "Servicio.findByComentarioInterno", query = "SELECT s FROM Servicio s WHERE s.comentarioInterno = :comentarioInterno"),
    @NamedQuery(name = "Servicio.findByComposicion", query = "SELECT s FROM Servicio s WHERE s.composicion = :composicion"),
    @NamedQuery(name = "Servicio.findByCodigoInternoFactory", query = "SELECT s FROM Servicio s WHERE s.codigoInternoFactory = :codigoInternoFactory"),
    @NamedQuery(name = "Servicio.findBySolucion", query = "SELECT s FROM Servicio s WHERE s.solucion = :solucion"),
    @NamedQuery(name = "Servicio.findByArchivo", query = "SELECT s FROM Servicio s WHERE s.archivo = :archivo"),
    @NamedQuery(name = "Servicio.findByNumeroCatalogoFactory", query = "SELECT s FROM Servicio s WHERE s.numeroCatalogoFactory = :numeroCatalogoFactory"),
    @NamedQuery(name = "Servicio.findByCodigoInterfaz", query = "SELECT s FROM Servicio s WHERE s.codigoInterfaz = :codigoInterfaz")})
public class Servicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    @NotNull
    @Column(name = "ID")
    private Long id=null;
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 100)
    @Column(name = "URL_SERVICIO")
    private String urlServicio;
    @Size(max = 20)
    @Column(name = "CODIGO")
    private String codigo;
    @Size(max = 100)
    @Column(name = "DOCUMENTACION")
    private String documentacion;
    @Size(max = 100)
    @Column(name = "COMENTARIO_INTERNO")
    private String comentarioInterno;
    @Column(name = "COMPOSICION")
    private Character composicion;
    @Size(max = 50)
    @Column(name = "CODIGO_INTERNO_FACTORY")
    private String codigoInternoFactory;
    @Size(max = 100)
    @Column(name = "SOLUCION")
    private String solucion;
    @Size(max = 100)
    @Column(name = "ARCHIVO")
    private String archivo;
    @Column(name = "NUMERO_CATALOGO_FACTORY")
    private Integer numeroCatalogoFactory;
    @Size(max = 20)
    @Column(name = "CODIGO_INTERFAZ")
    private String codigoInterfaz;
    @JoinColumn(name = "ID_INTERFACEID_BASE", referencedColumnName = "ID")
    @ManyToOne
    private AplicacionInterfaceExpone idInterfaceidBase;

    public Servicio() {
    }

    public Servicio(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUrlServicio() {
        return urlServicio;
    }

    public void setUrlServicio(String urlServicio) {
        this.urlServicio = urlServicio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDocumentacion() {
        return documentacion;
    }

    public void setDocumentacion(String documentacion) {
        this.documentacion = documentacion;
    }

    public String getComentarioInterno() {
        return comentarioInterno;
    }

    public void setComentarioInterno(String comentarioInterno) {
        this.comentarioInterno = comentarioInterno;
    }

    public Character getComposicion() {
        return composicion;
    }

    public void setComposicion(Character composicion) {
        this.composicion = composicion;
    }

    public String getCodigoInternoFactory() {
        return codigoInternoFactory;
    }

    public void setCodigoInternoFactory(String codigoInternoFactory) {
        this.codigoInternoFactory = codigoInternoFactory;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public Integer getNumeroCatalogoFactory() {
        return numeroCatalogoFactory;
    }

    public void setNumeroCatalogoFactory(Integer numeroCatalogoFactory) {
        this.numeroCatalogoFactory = numeroCatalogoFactory;
    }

    public String getCodigoInterfaz() {
        return codigoInterfaz;
    }

    public void setCodigoInterfaz(String codigoInterfaz) {
        this.codigoInterfaz = codigoInterfaz;
    }

    public AplicacionInterfaceExpone getIdInterfaceidBase() {
        return idInterfaceidBase;
    }

    public void setIdInterfaceidBase(AplicacionInterfaceExpone idInterfaceidBase) {
        this.idInterfaceidBase = idInterfaceidBase;
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
        if (!(object instanceof Servicio)) {
            return false;
        }
        Servicio other = (Servicio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre + " "+ descripcion;
    }
    
}
