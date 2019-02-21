/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database.Dao.Impl;

import Database.Dao.AmitieDAO;
import Database.Entity.AmitieEntity;
import Database.Entity.IdentityEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class AmitieDAOImpl implements AmitieDAO {
    
    @PersistenceContext(unitName="SpringBookPU")
    private EntityManager em;
    public EntityManager getEm() {
        return em;
    }
    
    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public AmitieEntity save(AmitieEntity h) {
        h = em.merge(h);
        em.persist(h);
        return h;
    }

    @Override
    @Transactional
    public void update(AmitieEntity h) {
        em.merge(h);
    }

    @Override
    @Transactional
    public void delete(AmitieEntity h) {
        h = em.merge(h);
        em.remove(h);
    }

    @Override
    @Transactional(readOnly = true)
    public AmitieEntity find(long id) {
        return em.find(AmitieEntity.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AmitieEntity> findAll() {
        Query q = em.createQuery("SELECT h FROM AmitieEntity h");
        return q.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<IdentityEntity> getMyFriends(IdentityEntity me) {
        Query q = em.createQuery("SELECT a.ami FROM AmitieEntity a  WHERE (a.poss = :me)").setParameter("me",me);
        return q.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<IdentityEntity> isMyFriends(IdentityEntity me, IdentityEntity ami) {    
        Query q = em.createQuery("SELECT a.ami FROM AmitieEntity a  WHERE (a.poss = :me) AND (a.ami = :ami)").setParameter("me",me).setParameter("ami", ami);
        return q.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<AmitieEntity> getMyLink(IdentityEntity me, IdentityEntity ami) {
        Query q = em.createQuery("SELECT a FROM AmitieEntity a  WHERE (a.poss = :me) AND (a.ami = :ami)").setParameter("me",me).setParameter("ami", ami);
        return q.getResultList();
    }
    
}
