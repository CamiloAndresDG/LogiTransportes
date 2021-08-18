/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaModelador;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Camilo y Roberth
 */
@Entity
@Table(name = "trabajadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabajadores.findAll", query = "SELECT t FROM Trabajadores t")
    , @NamedQuery(name = "Trabajadores.findByIdentificacion", query = "SELECT t FROM Trabajadores t WHERE t.identificacion = :identificacion")
    , @NamedQuery(name = "Trabajadores.findByFechaDeExpedicion", query = "SELECT t FROM Trabajadores t WHERE t.fechaDeExpedicion = :fechaDeExpedicion")
    , @NamedQuery(name = "Trabajadores.findByLugarExpedicion", query = "SELECT t FROM Trabajadores t WHERE t.lugarExpedicion = :lugarExpedicion")
    , @NamedQuery(name = "Trabajadores.findByDireccionResidencia", query = "SELECT t FROM Trabajadores t WHERE t.direccionResidencia = :direccionResidencia")
    , @NamedQuery(name = "Trabajadores.findByNombreReferenciaFamiliar", query = "SELECT t FROM Trabajadores t WHERE t.nombreReferenciaFamiliar = :nombreReferenciaFamiliar")
    , @NamedQuery(name = "Trabajadores.findByNumeroReferenciaFamiliar", query = "SELECT t FROM Trabajadores t WHERE t.numeroReferenciaFamiliar = :numeroReferenciaFamiliar")
    , @NamedQuery(name = "Trabajadores.findByCiudadContacto", query = "SELECT t FROM Trabajadores t WHERE t.ciudadContacto = :ciudadContacto")
    , @NamedQuery(name = "Trabajadores.findByEstado", query = "SELECT t FROM Trabajadores t WHERE t.estado = :estado")})
public class Trabajadores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "identificacion")
    @OneToOne
    private Personas identificacion;
    @Basic(optional = false)
    @Column(name = "fechaDeExpedicion")
    @Temporal(TemporalType.DATE)
    private Date fechaDeExpedicion;
    @Basic(optional = false)
    @Column(name = "lugarExpedicion")
    private String lugarExpedicion;
    @Basic(optional = false)
    @Column(name = "direccionResidencia")
    private String direccionResidencia;
    @Basic(optional = false)
    @Column(name = "nombreReferenciaFamiliar")
    private String nombreReferenciaFamiliar;
    @Basic(optional = false)
    @Column(name = "numeroReferenciaFamiliar")
    private Long numeroReferenciaFamiliar;
    @Basic(optional = false)
    @Column(name = "ciudadContacto")
    private String ciudadContacto;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "identificacion", referencedColumnName = "identificacion", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personas personas;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "trabajadores")
    private Administrativos administrativos;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "trabajadores")
    private Conductores conductores;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trabajadorIdentificacion")
    private List<Entregas> entregasList;

    public Trabajadores() {
    }

    public Trabajadores(Personas identificacion) {
        this.identificacion = identificacion;
    }

    public Trabajadores(Personas identificacion, Date fechaDeExpedicion, String lugarExpedicion, String direccionResidencia, String nombreReferenciaFamiliar, Long numeroReferenciaFamiliar, String ciudadContacto, String estado) {
        this.identificacion = identificacion;
        this.fechaDeExpedicion = fechaDeExpedicion;
        this.lugarExpedicion = lugarExpedicion;
        this.direccionResidencia = direccionResidencia;
        this.nombreReferenciaFamiliar = nombreReferenciaFamiliar;
        this.numeroReferenciaFamiliar = numeroReferenciaFamiliar;
        this.ciudadContacto = ciudadContacto;
        this.estado = estado;
    }

    public Personas getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Personas identificacion) {
        this.identificacion = identificacion;
    }

    public Date getFechaDeExpedicion() {
        return fechaDeExpedicion;
    }

    public void setFechaDeExpedicion(Date fechaDeExpedicion) {
        this.fechaDeExpedicion = fechaDeExpedicion;
    }

    public String getLugarExpedicion() {
        return lugarExpedicion;
    }

    public void setLugarExpedicion(String lugarExpedicion) {
        this.lugarExpedicion = lugarExpedicion;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    public String getNombreReferenciaFamiliar() {
        return nombreReferenciaFamiliar;
    }

    public void setNombreReferenciaFamiliar(String nombreReferenciaFamiliar) {
        this.nombreReferenciaFamiliar = nombreReferenciaFamiliar;
    }

    public Long getNumeroReferenciaFamiliar() {
        return numeroReferenciaFamiliar;
    }

    public void setNumeroReferenciaFamiliar(Long numeroReferenciaFamiliar) {
        this.numeroReferenciaFamiliar = numeroReferenciaFamiliar;
    }

    public String getCiudadContacto() {
        return ciudadContacto;
    }

    public void setCiudadContacto(String ciudadContacto) {
        this.ciudadContacto = ciudadContacto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

    public Administrativos getAdministrativos() {
        return administrativos;
    }

    public void setAdministrativos(Administrativos administrativos) {
        this.administrativos = administrativos;
    }

    public Conductores getConductores() {
        return conductores;
    }

    public void setConductores(Conductores conductores) {
        this.conductores = conductores;
    }

    @XmlTransient
    public List<Entregas> getEntregasList() {
        return entregasList;
    }

    public void setEntregasList(List<Entregas> entregasList) {
        this.entregasList = entregasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificacion != null ? identificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabajadores)) {
            return false;
        }
        Trabajadores other = (Trabajadores) object;
        if ((this.identificacion == null && other.identificacion != null) || (this.identificacion != null && !this.identificacion.equals(other.identificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.logitransportes.logic.capaModelador.Trabajadores[ identificacion=" + identificacion + " ]";
    }
    
}
