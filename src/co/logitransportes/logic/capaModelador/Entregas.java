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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Camilo y Roberth
 */
@Entity
@Table(name = "entregas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entregas.findAll", query = "SELECT e FROM Entregas e")
    , @NamedQuery(name = "Entregas.findByIdEntrega", query = "SELECT e FROM Entregas e WHERE e.idEntrega = :idEntrega")
    , @NamedQuery(name = "Entregas.findByFecha", query = "SELECT e FROM Entregas e WHERE e.fecha = :fecha")
    , @NamedQuery(name = "Entregas.findByEstado", query = "SELECT e FROM Entregas e WHERE e.estado = :estado")
    , @NamedQuery(name = "Entregas.findByEstadoIntegridad", query = "SELECT e FROM Entregas e WHERE e.estadoIntegridad = :estadoIntegridad")})
public class Entregas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idEntrega")
    private String idEntrega;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "estadoIntegridad")
    private Boolean estadoIntegridad;
    @JoinColumn(name = "empresa", referencedColumnName = "nit")
    @ManyToOne(optional = false)
    private Empresas empresa;
    @JoinColumn(name = "trabajador_identificacion", referencedColumnName = "identificacion")
    @ManyToOne(optional = false)
    private Trabajadores trabajadorIdentificacion;
    @JoinColumn(name = "vehiculo_placas", referencedColumnName = "placas")
    @ManyToOne(optional = false)
    private Vehiculos vehiculoPlacas;

    public Entregas() {
    }

    public Entregas(String idEntrega) {
        this.idEntrega = idEntrega;
    }

    public Entregas(String idEntrega, Date fecha, String estado, Boolean estadoIntegridad, Empresas empresa, Trabajadores trabajadorIdentificacion, Vehiculos vehiculoPlacas) {
        this.idEntrega = idEntrega;
        this.fecha = fecha;
        this.estado = estado;
        this.estadoIntegridad = estadoIntegridad;
        this.empresa = empresa;
        this.trabajadorIdentificacion = trabajadorIdentificacion;
        this.vehiculoPlacas = vehiculoPlacas;
    }

    public String getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(String idEntrega) {
        this.idEntrega = idEntrega;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getEstadoIntegridad() {
        return estadoIntegridad;
    }

    public void setEstadoIntegridad(Boolean estadoIntegridad) {
        this.estadoIntegridad = estadoIntegridad;
    }

    public Empresas getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresas empresa) {
        this.empresa = empresa;
    }

    public Trabajadores getTrabajadorIdentificacion() {
        return trabajadorIdentificacion;
    }

    public void setTrabajadorIdentificacion(Trabajadores trabajadorIdentificacion) {
        this.trabajadorIdentificacion = trabajadorIdentificacion;
    }

    public Vehiculos getVehiculoPlacas() {
        return vehiculoPlacas;
    }

    public void setVehiculoPlacas(Vehiculos vehiculoPlacas) {
        this.vehiculoPlacas = vehiculoPlacas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntrega != null ? idEntrega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entregas)) {
            return false;
        }
        Entregas other = (Entregas) object;
        if ((this.idEntrega == null && other.idEntrega != null) || (this.idEntrega != null && !this.idEntrega.equals(other.idEntrega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.logitransportes.logic.capaModelador.Entregas[ idEntrega=" + idEntrega + " ]";
    }

}
