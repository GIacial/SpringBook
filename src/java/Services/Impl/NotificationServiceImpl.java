/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services.Impl;

import Database.Dao.NotificationDAO;
import Database.Entity.IdentityEntity;
import Database.Entity.NotificationEntity;
import Services.NotificationService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author jérémy
 */
@Service
public class NotificationServiceImpl  implements NotificationService{
    
    @Resource
    private NotificationDAO notifications;
    

    @Override
    public void createNotification(String msg, IdentityEntity auteur, IdentityEntity cible) {
        NotificationEntity notif = new NotificationEntity(msg,auteur,cible);
        notifications.save(notif);
    }

    @Override
    public List<NotificationEntity> getMyNotification(IdentityEntity me) {
        return notifications.findMyNotif(me);
    }
}
