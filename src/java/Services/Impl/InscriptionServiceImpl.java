/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services.Impl;

import Database.Dao.AuthentificationDAO;
import Database.Dao.IdentityDAO;
import Database.Entity.AuthentificationEntity;
import Database.Entity.IdentityEntity;
import Services.InscriptionService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

/**
 *
 * @author jérémy
 */
@Service
public class InscriptionServiceImpl implements InscriptionService {
    
    @Resource
    private AuthentificationDAO authentificationR;
    
    @Resource
    private IdentityDAO identityR;

    @Override
    public boolean inscription(String email, String mdp, String pseudo) {
        //vérif
        boolean inscrit = email.length()>0 && mdp.length()>0 && pseudo.length()>0;
        
        email = HtmlUtils.htmlEscape(email);
        pseudo = HtmlUtils.htmlEscape(pseudo);
        
        
        if(inscrit){
            //faire l'inscription
            AuthentificationEntity nouv = new AuthentificationEntity(email,mdp);
            inscrit = this.authentificationR.findByEMail(email).isEmpty();
            if(inscrit){           
                nouv = this.authentificationR.save(nouv);       
                IdentityEntity identity = new IdentityEntity(pseudo);
                
                identity.setAuthentification(nouv);
                this.identityR.save(identity);
            }
        }
        return inscrit;
    }
    
}
