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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "licencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Licencias.findAll", query = "SELECT l FROM Licencias l")
    , @NamedQuery(name = "Licencias.findByNumeroLicencia", query = "SELECT l FROM Licencias l WHERE l.numeroLicencia = :numeroLicencia")
    , @NamedQuery(name = "Licencias.findByCategorias", query = "SELECT l FROM Licencias l WHERE l.categorias = :categorias")
    , @NamedQuery(name = "Licencias.findByVigencia", query = "SELECT l FROM Licencias l WHERE l.vigencia = :vigencia")
    , @NamedQuery(name = "Licencias.findByEstadoIntegridad", query = "SELECT l FROM Licencias l WHERE l.estadoIntegridad = :estadoIntegridad")})
public class Licencias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numeroLicencia")
    private Long numeroLicencia;
    @Basic(optional = false)
    @Column(name = "categorias")
    private String categorias;
    @Basic(optional = false)
    @Column(name = "vigencia")
    @Temporal(TemporalType.DATE)
    private Date vigencia;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroLicencia")
    private List<Conductores> conductoresList;

    public Licencias() {
    }

    public Licencias(Long numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public Licencias(Long numeroLicencia, String categorias, Date vigencia) {
        this.numeroLicencia = numeroLicencia;
        this.categorias = categorias;
        this.vigencia = vigencia;
    }

    public Long getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(Long numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public String getCategorias() {
        return categorias;
    }

    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    @XmlTransient
    public List<Conductores> getConductoresList() {
        return conductoresList;
    }

    public void setConductoresList(List<Conductores> conductoresList) {
        this.conductoresList = conductoresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroLicencia != null ? numeroLicencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Licencias)) {
            return false;
        }
        Licencias other = (Licencias) object;
        if ((this.numeroLicencia == null && other.numeroLicencia != null) || (this.numeroLicencia != null && !this.numeroLicencia.equals(other.numeroLicencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.logitransportes.logic.capaModelador.Licencias[ numeroLicencia=" + numeroLicencia + " ]";
    }
    
}
