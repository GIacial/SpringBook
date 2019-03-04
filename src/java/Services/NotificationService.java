/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import Database.Entity.IdentityEntity;
import Database.Entity.NotificationEntity;
import java.util.List;

/**
 *
 * @author jérémy
 */
public interface NotificationService {
    
    public void createNotification (String msg , IdentityEntity auteur , IdentityEntity cible);
    
    public List<NotificationEntity> getMyNotification(IdentityEntity me);
    
}
