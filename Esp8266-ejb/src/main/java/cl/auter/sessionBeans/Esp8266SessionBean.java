/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.auter.sessionBeans;

import cl.auter.bmp.UserDataEntity;
import cl.auter.dao.UserDataDAO;
import cl.auter.patrol.UserDataTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author drobles
 */
@Stateless
public class Esp8266SessionBean implements Esp8266SessionBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "Esp8266-PU")
    private EntityManager entityManager;
    
    @Override
    public List<UserDataTO> getUsers() throws Exception{
        UserDataDAO dao = new UserDataDAO(UserDataEntity.class, entityManager);
        return dao.buscarTodos();
    }
    
    @Override
    public UserDataTO getUserById(int id) throws Exception{
        UserDataDAO dao = new UserDataDAO(UserDataEntity.class, entityManager);
        return dao.obtenerUsuarioPorId(id);
    }
    
}
