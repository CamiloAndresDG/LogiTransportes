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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Camilo y Roberth
 */
@Entity
@Table(name = "administrativos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrativos.findAll", query = "SELECT a FROM Administrativos a")
    , @NamedQuery(name = "Administrativos.findByIdentificacion", query = "SELECT a FROM Administrativos a WHERE a.identificacion = :identificacion")
    , @NamedQuery(name = "Administrativos.findByCargo", query = "SELECT a FROM Administrativos a WHERE a.cargo = :cargo")})
public class Administrativos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "identificacion")
    private Personas identificacion;
    @Basic(optional = false)
    @Column(name = "cargo")
    private String cargo;
    @JoinColumn(name = "identificacion", referencedColumnName = "identificacion", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Trabajadores trabajadores;

    public Administrativos() {
    }

    public Administrativos(Personas identificacion) {
        this.identificacion = identificacion;
    }

    public Administrativos(Personas identificacion, String cargo) {
        this.identificacion = identificacion;
        this.cargo = cargo;
    }

    public Personas getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Personas identificacion) {
        this.identificacion = identificacion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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
        if (!(object instanceof Administrativos)) {
            return false;
        }
        Administrativos other = (Administrativos) object;
        if ((this.identificacion == null && other.identificacion != null) || (this.identificacion != null && !this.identificacion.equals(other.identificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.logitransportes.logic.capaModelador.Administrativos[ identificacion=" + identificacion + " ]";
    }
    
}
