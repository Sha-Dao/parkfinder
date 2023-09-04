package br.com.ifba.cliente.service;

import br.com.ifba.clinte.dao.ClienteDAO;
import br.com.ifba.cliente.model.Cliente;
import java.util.List;
import br.com.ifba.clinte.dao.IClienteDAO;

public class ClienteService implements IClienteService{
    
    private final IClienteDAO usuarioDAO = new ClienteDAO();

    @Override
    public Cliente saveUsuario(Cliente usuario) {
        return usuarioDAO.save(usuario);
    }

    @Override
    public void deleteUsuario(Cliente usuario) {
        usuarioDAO.delete(usuario);
    }

    @Override
    public Cliente updateUsuario(Cliente usuario) {
        return usuarioDAO.update(usuario);
    }

    @Override
    public List<Cliente> findAllUsuario() {
        return usuarioDAO.findAll();
    }

    @Override
    public boolean checkLoginUsuario(String username, String password) {
        return usuarioDAO.checkLogin(username, password);
    }

    @Override
    public boolean findByUsername(String username) {
        return usuarioDAO.findByUsername(username);
    }


    

}
