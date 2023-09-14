package br.com.ifba.infrastructure.facade;

import br.com.ifba.cliente.model.Cliente;
import br.com.ifba.vaga.model.Vaga;
import br.com.ifba.area.model.Area;
import java.util.List;

public interface IFacade {
    // Cliente
    Cliente saveCliente(Cliente cliente);
    void deleteCliente(Cliente cliente);
    Cliente updateCliente(Cliente cliente);
    List<Cliente> findAllCliente();
    Cliente checkLoginCliente(String username, String password);
    Cliente findByUsernameCliente(String username);
    void updatePassword(Long id, String password);

    // Vaga
    void saveVaga(Vaga vaga);
    void deleteVaga(Vaga vaga);
    Vaga updateVaga(Vaga vaga);
    void manipularEstadoVaga(Vaga vaga);
    List<Vaga> findAllVaga();

    // Área
    Area saveArea(Area area);
    void deleteArea(Area area);
    Area updateArea(Area area);
    List<Area> findAllArea();


}
