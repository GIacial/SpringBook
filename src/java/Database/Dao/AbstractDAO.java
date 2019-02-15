/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database.Dao;

import java.util.List;

/**
 *
 * @author jérémy
 */
public interface AbstractDAO <T> {
    
    public T save(T h);
    public void update(T h);
    public void delete(T h);
    public T find(long id);
    public List<T> findAll();
}
