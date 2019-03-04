/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database.Dao.Impl;

import Database.Dao.NotificationDAO;
import Database.Entity.IdentityEntity;
import Database.Entity.NotificationEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jérémy
 */

@Repository
public class NotificationDAOImpl implements NotificationDAO {
    
    

    @PersistenceContext(unitName="SpringBookPU")
    private EntityManager em;
    public EntityManager getEm() {
        return em;
    }
    
    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    //ovveride

    @Override
    @Transactional
    public NotificationEntity save(NotificationEntity h) {
        h = em.merge(h);
        em.persist(h);
        return h;
    }

    @Override 
    @Transactional
    public void update(NotificationEntity h) {
        em.merge(h);
    }

    @Override 
    @Transactional
    public void delete(NotificationEntity h) {
         h = em.merge(h);
        em.remove(h);
    }

    @Override 
    @Transactional(readOnly = true)
    public NotificationEntity find(long id) {
        return em.find(NotificationEntity.class, id);
    }

    @Override 
    @Transactional(readOnly = true)
    public List<NotificationEntity> findAll() {
        Query q = em.createQuery("SELECT n FROM NotificationEntity n");
        return q.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<NotificationEntity> findMyNotif(IdentityEntity me) {
        Query q = em.createQuery("SELECT n FROM NotificationEntity n join n.cible i WHERE i.id = :idMur").setParameter("idMur",me.getId());
        return q.getResultList();
    }
    
}
