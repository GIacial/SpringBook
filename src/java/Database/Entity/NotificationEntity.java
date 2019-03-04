/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author jérémy
 */
@Entity
public class NotificationEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    //value
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    private IdentityEntity auteur;
    
     @ManyToOne
    private IdentityEntity cible;
    
    private String msg;
    
    //constructeur
    
    public NotificationEntity (String msg , IdentityEntity auteur ,  IdentityEntity cible){
        this.msg = msg;
        this.auteur = auteur;
        this.cible = cible;
    }
    
    public NotificationEntity(){
        this("",null,null);
    }

    //getter setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IdentityEntity getCible() {
        return cible;
    }

    public void setCible(IdentityEntity cible) {
        this.cible = cible;
    }

    public IdentityEntity getAuteur() {
        return auteur;
    }

    public void setAuteur(IdentityEntity auteur) {
        this.auteur = auteur;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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
        if (!(object instanceof NotificationEntity)) {
            return false;
        }
        NotificationEntity other = (NotificationEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Entity.NotificationEntity[ id=" + id + " ]";
    }
    
}
