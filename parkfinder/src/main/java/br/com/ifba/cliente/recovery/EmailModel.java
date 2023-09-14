/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.cliente.recovery;

import org.springframework.stereotype.Component;

/**
 *
 * @author j_ped
 */
@Component
public class EmailModel {
    
    private String destino;
    private String assunto;
    private String conteudo;

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    public EmailModel(){
    
    }
    
    public EmailModel(String destino, String assunto, String conteudo) {
        this.destino = destino;
        this.assunto = assunto;
        this.conteudo = conteudo;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    
}
