/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services.Impl;

import Services.InscriptionService;
import org.springframework.stereotype.Service;

/**
 *
 * @author jérémy
 */
@Service
public class InscriptionServiceImpl implements InscriptionService {

    public boolean inscription(String email, String mdp, String pseudo) {
        //vérif
        boolean inscrit = email.length()>0 && mdp.length()>0 && pseudo.length()>0;
        
        if(inscrit){
            //faire l'inscription
        }
        return inscrit;
    }
    
}
