/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services.Impl;

import Database.Dao.AmitieDAO;
import Database.Dao.IdentityDAO;
import Database.Entity.IdentityEntity;
import Services.IdentityService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author jérémy
 */
@Service
public class IdentityServiceImpl implements IdentityService {
    
    @Resource
    private IdentityDAO identityR;
    

    @Override
    public IdentityEntity findIdentity(String adresseMail) {
        List<IdentityEntity> identityList = identityR.findByEMail(adresseMail);
        if(identityList.isEmpty()){
            System.err.println("Pas d'identite pour "+ adresseMail);
            return null;
        }
        return identityList.get(0);
    }

    @Override
    public IdentityEntity findIdentity(long key) {
        return identityR.find(key);
    }

    @Override
    public List<IdentityEntity> findByName(String name) {
        return identityR.findByName(name);
    }
    
}
