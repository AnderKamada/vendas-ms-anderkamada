package br.com.fiap.vendasms.controller;

import br.com.fiap.vendasms.dto.ProdutoDto;
import br.com.fiap.vendasms.exception.ProdutoNaoEncontradoException;
import br.com.fiap.vendasms.service.ProdutoService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        List<ProdutoDto> produtos = ProdutoDto.from(service.listarTodos());
        model.addAttribute("produtos", produtos);
        return "produtos/list";
    }

    @GetMapping("/{id}")
    public String detalhe(@PathVariable String id, Model model) {
        ProdutoDto dto;

        try {
            dto = ProdutoDto.from(service.buscarPorId(id));
        } catch (NoSuchElementException e) {
            dto = ProdutoDto.empty(id);
        }

        model.addAttribute("produto", dto);
        return "produtos/form";
    }

    @PostMapping
    public String salvar(ProdutoDto dto) {
        service.salvar(dto.toEntity());
        return "redirect:/produtos";
    }

    @PostMapping("/{id}/delete")
    public String excluir(@PathVariable String id) {
        service.excluir(id);
        return "redirect:/produtos";
    }

    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public String handleProdutoNaoEncontrado(ProdutoNaoEncontradoException e, Model model) {
        model.addAttribute("erro", e.getMessage());
        return "erro";
    }
}