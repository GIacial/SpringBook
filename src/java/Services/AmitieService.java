/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import Database.Entity.IdentityEntity;
import java.util.List;

/**
 *
 * @author jérémy
 */
public interface AmitieService {
    
    public List<IdentityEntity> getMyFriends (IdentityEntity me);
    public void addAmi(IdentityEntity me , IdentityEntity ami);
    public boolean isMyFriends (IdentityEntity me , IdentityEntity ami);
    
    public List<IdentityEntity> getAllFuturFriends (IdentityEntity me);
}
