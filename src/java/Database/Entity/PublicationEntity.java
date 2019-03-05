/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author jérémy
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn( name = "type" )
@DiscriminatorValue( value="TEXT" )
public class PublicationEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String message;
    
    @ManyToOne
    private IdentityEntity auteur;
    
    
    @OneToOne
    private IdentityEntity mur;
    
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date creation;
    
    //constructeur
    public PublicationEntity(String message, IdentityEntity auteur, IdentityEntity mur) {
        this.message = message;
        this.auteur = auteur;
        this.mur = mur;
        this.creation = new Date();
    }
    
    public PublicationEntity() {
        this("",null,null);
    }
    
    

    //g s
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public IdentityEntity getAuteur() {
        return auteur;
    }

    public void setAuteur(IdentityEntity auteur) {
        this.auteur = auteur;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public IdentityEntity getMur() {
        return mur;
    }

    public void setMur(IdentityEntity mur) {
        this.mur = mur;
    }
    
      public String getCheminImage() {
        return null;
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
        if (!(object instanceof PublicationEntity)) {
            return false;
        }
        PublicationEntity other = (PublicationEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Entity.PublicationEntity[ id=" + id + " ]";
    }
    
}
