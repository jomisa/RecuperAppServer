/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmss1
 */
@Entity
@Table(name = "tabla_lista_sintomas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListaSintomas.findAll", query = "SELECT l FROM ListaSintomas l"),
    @NamedQuery(name = "ListaSintomas.findByIdSintoma", query = "SELECT l FROM ListaSintomas l WHERE l.idSintoma = :idSintoma"),
    @NamedQuery(name = "ListaSintomas.findBySintoma", query = "SELECT l FROM ListaSintomas l WHERE l.sintoma = :sintoma")})
public class ListaSintomas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SINTOMA")
    private Integer idSintoma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "SINTOMA")
    private String sintoma;

    public ListaSintomas() {
    }

    public ListaSintomas(Integer idSintoma) {
        this.idSintoma = idSintoma;
    }

    public ListaSintomas(Integer idSintoma, String sintoma) {
        this.idSintoma = idSintoma;
        this.sintoma = sintoma;
    }

    public Integer getIdSintoma() {
        return idSintoma;
    }

    public void setIdSintoma(Integer idSintoma) {
        this.idSintoma = idSintoma;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSintoma != null ? idSintoma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaSintomas)) {
            return false;
        }
        ListaSintomas other = (ListaSintomas) object;
        if ((this.idSintoma == null && other.idSintoma != null) || (this.idSintoma != null && !this.idSintoma.equals(other.idSintoma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ListaSintomas[ idSintoma=" + idSintoma + " ]";
    }
    
}
