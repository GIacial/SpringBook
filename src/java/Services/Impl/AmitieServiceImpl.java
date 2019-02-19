/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services.Impl;

import Database.Dao.AmitieDAO;
import Database.Dao.IdentityDAO;
import Database.Entity.AmitieEntity;
import Database.Entity.IdentityEntity;
import Services.AmitieService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author jérémy
 */
@Service
public class AmitieServiceImpl implements AmitieService {
    
    @Resource
    private AmitieDAO amitieR;
    
    @Resource
    private IdentityDAO identityR;
    

    @Override
    public List<IdentityEntity> getMyFriends(IdentityEntity me) {
        return amitieR.getMyFriends(me);
    }

    @Override
    public void addAmi(IdentityEntity me, IdentityEntity ami) {
        AmitieEntity amitie = new AmitieEntity(me,ami);
        amitieR.save(amitie);
    }

    @Override
    public boolean isMyFriends(IdentityEntity me, IdentityEntity ami) {
        return amitieR.isMyFriends(me, ami).size() > 0;
    }

    @Override
    public List<IdentityEntity> getAllFuturFriends(IdentityEntity me) {
        List<IdentityEntity> allUser = this.identityR.findOthersPeople(me);
        List<IdentityEntity> unknowUser = new ArrayList<>();
        for(IdentityEntity user : allUser){
            if(!this.isMyFriends(me, user)){
                unknowUser.add(user);
            }
        }
        return unknowUser;
    }
    
}
