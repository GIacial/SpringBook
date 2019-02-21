/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services.Impl;

import Database.Dao.PublicationDAO;
import Database.Entity.IdentityEntity;
import Database.Entity.PublicationEntity;
import Services.PublicationService;
import java.util.List;
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
    
}
