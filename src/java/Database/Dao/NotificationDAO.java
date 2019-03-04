/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database.Dao;

import Database.Entity.IdentityEntity;
import Database.Entity.NotificationEntity;
import java.util.List;

/**
 *
 * @author jérémy
 */
public interface NotificationDAO extends AbstractDAO<NotificationEntity> {
    
    public List<NotificationEntity> findMyNotif(IdentityEntity me);
}
