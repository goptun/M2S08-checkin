package org.senai.m2s08.checkin.controller;

import jakarta.validation.Valid;
import org.senai.m2s08.checkin.model.transport.CriarFuncionarioDTO;
import org.senai.m2s08.checkin.model.transport.DetalharFuncionarioDTO;
import org.senai.m2s08.checkin.model.transport.GeralFuncionarioDTO;
import org.senai.m2s08.checkin.model.transport.RegistroPontoDTO;
import org.senai.m2s08.checkin.service.FuncionarioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public ResponseEntity<Page<GeralFuncionarioDTO>> list(@PageableDefault(size = 12, sort = "nome") Pageable pageable) {
        Page<GeralFuncionarioDTO> resposta = this.funcionarioService.listarTodos(pageable);
        return ResponseEntity.ok(resposta);
    }


    @GetMapping("/{id}")
    public ResponseEntity<DetalharFuncionarioDTO> getById(@PathVariable("id") Long id) {
        DetalharFuncionarioDTO response = this.funcionarioService.getFuncionario(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<GeralFuncionarioDTO> criar(@RequestBody @Valid CriarFuncionarioDTO body) {
        GeralFuncionarioDTO resposta = this.funcionarioService.criar(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @PostMapping("/{id}/registros-ponto")
    public ResponseEntity<RegistroPontoDTO> criarRegistroPonto(@PathVariable("id") Long id,
                                                              @RequestBody @Valid CriarFuncionarioDTO body) {
        RegistroPontoDTO resposta = this.funcionarioService.criarRegistroPonto(id, body);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }
}
