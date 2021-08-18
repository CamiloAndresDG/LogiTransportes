/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaModelador;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Camilo y Roberth
 */
@Entity
@Table(name = "cambios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cambios.findAll", query = "SELECT c FROM Cambios c")
    , @NamedQuery(name = "Cambios.findByIdCambio", query = "SELECT c FROM Cambios c WHERE c.idCambio = :idCambio")
    , @NamedQuery(name = "Cambios.findByTablaRealizada", query = "SELECT c FROM Cambios c WHERE c.tablaRealizada = :tablaRealizada")
    , @NamedQuery(name = "Cambios.findByCambioRealizado", query = "SELECT c FROM Cambios c WHERE c.cambioRealizado = :cambioRealizado")})
public class Cambios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCambio")
    private Integer idCambio;
    @Basic(optional = false)
    @Column(name = "tablaRealizada")
    private String tablaRealizada;
    @Basic(optional = false)
    @Column(name = "cambioRealizado")
    private String cambioRealizado;
    @JoinColumn(name = "usuario", referencedColumnName = "correo")
    @ManyToOne(optional = false)
    private Usuarios usuario;

    public Cambios() {
    }

    public Cambios(Integer idCambio) {
        this.idCambio = idCambio;
    }

    public Cambios(Integer idCambio, String tablaRealizada, String cambioRealizado) {
        this.idCambio = idCambio;
        this.tablaRealizada = tablaRealizada;
        this.cambioRealizado = cambioRealizado;
    }
    
    public Cambios(Integer idCambio, String tablaRealizada, String cambioRealizado, Usuarios usuario) {
        this.idCambio = idCambio;
        this.tablaRealizada = tablaRealizada;
        this.cambioRealizado = cambioRealizado;
        this.usuario = usuario;
    }

    public Integer getIdCambio() {
        return idCambio;
    }

    public void setIdCambio(Integer idCambio) {
        this.idCambio = idCambio;
    }

    public String getTablaRealizada() {
        return tablaRealizada;
    }

    public void setTablaRealizada(String tablaRealizada) {
        this.tablaRealizada = tablaRealizada;
    }

    public String getCambioRealizado() {
        return cambioRealizado;
    }

    public void setCambioRealizado(String cambioRealizado) {
        this.cambioRealizado = cambioRealizado;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCambio != null ? idCambio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cambios)) {
            return false;
        }
        Cambios other = (Cambios) object;
        if ((this.idCambio == null && other.idCambio != null) || (this.idCambio != null && !this.idCambio.equals(other.idCambio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.logitransportes.logic.capaModelador.Cambios[ idCambio=" + idCambio + " ]";
    }

}
