package br.com.ifba.vaga.service;



import br.com.ifba.vaga.model.Vaga;
import java.util.List;
import br.com.ifba.vaga.dao.IVagaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VagaService implements IVagaService {
    
    
    
 @Autowired
     private IVagaDAO vagaDAO;

    @Override
    public Vaga saveVaga(Vaga vaga) {
        return vagaDAO.save(vaga);
    }

    @Override
    public void deleteVaga(Vaga vaga) {
        vagaDAO.delete(vaga);
    }

    @Override
    public void updateVaga(Long id, Boolean ocupado) {
        try{
        vagaDAO.updateVaga(id, ocupado);
            System.out.println("deu certo"+id + ocupado);
        }catch (Exception e){
            System.out.println(e);
        
        }
    }

    @Override
    public List<Vaga> findAllVaga() {
        return vagaDAO.findAll();
    }

    @Override
    public void manipularEstadoVaga(Vaga vaga) {
        // Implemente aqui a lógica para manipular o estado da vaga
        // Isso pode incluir alterar o status da vaga, atribuir a vaga a um candidato, etc.
        // Certifique-se de implementar a lógica específica de acordo com seus requisitos.
    }
}
