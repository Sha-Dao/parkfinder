package br.com.ifba.cliente.dao;


import br.com.ifba.cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IClienteDAO extends JpaRepository<Cliente, Long>{
    /* 
     * ESSA PARTE PRECISA SER RECONFIGURADA
     * 
     *   public boolean checkLogin(String email, String senha);
         public boolean findByUsername(String email);
     */
  
 
}
