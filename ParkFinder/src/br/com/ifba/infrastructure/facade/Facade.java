package br.com.ifba.infrastructure.facade;

import br.com.ifba.cliente.model.Cliente;
import br.com.ifba.cliente.service.ClienteService;
import java.util.List;
import br.com.ifba.cliente.service.IClienteService;


public class Facade implements IFacade {
    
    //PESSOA
//    private final IPessoaService pessoaService = new PessoaService();
//
//    @Override
//    public Pessoa savePessoa(Pessoa pessoa) {
//        return pessoaService.savePessoa(pessoa);
//    }
//
//    @Override
//    public void deletePessoa(Pessoa pessoa) {
//        pessoaService.deletePessoa(pessoa);
//    }
//
//    @Override
//    public Pessoa updatePessoa(Pessoa pessoa) {
//        return pessoaService.updatePessoa(pessoa);
//    }
//
//    @Override
//    public List<Pessoa> findAllPessoa() {
//        return pessoaService.findAllPessoa();
//    }
//
//    @Override
//    public List<Pessoa> findByNamePessoa(String name) {
//        return pessoaService.findByNamePessoa(name);
//    }

    
    //CLIENTE
    private final IClienteService usuarioService = new ClienteService();

    
    @Override
    public Cliente saveUsuario(Cliente usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    @Override
    public void deleteUsuario(Cliente usuario) {
        usuarioService.deleteUsuario(usuario);
    }

    @Override
    public Cliente updateUsuario(Cliente usuario) {
        return usuarioService.updateUsuario(usuario);
    }

    @Override
    public List<Cliente> findAllUsuario() {
        return usuarioService.findAllUsuario();
    }

    @Override
    public boolean checkLoginUsuario(String username, String password) {
        return usuarioService.checkLoginUsuario(username, password);
    }

    @Override
    public boolean findByUsernameUsuario(String username) {
        return usuarioService.findByUsername(username);
    }
    
    
}