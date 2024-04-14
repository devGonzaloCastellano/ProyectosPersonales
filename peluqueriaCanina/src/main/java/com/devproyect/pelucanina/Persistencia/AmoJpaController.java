package com.devproyect.pelucanina.Persistencia;

import com.devproyect.pelucanina.Logica.Amo;
import com.devproyect.pelucanina.Persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class AmoJpaController implements Serializable {

    public AmoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManagerFactory emf = null;

    public AmoJpaController() {
        emf = Persistence.createEntityManagerFactory("PeluqueriaCaninaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Amo amo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(amo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Amo amo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            amo = em.merge(amo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = amo.getIdAmo();
                if (findAmo(id) == null) {
                    throw new NonexistentEntityException("The amo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Amo amo;
            try {
                amo = em.getReference(Amo.class, id);
                amo.getIdAmo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The amo with id " + id + " no longer exists.", enfe);
            }
            em.remove(amo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Amo> findAmoEntities() {
        return findAmoEntities(true, -1, -1);
    }

    public List<Amo> findAmoEntities(int maxResults, int firstResult) {
        return findAmoEntities(false, maxResults, firstResult);
    }

    private List<Amo> findAmoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Amo.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Amo findAmo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Amo.class, id);
        } finally {
            em.close();
        }
    }

    public int getAmoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Amo> rt = cq.from(Amo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
