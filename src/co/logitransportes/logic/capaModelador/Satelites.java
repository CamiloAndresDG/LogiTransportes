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
@Table(name = "satelites")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Satelites.findAll", query = "SELECT s FROM Satelites s")
    , @NamedQuery(name = "Satelites.findByUsuario", query = "SELECT s FROM Satelites s WHERE s.usuario = :usuario")
    , @NamedQuery(name = "Satelites.findByClave", query = "SELECT s FROM Satelites s WHERE s.clave = :clave")
    , @NamedQuery(name = "Satelites.findByProovedor", query = "SELECT s FROM Satelites s WHERE s.proovedor = :proovedor")
    , @NamedQuery(name = "Satelites.findByEstadoIntegridad", query = "SELECT s FROM Satelites s WHERE s.estadoIntegridad = :estadoIntegridad")})
public class Satelites implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "clave")
    private String clave;
    @Basic(optional = false)
    @Column(name = "proovedor")
    private String proovedor;
    @Basic(optional = false)
    @Column(name = "estadoIntegridad")
    private Boolean estadoIntegridad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "satelitesUsuario")
    private List<Vehiculos> vehiculosList;

    public Satelites() {
    }

    public Satelites(String usuario) {
        this.usuario = usuario;
    }

    public Satelites(String usuario, String clave, String proovedor, Boolean estadoIntegridad) {
        this.usuario = usuario;
        this.clave = clave;
        this.proovedor = proovedor;
        this.estadoIntegridad = estadoIntegridad;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getProovedor() {
        return proovedor;
    }

    public void setProovedor(String proovedor) {
        this.proovedor = proovedor;
    }

    public Boolean getEstadoIntegridad() {
        return estadoIntegridad;
    }

    public void setEstadoIntegridad(Boolean estadoIntegridad) {
        this.estadoIntegridad = estadoIntegridad;
    }

    @XmlTransient
    public List<Vehiculos> getVehiculosList() {
        return vehiculosList;
    }

    public void setVehiculosList(List<Vehiculos> vehiculosList) {
        this.vehiculosList = vehiculosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Satelites)) {
            return false;
        }
        Satelites other = (Satelites) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.logitransportes.logic.capaModelador.Satelites[ usuario=" + usuario + " ]";
    }
    
}
