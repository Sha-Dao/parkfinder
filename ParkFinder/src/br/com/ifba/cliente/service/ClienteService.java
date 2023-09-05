package br.com.ifba.cliente.service;

import br.com.ifba.cliente.dao.ClienteDAO;
import br.com.ifba.cliente.model.Cliente;
import java.util.List;
import br.com.ifba.cliente.dao.IClienteDAO;

public class ClienteService implements IClienteService{
    
    private final IClienteDAO usuarioDAO = new ClienteDAO();

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
        return usuarioDAO.update(usuario);
    }

    @Override
    public List<Cliente> findAllCliente() {
        return usuarioDAO.findAll();
    }

    @Override
    public boolean checkLoginCliente(String username, String password) {
        return usuarioDAO.checkLogin(username, password);
    }

    @Override
    public boolean findByUsername(String username) {
        return usuarioDAO.findByUsername(username);
    }


    

}
