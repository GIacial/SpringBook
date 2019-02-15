/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database.Dao;

import Database.Entity.IdentityEntity;
import java.util.List;

/**
 *
 * @author jérémy
 */
public interface IdentityDAO extends AbstractDAO<IdentityEntity> {
    
    public List<IdentityEntity> findByEMail(String email);
}
