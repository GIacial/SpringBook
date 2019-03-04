/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author jérémy
 */
@Entity
public class IdentityEntity implements Serializable {
    
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
       
    @Column
    private String pseudo;
    
    @Column
    private String adresse;
    
    @Column
    private String ville;
    
    @Column
    private String codePostal;
    
    @Column
    private String naissance;
    
    @Column
    private String genre;
    
    @Column
    private String profession;
    
    @OneToOne
    private AuthentificationEntity authentification;
    
    
    //constructeur
    public IdentityEntity(String pseudo) {
        this.pseudo = pseudo;
    }
    
    public IdentityEntity(String pseudo,String adresse , String ville , String codePostal , String naissance , String genre , String professions ) {
        this(pseudo);
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.naissance = naissance;
        this.genre = genre;
        this.profession = professions;
    }
    
    public IdentityEntity() {
        this("");
    }
    

    //getter setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getNaissance() {
        return naissance;
    }

    public void setNaissance(String naissance) {
        this.naissance = naissance;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String professions) {
        this.profession = professions;
    }

    public AuthentificationEntity getAuthentification() {
        return authentification;
    }

    public void setAuthentification(AuthentificationEntity authentification) {
        this.authentification = authentification;
    }


    

    //Override
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdentityEntity)) {
            return false;
        }
        IdentityEntity other = (IdentityEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Entity.IdentityEntity[ id=" + id + " ]";
    }
    
}
