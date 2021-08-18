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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Camilo y Roberth
 */
@Entity
@Table(name = "personas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personas.findAll", query = "SELECT p FROM Personas p")
    , @NamedQuery(name = "Personas.findByIdentificacion", query = "SELECT p FROM Personas p WHERE p.identificacion = :identificacion")
    , @NamedQuery(name = "Personas.findByNombres", query = "SELECT p FROM Personas p WHERE p.nombres = :nombres")
    , @NamedQuery(name = "Personas.findByApellidos", query = "SELECT p FROM Personas p WHERE p.apellidos = :apellidos")
    , @NamedQuery(name = "Personas.findByCelularContacto", query = "SELECT p FROM Personas p WHERE p.celularContacto = :celularContacto")
    , @NamedQuery(name = "Personas.findByTelefonoContacto", query = "SELECT p FROM Personas p WHERE p.telefonoContacto = :telefonoContacto")
    , @NamedQuery(name = "Personas.findByEstadoIntegridad", query = "SELECT p FROM Personas p WHERE p.estadoIntegridad = :estadoIntegridad")})
public class Personas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "identificacion")
    private String identificacion;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "celularContacto")
    private Long celularContacto;
    @Column(name = "telefonoContacto")
    private Long telefonoContacto;
    @Basic(optional = false)
    @Column(name = "estadoIntegridad")
    private Boolean estadoIntegridad;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personas")
    private Propietarios propietarios;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personas")
    private Trabajadores trabajadores;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "identificacion")
    private List<Usuarios> usuariosList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personas")
    private Clientes clientes;

    public Personas() {
    }

    public Personas(String identificacion) {
        this.identificacion = identificacion;
    }

    public Personas(String identificacion, String nombres, String apellidos, Boolean estadoIntegridad) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.estadoIntegridad = estadoIntegridad;
    }

    public Personas(String identificacion, String nombres, String apellidos, Long celularContacto, Long telefonoContacto, Boolean estadoIntegridad) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celularContacto=celularContacto;
        this.telefonoContacto=telefonoContacto;
        this.estadoIntegridad = estadoIntegridad;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Long getCelularContacto() {
        return celularContacto;
    }

    public void setCelularContacto(Long celularContacto) {
        this.celularContacto = celularContacto;
    }

    public Long getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(Long telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public Boolean getEstadoIntegridad() {
        return estadoIntegridad;
    }

    public void setEstadoIntegridad(Boolean estadoIntegridad) {
        this.estadoIntegridad = estadoIntegridad;
    }

    public Propietarios getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(Propietarios propietarios) {
        this.propietarios = propietarios;
    }

    public Trabajadores getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(Trabajadores trabajadores) {
        this.trabajadores = trabajadores;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
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
        if (!(object instanceof Personas)) {
            return false;
        }
        Personas other = (Personas) object;
        if ((this.identificacion == null && other.identificacion != null) || (this.identificacion != null && !this.identificacion.equals(other.identificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.logitransportes.logic.capaModelador.Personas[ identificacion=" + identificacion + " ]";
    }

}
