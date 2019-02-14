/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database.Dao.Impl;

import Database.Dao.AuthentificationDAO;
import Database.Entity.AuthentificationEntity;
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
public class AuthentificationDAOImpl implements AuthentificationDAO {
    
    @PersistenceContext(unitName="SpringBookPU")
    private EntityManager em;
    public EntityManager getEm() {
        return em;
    }
    
    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    //code
    @Transactional
    @Override
    public void save(AuthentificationEntity h) {
        h = em.merge(h);
        em.persist(h);
    }

    
    @Transactional
    @Override
    public void update(AuthentificationEntity h) {
        em.merge(h);
    }

    
    @Transactional
    @Override
    public void delete(AuthentificationEntity h) {
        h = em.merge(h);
        em.remove(h);
    }

    
    @Transactional(readOnly = true)
    @Override
    public AuthentificationEntity find(long id) {
        return em.find(AuthentificationEntity.class, id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<AuthentificationEntity> findAll() {
        Query q = em.createQuery("SELECT h FROM AuthentificationEntity h");
        return q.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<AuthentificationEntity> findByEMail(String email) {
        Query q = em.createQuery("SELECT a FROM AuthentificationEntity a WHERE a.email LIKE :email").setParameter("email",email);
        return q.getResultList();
    }

}
