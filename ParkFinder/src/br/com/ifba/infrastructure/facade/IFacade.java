package br.com.ifba.infrastructure.facade;

import br.com.ifba.cliente.model.Cliente;
import java.util.List;


public interface IFacade {
    
    //PESSOA
//    public Pessoa savePessoa(Pessoa pessoa);
//    public void deletePessoa(Pessoa pessoa);
//    public Pessoa updatePessoa(Pessoa pessoa);
//    public List<Pessoa> findAllPessoa();
//    public List<Pessoa> findByNamePessoa(String name);
    
    //USUARIO
    public Cliente saveUsuario(Cliente usuario);
    public void deleteUsuario(Cliente usuario);
    public Cliente updateUsuario(Cliente usuario);
    public List<Cliente> findAllUsuario();
    public boolean checkLoginUsuario(String username, String password);
    public boolean findByUsernameUsuario(String username);
    
}