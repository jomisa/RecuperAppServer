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
@Table(name = "tabla_lista_sintomas_caminata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListaSintomasCaminata.findAll", query = "SELECT l FROM ListaSintomasCaminata l"),
    @NamedQuery(name = "ListaSintomasCaminata.findByIdSintomaCaminata", query = "SELECT l FROM ListaSintomasCaminata l WHERE l.idSintomaCaminata = :idSintomaCaminata"),
    @NamedQuery(name = "ListaSintomasCaminata.findBySintoma", query = "SELECT l FROM ListaSintomasCaminata l WHERE l.sintoma = :sintoma")})
public class ListaSintomasCaminata implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SINTOMA_CAMINATA")
    private Integer idSintomaCaminata;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "SINTOMA")
    private String sintoma;

    public ListaSintomasCaminata() {
    }

    public ListaSintomasCaminata(Integer idSintomaCaminata) {
        this.idSintomaCaminata = idSintomaCaminata;
    }

    public ListaSintomasCaminata(Integer idSintomaCaminata, String sintoma) {
        this.idSintomaCaminata = idSintomaCaminata;
        this.sintoma = sintoma;
    }

    public Integer getIdSintomaCaminata() {
        return idSintomaCaminata;
    }

    public void setIdSintomaCaminata(Integer idSintomaCaminata) {
        this.idSintomaCaminata = idSintomaCaminata;
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
        hash += (idSintomaCaminata != null ? idSintomaCaminata.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaSintomasCaminata)) {
            return false;
        }
        ListaSintomasCaminata other = (ListaSintomasCaminata) object;
        if ((this.idSintomaCaminata == null && other.idSintomaCaminata != null) || (this.idSintomaCaminata != null && !this.idSintomaCaminata.equals(other.idSintomaCaminata))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ListaSintomasCaminata[ idSintomaCaminata=" + idSintomaCaminata + " ]";
    }
    
}
