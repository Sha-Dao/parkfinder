package br.com.ifba.cliente.dao;


import br.com.ifba.cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface IClienteDAO extends JpaRepository<Cliente, Long>{

        @Query("select j from Cliente j where j.email = :email and j.senha= :senha")
         public Cliente checkLogin(String email, String senha);

        @Query("select i from Cliente i where i.email = :email")
         public Cliente findByUsername(String email);
     
  
 
}
