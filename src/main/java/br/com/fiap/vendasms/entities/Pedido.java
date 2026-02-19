package br.com.fiap.vendasms.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String descricao;


    public enum Status {
        PENDENTE_ENVIO,
        ENVIO_EM_PROCESSAMENTO,
        FINALIZADO
    }
}
