/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.auter.sessionBeans;

import cl.auter.patrol.UserDataTO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author drobles
 */
@Local
public interface Esp8266SessionBeanLocal {

    public List<UserDataTO> getUsers() throws Exception;
    
    public UserDataTO getUserById(int id) throws Exception;
}
