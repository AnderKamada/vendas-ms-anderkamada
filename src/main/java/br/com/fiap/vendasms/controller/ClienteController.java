package br.com.fiap.vendasms.controller;

import br.com.fiap.vendasms.service.ClienteService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


}
