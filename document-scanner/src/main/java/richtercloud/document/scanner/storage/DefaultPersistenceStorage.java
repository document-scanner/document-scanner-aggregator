/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.document.scanner.storage;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.slf4j.LoggerFactory;

/**
 *
 * @author richter
 */
public class DefaultPersistenceStorage extends PersistenceStorage {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PersistenceStorage.class);
    private Connection conn;
    private EntityManager entityManager;

    public DefaultPersistenceStorage(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    protected EntityManager retrieveEntityManager() {
        return this.entityManager;
    }
    
    public void recreateEntityManager(EntityManagerFactory entityManagerFactory, String connectionURL, String username, String password) {
        Map<String, String> properties = new HashMap<>(3);
        properties.put("javax.persistence.jdbc.url", connectionURL);
        properties.put("javax.persistence.jdbc.user", username);
        properties.put("javax.persistence.jdbc.password", password);
        this.entityManager = entityManagerFactory.createEntityManager(properties);
    }
}
