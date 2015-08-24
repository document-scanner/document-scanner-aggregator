/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.document.scanner.storage;

import javax.persistence.EntityManager;

/**
 *
 * @author richter
 */
public abstract class PersistenceStorage implements Storage {

    /**
     * a wrapper around {@link EntityManager#persist(java.lang.Object) }
     * @param object 
     */
    @Override
    public void store(Object object) {
        this.retrieveEntityManager().persist(object);
    }

    /**
     * a wrapper around {@link EntityManager#find(java.lang.Class, java.lang.Object) }
     * @param <T>
     * @param id
     * @param clazz
     * @return 
     */
    @Override
    public <T> T retrieve(Long id, Class<T> clazz) {
        T retValue = this.retrieveEntityManager().find(clazz, id);
        return retValue;
    }
    
    /**
     * get the {@link EntityManager} used for persistent storage
     * @return 
     */
    protected abstract EntityManager retrieveEntityManager();
    
}
