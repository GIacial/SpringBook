/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services.Impl;

import Database.Dao.PublicationDAO;
import Database.Entity.IdentityEntity;
import Database.Entity.ImagePublicationEntity;
import Database.Entity.PublicationEntity;
import Database.Entity.VideoPublicationEntity;
import Services.PublicationService;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

/**
 *
 * @author jérémy
 */

@Service
public class PublicationServiceImpl implements PublicationService {
    
    @Resource
    private PublicationDAO publications;

    @Override
    public void createPublication(String msg, IdentityEntity auteur , IdentityEntity mur) {
        msg = HtmlUtils.htmlEscape(msg);
        publications.save(new PublicationEntity(msg,auteur, mur));
    }

    @Override
    public List<PublicationEntity> getAllPublication(IdentityEntity mur) {
        return this.publications.getMyWall(mur);
    }

    @Override
    public void createPublication(String msg, String pathMedia, IdentityEntity auteur, IdentityEntity mur) {
        if(pathMedia!= null && !pathMedia.equals("")){
            
            try {
                URL url = new URL(pathMedia);
                msg = HtmlUtils.htmlEscape(msg);
                PublicationEntity pub = null;
                if(pathMedia.contains("https://www.youtube.com/embed/")){
                    //video
                   pub = new VideoPublicationEntity(msg,pathMedia,auteur,mur);
                }
                else{
                   pub = new ImagePublicationEntity(msg,pathMedia,auteur,mur);
                }
                

                publications.save(pub);
                return;
            } catch (MalformedURLException ex) {
                System.err.println("incoret url");
            }
            
        }
        //cas d'erreur
            //redirection sur un publication text
            this.createPublication(msg, auteur, mur);
        
    }
    
}
