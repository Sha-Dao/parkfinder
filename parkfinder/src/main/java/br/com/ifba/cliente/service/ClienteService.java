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
    public boolean checkLoginCliente(String email, String senha) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkLoginCliente'");
    }


    @Override
    public boolean findByUsername(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByUsername'");
    }

  



    

}
