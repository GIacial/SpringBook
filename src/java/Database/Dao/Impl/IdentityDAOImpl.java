/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database.Dao.Impl;

import Database.Dao.IdentityDAO;
import Database.Entity.IdentityEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class IdentityDAOImpl implements IdentityDAO {

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
    public IdentityEntity save(IdentityEntity h) {
        
        h = em.merge(h);
        em.persist(h);
        return h;
    }

    @Override
    @Transactional
    public void update(IdentityEntity h) {
       em.merge(h);
    }

    @Override
    @Transactional
    public void delete(IdentityEntity h) {
        h = em.merge(h);
        em.remove(h);
    }

    @Override
    @Transactional(readOnly = true)
    public IdentityEntity find(long id) {
        return em.find(IdentityEntity.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<IdentityEntity> findAll() {
        Query q = em.createQuery("SELECT h FROM IdentityEntity h");
        return q.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<IdentityEntity> findByEMail(String email) {
        Query q = em.createQuery("SELECT i FROM IdentityEntity i join i.authentification a WHERE a.email LIKE :email").setParameter("email",email);
        return q.getResultList();
    }
    
}
