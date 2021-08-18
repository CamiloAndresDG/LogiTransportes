/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaModelador;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Camilo y Roberth
 */
@Entity
@Table(name = "conductores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conductores.findAll", query = "SELECT c FROM Conductores c")
    , @NamedQuery(name = "Conductores.findByIdentificacion", query = "SELECT c FROM Conductores c WHERE c.identificacion = :identificacion")
    , @NamedQuery(name = "Conductores.findByTipoTrabajador", query = "SELECT c FROM Conductores c WHERE c.tipoTrabajador = :tipoTrabajador")
    , @NamedQuery(name = "Conductores.findByTipoDeSangre", query = "SELECT c FROM Conductores c WHERE c.tipoDeSangre = :tipoDeSangre")
    , @NamedQuery(name = "Conductores.findByEstatura", query = "SELECT c FROM Conductores c WHERE c.estatura = :estatura")
    , @NamedQuery(name = "Conductores.findByRecordViajes", query = "SELECT c FROM Conductores c WHERE c.recordViajes = :recordViajes")
    , @NamedQuery(name = "Conductores.findByFechaUltimoViaje", query = "SELECT c FROM Conductores c WHERE c.fechaUltimoViaje = :fechaUltimoViaje")})
public class Conductores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "identificacion")
    @OneToOne
    private Personas identificacion;
    @Basic(optional = false)
    @Column(name = "tipoDeSangre")
    private String tipoDeSangre;
    @Basic(optional = false)
    @Column(name = "estatura")
    private Double estatura;
    @Basic(optional = false)
    @Column(name = "recordViajes")
    private Double recordViajes;
    @Basic(optional = false)
    @Column(name = "fechaUltimoViaje")
    @Temporal(TemporalType.DATE)
    private Date fechaUltimoViaje;
    @JoinColumn(name = "licencias_numeroLicencia", referencedColumnName = "numeroLicencia")
    @ManyToOne(optional = false)
    private Licencias numeroLicencia;
    @JoinColumn(name = "identificacion", referencedColumnName = "identificacion", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Trabajadores trabajadores;

    public Conductores() {
    }

    public Conductores(Personas identificacion) {
        this.identificacion = identificacion;
    }

    public Conductores(Personas identificacion, String tipoDeSangre, Double estatura, Double recordViajes, Date fechaUltimoViaje, Licencias numeroLicencia) {
        this.identificacion = identificacion;
        this.tipoDeSangre = tipoDeSangre;
        this.estatura = estatura;
        this.recordViajes = recordViajes;
        this.fechaUltimoViaje = fechaUltimoViaje;
        this.numeroLicencia = numeroLicencia;
    }

    public Personas getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Personas identificacion) {
        this.identificacion = identificacion;
    }

    public String getTipoDeSangre() {
        return tipoDeSangre;
    }

    public void setTipoDeSangre(String tipoDeSangre) {
        this.tipoDeSangre = tipoDeSangre;
    }

    public Double getEstatura() {
        return estatura;
    }

    public void setEstatura(Double estatura) {
        this.estatura = estatura;
    }

    public Double getRecordViajes() {
        return recordViajes;
    }

    public void setRecordViajes(Double recordViajes) {
        this.recordViajes = recordViajes;
    }

    public Date getFechaUltimoViaje() {
        return fechaUltimoViaje;
    }

    public void setFechaUltimoViaje(Date fechaUltimoViaje) {
        this.fechaUltimoViaje = fechaUltimoViaje;
    }

    public Licencias getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(Licencias numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public Trabajadores getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(Trabajadores trabajadores) {
        this.trabajadores = trabajadores;
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
        if (!(object instanceof Conductores)) {
            return false;
        }
        Conductores other = (Conductores) object;
        if ((this.identificacion == null && other.identificacion != null) || (this.identificacion != null && !this.identificacion.equals(other.identificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.logitransportes.logic.capaModelador.Conductores[ identificacion=" + identificacion + " ]";
    }

}
