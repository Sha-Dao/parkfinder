package br.com.ifba.area.dao;

import br.com.ifba.area.model.Area;
import br.com.ifba.cliente.model.Cliente;
import br.com.ifba.infrastructure.dao.IBaseDao;

/**
 *
 * @author Dani
 */
public interface IAreaDAO extends IBaseDao<Cliente>{

    public Area save(Area area);
    
    //public boolean checkLogin(String username, String password);
    //public boolean findByUsername(String username);
    
}
