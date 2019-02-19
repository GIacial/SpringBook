/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author jérémy
 */
@Entity
public class AmitieEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne
    private IdentityEntity poss;
    
    @OneToOne
    private IdentityEntity ami;
    
    //constructeur
    
    public AmitieEntity (IdentityEntity poss , IdentityEntity ami){
        this.ami = ami;
        this.poss = poss;
    }
    
    public AmitieEntity(){
        this(null,null);
    }
    
    //getter setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IdentityEntity getPoss() {
        return poss;
    }

    public void setPoss(IdentityEntity poss) {
        this.poss = poss;
    }

    public IdentityEntity getAmi() {
        return ami;
    }

    public void setAmi(IdentityEntity ami) {
        this.ami = ami;
    }

    //override
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmitieEntity)) {
            return false;
        }
        AmitieEntity other = (AmitieEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Entity.AmitieEntity[ id=" + id + " ]";
    }
    
}
