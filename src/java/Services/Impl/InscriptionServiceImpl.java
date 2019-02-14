/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services.Impl;

import Database.Dao.AuthentificationDAO;
import Database.Entity.AuthentificationEntity;
import Services.InscriptionService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author jérémy
 */
@Service
public class InscriptionServiceImpl implements InscriptionService {
    
    @Resource
    private AuthentificationDAO authentification;

    @Override
    public boolean inscription(String email, String mdp, String pseudo) {
        //vérif
        boolean inscrit = email.length()>0 && mdp.length()>0 && pseudo.length()>0;
        
        if(inscrit){
            //faire l'inscription
            AuthentificationEntity nouv = new AuthentificationEntity(email,mdp);
            inscrit = this.authentification.findByEMail(email).isEmpty();
            if(inscrit){           
                this.authentification.save(nouv);
            }
        }
        return inscrit;
    }
    
}
