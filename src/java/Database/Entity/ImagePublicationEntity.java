/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database.Entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author jérémy
 */
@Entity
@DiscriminatorValue( value="IMAGE" )
public class ImagePublicationEntity extends PublicationEntity {
    
    @Column
    private String cheminImage;
    
    //constructeur
    public ImagePublicationEntity( String message,String path, IdentityEntity auteur, IdentityEntity mur) {
        super(message, auteur, mur);
        this.cheminImage = path;
    }

    public ImagePublicationEntity() {
        super();
    }
    
    //getter setter
    @Override
    public String getCheminImage() {
        return cheminImage;
    }

    public void setCheminImage(String path) {
        this.cheminImage = path;
    }
    
    
}
