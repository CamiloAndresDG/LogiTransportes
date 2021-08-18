/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaModelador;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Camilo y Roberth
 */
@Entity
@Table(name = "empresas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresas.findAll", query = "SELECT e FROM Empresas e")
    , @NamedQuery(name = "Empresas.findByNit", query = "SELECT e FROM Empresas e WHERE e.nit = :nit")
    , @NamedQuery(name = "Empresas.findByNombre", query = "SELECT e FROM Empresas e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Empresas.findByNumeroContactoCel", query = "SELECT e FROM Empresas e WHERE e.numeroContactoCel = :numeroContactoCel")
    , @NamedQuery(name = "Empresas.findByNumeroContactoTel", query = "SELECT e FROM Empresas e WHERE e.numeroContactoTel = :numeroContactoTel")
    , @NamedQuery(name = "Empresas.findByCiudadUbicacion", query = "SELECT e FROM Empresas e WHERE e.ciudadUbicacion = :ciudadUbicacion")
    , @NamedQuery(name = "Empresas.findByEstadoIntegridad", query = "SELECT e FROM Empresas e WHERE e.estadoIntegridad = :estadoIntegridad")})
public class Empresas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nit")
    private String nit;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "numeroContactoCel")
    private Long numeroContactoCel;
    @Column(name = "numeroContactoTel")
    private Long numeroContactoTel;
    @Basic(optional = false)
    @Column(name = "ciudadUbicacion")
    private String ciudadUbicacion;
    @Basic(optional = false)
    @Lob
    @Column(name = "mercanciaTransporta")
    private String mercanciaTransporta;
    @Basic(optional = false)
    @Column(name = "estadoIntegridad")
    private Boolean estadoIntegridad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    private List<Entregas> entregasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    private List<Clientes> clientesList;

    public Empresas() {
    }

    public Empresas(String nit) {
        this.nit = nit;
    }

    public Empresas(String nit, String nombre, Long numeroContactoCel,Long numeroContactoTel,String ciudadUbicacion, String mercanciaTransporta, Boolean estadoIntegridad) {
        this.nit = nit;
        this.nombre = nombre;
        this.numeroContactoCel=numeroContactoCel;
        this.numeroContactoTel=numeroContactoTel;
        this.ciudadUbicacion = ciudadUbicacion;
        this.mercanciaTransporta = mercanciaTransporta;
        this.estadoIntegridad = estadoIntegridad;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getNumeroContactoCel() {
        return numeroContactoCel;
    }

    public void setNumeroContactoCel(Long numeroContactoCel) {
        this.numeroContactoCel = numeroContactoCel;
    }

    public Long getNumeroContactoTel() {
        return numeroContactoTel;
    }

    public void setNumeroContactoTel(Long numeroContactoTel) {
        this.numeroContactoTel = numeroContactoTel;
    }

    public String getCiudadUbicacion() {
        return ciudadUbicacion;
    }

    public void setCiudadUbicacion(String ciudadUbicacion) {
        this.ciudadUbicacion = ciudadUbicacion;
    }

    public String getMercanciaTransporta() {
        return mercanciaTransporta;
    }

    public void setMercanciaTransporta(String mercanciaTransporta) {
        this.mercanciaTransporta = mercanciaTransporta;
    }

    public Boolean getEstadoIntegridad() {
        return estadoIntegridad;
    }

    public void setEstadoIntegridad(Boolean estadoIntegridad) {
        this.estadoIntegridad = estadoIntegridad;
    }

    @XmlTransient
    public List<Entregas> getEntregasList() {
        return entregasList;
    }

    public void setEntregasList(List<Entregas> entregasList) {
        this.entregasList = entregasList;
    }

    @XmlTransient
    public List<Clientes> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<Clientes> clientesList) {
        this.clientesList = clientesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nit != null ? nit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresas)) {
            return false;
        }
        Empresas other = (Empresas) object;
        if ((this.nit == null && other.nit != null) || (this.nit != null && !this.nit.equals(other.nit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.logitransportes.logic.capaModelador.Empresas[ nit=" + nit + " ]";
    }
    
}
