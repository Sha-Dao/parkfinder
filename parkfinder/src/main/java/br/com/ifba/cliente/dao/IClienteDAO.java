package br.com.ifba.cliente.dao;


import br.com.ifba.cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IClienteDAO extends JpaRepository<Cliente, Long>{
    
    public boolean checkLogin(String username, String password);
    public boolean findByUsername(String username);
 
}
