/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObjectInterface;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import util.ConnectionFactory;

/**
 *
 * @author Unknown
 */
public abstract class DAOImpl<T,Long extends Serializable> implements GenericDAOInterface<T, Long>{
    
  private   EntityManager entymanager=null;

    public DAOImpl() {
        
        getEntitymanager();
    }
  
  

    @Override
    public T save(T entity) {

             T saved = null;
            entymanager.getTransaction().begin();
            saved= entymanager.merge(entity);
            entymanager.getTransaction().commit();
            return  saved;
      
    }

    @Override
    public void remove(T entity) {
        entymanager.getTransaction().begin();
        entymanager.remove(entymanager.contains(entity) ? entity : entymanager.merge(entity));
        entymanager.getTransaction().commit();
        
    }

    @Override
    public T getById(Class<T> classe, Long pk) {
        try{
            return getEntitymanager().find(classe, pk);
        }catch(NoResultException ex){
            return null;
        }
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAll(Class<T> classe) {
      
        Query query = entymanager.createQuery("select o from  "+classe.getName()+" o ");
       
        return query.getResultList();
        
    }
     
    @Override
    public T edit(T entity){
        entymanager.merge(entity);
        return entity;
    }
    
    @Override
    public EntityManager getEntitymanager() {
        if(entymanager==null){
             entymanager= ConnectionFactory.getEntityManagerFactory();
        }
        return  entymanager;
    }
  
}
