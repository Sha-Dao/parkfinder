package br.com.ifba.cliente.service;

import br.com.ifba.cliente.model.Cliente;
import java.util.List;

public interface IClienteService {
    
    
    public Cliente saveUsuario(Cliente usuario);
    public void deleteUsuario(Cliente usuario);
    public Cliente updateUsuario(Cliente usuario);
    public List<Cliente> findAllUsuario();
    public boolean checkLoginUsuario(String username, String password);
    public boolean findByUsername(String username);
    
}
