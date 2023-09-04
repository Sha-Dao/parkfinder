package br.com.ifba.cliente.dao;

import br.com.ifba.infrastructure.dao.IBaseDao;
import br.com.ifba.cliente.model.Cliente;


public interface IClienteDAO extends IBaseDao<Cliente>{
    
    public boolean checkLogin(String username, String password);
    public boolean findByUsername(String username);
    
}
