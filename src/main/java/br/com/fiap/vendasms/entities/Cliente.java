package br.com.fiap.vendasms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cliente {

    @Id
    private String cpf;

    private String nome, cep, numero, completo, telefone;

    public Cliente() {
        super();
    }

    public Cliente(String cpf, String nome, String cep, String numero, String completo, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.cep = cep;
        this.numero = numero;
        this.completo = completo;
        this.telefone = telefone;
    }

}
