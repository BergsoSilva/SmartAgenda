/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObjectInterface;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import util.ConnectionFactory;

/**
 *
 * @author Unknown
 */
public abstract class DAOImpl<T,I extends Serializable> implements GenericDAOInterface<T, I>{
    
  private   EntityManager entymanager= ConnectionFactory.getEntityManagerFactory();

    public DAOImpl() {
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
        entymanager.remove(entity);
        entymanager.getTransaction().commit();
        
    }

    @Override
    public T getById(Class<T> classe, I pk) {
        try{
            return getEntitymanager().find(classe, pk);
        }catch(NoResultException ex){
            return null;
        }
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAll(Class<T> classe) {
        return entymanager.createQuery("select o from "+ classe.getSimpleName()+" o ").getResultList();
        
    }

    @Override
    public EntityManager getEntitymanager() {
        if(entymanager==null){
             entymanager= ConnectionFactory.getEntityManagerFactory();
        }
        return  entymanager;
    }
  
}
