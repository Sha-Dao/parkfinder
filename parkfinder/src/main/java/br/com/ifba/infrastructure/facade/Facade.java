package br.com.ifba.infrastructure.facade;

import br.com.ifba.cliente.model.Cliente;
import br.com.ifba.cliente.service.ClienteService;
import br.com.ifba.cliente.service.IClienteService;
import br.com.ifba.vaga.model.Vaga;
import br.com.ifba.vaga.service.IVagaService;
import br.com.ifba.vaga.service.VagaService;
import br.com.ifba.area.model.Area;
import br.com.ifba.area.service.AreaService;
import br.com.ifba.area.service.IAreaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class Facade implements IFacade {


    //CLIENTE
    @Autowired
    private  IClienteService clienteService;
    
    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteService.saveCliente(cliente);
        
}

    @Override
    public void deleteCliente(Cliente cliente) {
        clienteService.deleteCliente(cliente);
    }

    @Override
    public Cliente updateCliente(Cliente cliente) {
        return clienteService.updateCliente(cliente);
    }

    @Override
    public List<Cliente> findAllCliente() {
        return clienteService.findAllCliente();
    }

    @Override
    public Cliente checkLoginCliente(String username, String password) {
        return clienteService.checkLoginCliente(username, password);
    }

    @Override
    public Cliente findByUsernameCliente(String username) {
        return clienteService.findByUsername(username);
    }

    // VAGA
    @Autowired
    private IVagaService vagaService;
    
    @Override
    public void saveVaga(Vaga vaga) {
        vagaService.saveVaga(vaga);
    }

    @Override
    public void deleteVaga(Vaga vaga) {
        vagaService.deleteVaga(vaga);
    }

    @Override
    public Vaga updateVaga(Vaga vaga) {
        return vagaService.updateVaga(vaga);
    }

    @Override
    public void manipularEstadoVaga(Vaga vaga) {
        vagaService.manipularEstadoVaga(vaga);
    }

    @Override
    public List<Vaga> findAllVaga() {
        return vagaService.findAllVaga();
    }

    // ÁREA
    @Autowired
    private IAreaService areaService ;
    
    @Override
    public Area saveArea(Area area) {
        return areaService.saveArea(area);
    }

    @Override
    public void deleteArea(Area area) {
        areaService.deleteArea(area);
    }

    @Override
    public Area updateArea(Area area) {
        return areaService.updateArea(area);
    }

    @Override
    public List<Area> findAllArea() {
        return areaService.findAllArea();
    }
}
