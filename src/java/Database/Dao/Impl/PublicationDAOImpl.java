/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database.Dao.Impl;

import Database.Dao.PublicationDAO;
import Database.Entity.IdentityEntity;
import Database.Entity.PublicationEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PublicationDAOImpl implements PublicationDAO {
    
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
    public PublicationEntity save(PublicationEntity h) {
         h = em.merge(h);
        em.persist(h);
        return h;
    }

    @Override
    @Transactional
    public void update(PublicationEntity h) {
         h = em.merge(h);
    }

    @Override
    @Transactional
    public void delete(PublicationEntity h) {
        h = em.merge(h);
        em.remove(h);
    }

    @Override
    @Transactional(readOnly = true)
    public PublicationEntity find(long id) {
       return em.find(PublicationEntity.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PublicationEntity> findAll() {
        Query q = em.createQuery("SELECT h FROM PublicationEntity h");
        return q.getResultList();
    }
    
}
