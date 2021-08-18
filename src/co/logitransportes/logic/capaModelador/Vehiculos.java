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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "vehiculos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculos.findAll", query = "SELECT v FROM Vehiculos v")
    , @NamedQuery(name = "Vehiculos.findByPlacas", query = "SELECT v FROM Vehiculos v WHERE v.placas = :placas")
    , @NamedQuery(name = "Vehiculos.findByMarca", query = "SELECT v FROM Vehiculos v WHERE v.marca = :marca")
    , @NamedQuery(name = "Vehiculos.findByModelo", query = "SELECT v FROM Vehiculos v WHERE v.modelo = :modelo")
    , @NamedQuery(name = "Vehiculos.findByTipo", query = "SELECT v FROM Vehiculos v WHERE v.tipo = :tipo")
    , @NamedQuery(name = "Vehiculos.findByEjes", query = "SELECT v FROM Vehiculos v WHERE v.ejes = :ejes")
    , @NamedQuery(name = "Vehiculos.findByChasis", query = "SELECT v FROM Vehiculos v WHERE v.chasis = :chasis")
    , @NamedQuery(name = "Vehiculos.findByLinea", query = "SELECT v FROM Vehiculos v WHERE v.linea = :linea")
    , @NamedQuery(name = "Vehiculos.findByColor", query = "SELECT v FROM Vehiculos v WHERE v.color = :color")
    , @NamedQuery(name = "Vehiculos.findByMotor", query = "SELECT v FROM Vehiculos v WHERE v.motor = :motor")
    , @NamedQuery(name = "Vehiculos.findByCapacidad", query = "SELECT v FROM Vehiculos v WHERE v.capacidad = :capacidad")
    , @NamedQuery(name = "Vehiculos.findByPesoVacio", query = "SELECT v FROM Vehiculos v WHERE v.pesoVacio = :pesoVacio")
    , @NamedQuery(name = "Vehiculos.findByEstadoIntegridad", query = "SELECT v FROM Vehiculos v WHERE v.estadoIntegridad = :estadoIntegridad")})
public class Vehiculos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "placas")
    private String placas;
    @Basic(optional = false)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "ejes")
    private Short ejes;
    @Basic(optional = false)
    @Column(name = "chasis")
    private String chasis;
    @Basic(optional = false)
    @Column(name = "linea")
    private String linea;
    @Basic(optional = false)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @Column(name = "motor")
    private String motor;
    @Basic(optional = false)
    @Column(name = "capacidad")
    private Double capacidad;
    @Basic(optional = false)
    @Column(name = "pesoVacio")
    private Double pesoVacio;
    @Basic(optional = false)
    @Column(name = "estadoIntegridad")
    private Boolean estadoIntegridad;
    @ManyToMany(mappedBy = "vehiculosList")
    private List<Propietarios> propietariosList;
    @JoinColumn(name = "satelites_usuario", referencedColumnName = "usuario")
    @ManyToOne(optional = false)
    private Satelites satelite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoPlacas")
    private List<Entregas> entregasList;

    public Vehiculos() {
    }

    public Vehiculos(String placas) {
        this.placas = placas;
    }

    public Vehiculos(String placas, String marca, String modelo, String tipo, Short ejes, String chasis, String linea, String color, String motor, Double capacidad, Double pesoVacio, Boolean estadoIntegridad,Satelites satelite) {
        this.placas = placas;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.ejes = ejes;
        this.chasis = chasis;
        this.linea = linea;
        this.color = color;
        this.motor = motor;
        this.capacidad = capacidad;
        this.pesoVacio = pesoVacio;
        this.estadoIntegridad = estadoIntegridad;
        this.satelite=satelite;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Short getEjes() {
        return ejes;
    }

    public void setEjes(Short ejes) {
        this.ejes = ejes;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public Double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Double capacidad) {
        this.capacidad = capacidad;
    }

    public Double getPesoVacio() {
        return pesoVacio;
    }

    public void setPesoVacio(Double pesoVacio) {
        this.pesoVacio = pesoVacio;
    }

    public Boolean getEstadoIntegridad() {
        return estadoIntegridad;
    }

    public void setEstadoIntegridad(Boolean estadoIntegridad) {
        this.estadoIntegridad = estadoIntegridad;
    }

    @XmlTransient
    public List<Propietarios> getPropietariosList() {
        return propietariosList;
    }

    public void setPropietariosList(List<Propietarios> propietariosList) {
        this.propietariosList = propietariosList;
    }

    public Satelites getSatelite() {
        return satelite;
    }

    public void setSatelite(Satelites satelite) {
        this.satelite = satelite;
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
        hash += (placas != null ? placas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculos)) {
            return false;
        }
        Vehiculos other = (Vehiculos) object;
        if ((this.placas == null && other.placas != null) || (this.placas != null && !this.placas.equals(other.placas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.logitransportes.logic.capaModelador.Vehiculos[ placas=" + placas + " ]";
    }
    
}
