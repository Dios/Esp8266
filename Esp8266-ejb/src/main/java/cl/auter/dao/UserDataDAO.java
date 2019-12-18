/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.auter.dao;

import cl.auter.bmp.UserDataEntity;
import cl.auter.patrol.UserDataTO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author drobles
 */
public class UserDataDAO extends BaseDAO<UserDataEntity>{
      public UserDataDAO(Class<UserDataEntity> entityClass, EntityManager em) {
        super(entityClass, em);
    }
    /*
    public String guardar(UserDataTO usuarioTO) throws Exception{
        UserDataEntity usuarioEntity = traspasar(UserDataTO);        
        persist(usuarioEntity);
        usuarioTO.setId(usuarioEntity.getId());
        return "OK";
    }

    public void eliminar(UserDataTO usuarioTO) throws Exception{
        UserDataEntity usuarioEntity = traspasar(UserDataTO);
        usuarioEntity.setId(usuarioTO.getId());
        remove(usuarioEntity);

    }

    public String editar(UserDataTO usuarioTO) throws Exception {
        UserDataEntity usuarioEntity = traspasar(UserDataTO);
        usuarioEntity.setId(usuarioTO.getId());
        edit(usuarioEntity);
        return "OK";
    }
*/
        
    public List<UserDataTO> buscarTodos() throws Exception
    {
        Query query = getEm().createNamedQuery("UserDataEntity.findAll");
        List<UserDataEntity> listaUsuariosEntity = query.getResultList();
        List<UserDataTO> listaUsuariosTO = new ArrayList();
        for (UserDataEntity usuarioEntity : listaUsuariosEntity) {
            listaUsuariosTO.add(traspasar(usuarioEntity));
        }
        return listaUsuariosTO;
    }
    
    public UserDataTO obtenerUsuarioPorId(int id) throws Exception
    {
        Query query = getEm().createNamedQuery("UserDataEntity.findById");
        query.setParameter("id", id);
        List<UserDataEntity> listaRegionEntity = query.getResultList();
        if(!listaRegionEntity.isEmpty())
            return traspasar(listaRegionEntity.get(0));
        return new UserDataTO();   
    }
    
    public UserDataTO obtenerUsuarioPorUsername(String username) throws Exception
    {
        Query query = getEm().createNamedQuery("UserDataEntity.findByUsername");
        query.setParameter("username", username);
        List<UserDataEntity> listaRegionEntity = query.getResultList();
        if(!listaRegionEntity.isEmpty())
            return traspasar(listaRegionEntity.get(0));
        return new UserDataTO();   
    }

    private UserDataTO traspasar(UserDataEntity userEntity) {
        
        UserDataTO user = new UserDataTO();
        user.setId(userEntity.getId());
        user.setUsername(userEntity.getUsername());
        user.setId_chat(userEntity.getIdChat());
        user.setRunning(userEntity.getRunning());
        
        return user;
    }
}
