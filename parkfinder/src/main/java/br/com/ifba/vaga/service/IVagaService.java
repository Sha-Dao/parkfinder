/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.vaga.service;
import br.com.ifba.vaga.model.Vaga;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author santo
 */

public interface IVagaService {
    
    public Vaga saveVaga(Vaga vaga);
    public void deleteVaga(Vaga vaga);
    public Vaga updateVaga(Vaga vaga);
    public List<Vaga> findAllVaga();
    public void manipularEstadoVaga(Vaga vaga);

    
}
