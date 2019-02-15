/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services.Impl;

import Database.Dao.AuthentificationDAO;
import Database.Entity.AuthentificationEntity;
import Services.IdentificationService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author jérémy
 */
@Service
public class IdentificationServiceImpl implements IdentificationService{
    
    @Resource
    private AuthentificationDAO authentificationR;

    @Override
    public boolean isCorrectIdentifier(String email, String mdp) {
        List<AuthentificationEntity> list = authentificationR.findByEMail(email);
        if(!list.isEmpty()){
            AuthentificationEntity auth = list.get(0);
            return mdp.equals(auth.getMdp());
        }
        return false;
    }
    
}
