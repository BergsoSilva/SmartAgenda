/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObjectInterface;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Unknown
 */
public interface GenericDAOInterface<T,I extends Serializable>{
    public T save(T entity);
    public void remove(T entity);
    public T getById(Class<T> classe, I pk);
    public List<T> getAll(Class<T> classe);
    public T edit(T entiyt);
    public EntityManager getEntitymanager();
    
}
