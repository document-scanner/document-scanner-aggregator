/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.document.scanner.storage;

/**
 *
 * @author richter
 */
public interface Storage {
    void store(Object object);
    
    <T> T retrieve(Long id, Class<T> clazz);
}
