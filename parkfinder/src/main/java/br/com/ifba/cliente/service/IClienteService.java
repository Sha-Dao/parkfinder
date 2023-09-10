package br.com.ifba.cliente.service;

import br.com.ifba.cliente.model.Cliente;
import java.util.List;



public interface IClienteService {
    
    
    public Cliente saveCliente(Cliente usuario);
    public void deleteCliente(Cliente usuario);
    public Cliente updateCliente(Cliente usuario);
    public List<Cliente> findAllCliente();
    public boolean checkLoginCliente(String email, String senha);
    public boolean findByUsername(String email);
    
}
