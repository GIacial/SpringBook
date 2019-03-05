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
public interface IdentityService {
    
    public IdentityEntity findIdentity (String adresseMail);
    public IdentityEntity findIdentity(long key);
    public List<IdentityEntity> findByName(String name);
    
}
