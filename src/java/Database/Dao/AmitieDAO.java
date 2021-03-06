/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database.Dao;

import Database.Entity.AmitieEntity;
import Database.Entity.IdentityEntity;
import java.util.List;

/**
 *
 * @author jérémy
 */
public interface AmitieDAO extends AbstractDAO <AmitieEntity>{
    
    public List<IdentityEntity> getMyFriends (IdentityEntity me);
    public List<IdentityEntity> isMyFriends (IdentityEntity me , IdentityEntity ami);
    public List<AmitieEntity> getMyLink(IdentityEntity me , IdentityEntity ami);
    
}
