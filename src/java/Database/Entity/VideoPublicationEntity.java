/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database.Entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author jérémy
 */
@Entity
@DiscriminatorValue( value="VIDEO" )
public class VideoPublicationEntity extends PublicationEntity {
    
    private String srcVideo;
    
    //Constructeur
    public VideoPublicationEntity (){
        this("","", null , null);
    }
    
    public VideoPublicationEntity(String msg ,String src, IdentityEntity auteur , IdentityEntity mur){
        super(msg , auteur , mur);
        this.srcVideo = src;
    }
    
    //getter setter

    @Override
    public String getSrcVideo() {
        return srcVideo;
    }

    public void setSrcVideo(String srcVideo) {
        this.srcVideo = srcVideo;
    }
    
    
   
    
}
