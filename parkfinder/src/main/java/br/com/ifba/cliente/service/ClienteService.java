package br.com.ifba.cliente.service;


import br.com.ifba.cliente.model.Cliente;
import java.util.List;
import br.com.ifba.cliente.dao.IClienteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{
    
    @Autowired
    private IClienteDAO usuarioDAO;
    
     public ClienteService() {
  
    }

    
    @Override
    public Cliente saveCliente(Cliente usuario) {
        return usuarioDAO.save(usuario);
    }

    @Override
    public void deleteCliente(Cliente usuario) {
        usuarioDAO.delete(usuario);
    }

    @Override
    public Cliente updateCliente(Cliente usuario) {
        return usuarioDAO.save(usuario);
    }

    @Override
    public List<Cliente> findAllCliente() {
        return usuarioDAO.findAll();
    }

    @Override
    public Cliente findByUsername(String email) {
      return usuarioDAO.findByUsername(email);

    }


    @Override
    public Cliente checkLoginCliente(String email, String senha) {
        return usuarioDAO.checkLogin(email, senha);

        
    }

  



    

}
