/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database.Dao;

import Database.Entity.AuthentificationEntity;
import java.util.List;

/**
 *
 * @author jérémy
 */
public interface AuthentificationDAO extends AbstractDAO<AuthentificationEntity> {
    
    
    public List<AuthentificationEntity> findByEMail(String email);
}
