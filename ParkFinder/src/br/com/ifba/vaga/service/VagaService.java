package br.com.ifba.vaga.service;

import br.com.ifba.vaga.dao.VagaDAO;
import br.com.ifba.vaga.model.Vaga;
import java.util.List;
import br.com.ifba.vaga.dao.IVagaDAO;

public class VagaService implements IVagaService {
    
    private final IVagaDAO vagaDAO = new VagaDAO();

    @Override
    public Vaga saveVaga(Vaga vaga) {
        return vagaDAO.save(vaga);
    }

    @Override
    public void deleteVaga(Vaga vaga) {
        vagaDAO.delete(vaga);
    }

    @Override
    public Vaga updateVaga(Vaga vaga) {
        return vagaDAO.update(vaga);
    }

    @Override
    public List<Vaga> findAllVagas() {
        return vagaDAO.findAll();
    }

    @Override
    public void manipularEstadoVaga(Vaga vaga) {
        // Implemente aqui a lógica para manipular o estado da vaga
        // Isso pode incluir alterar o status da vaga, atribuir a vaga a um candidato, etc.
        // Certifique-se de implementar a lógica específica de acordo com seus requisitos.
    }
}
