package cl.auter.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract class BaseDAO<T> {
private Class<T> entityClass;
EntityManager em;

public BaseDAO(Class<T> entityClass,EntityManager em  ) {
    this.entityClass = entityClass;
    this.em=em;
}
public T persist(T entity) {
    try{
        em.persist(entity);
        return entity;
    }
    catch(Exception ex){
        return null;
    }    
}

public T edit(T entity) {
    em.merge(entity);
    return entity;
}

public T remove(T entity) {
    em.remove(em.merge(entity));
    return entity;
}

public List<T> findAll() {
    Query q = em.createQuery("SELECT e FROM " + entityClass.getName()+ " e");
    List<T> list = (List<T>) q.getResultList();
    return list;
}

    public T find(int id) {
        T e = em.find(entityClass, id);
        return e;
    }
    public EntityManager getEm() {
            return em;
    }
    public void setEm(EntityManager em) {
            this.em = em;
    }	    
}
