package org.senai.m2s08.checkin.service;

import jakarta.transaction.Transactional;
import org.senai.m2s08.checkin.model.Funcionario;
import org.senai.m2s08.checkin.model.RegistroPonto;
import org.senai.m2s08.checkin.model.transport.*;
import org.senai.m2s08.checkin.repository.FuncionarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class FuncionarioService {


    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Transactional
    public GeralFuncionarioDTO criar(CriarFuncionarioDTO body) {
        Funcionario newFuncionario = this.funcionarioRepository.save(new Funcionario(body));
        return new GeralFuncionarioDTO(newFuncionario);
    }

    @Transactional
    public RegistroPontoDTO criarRegistroPonto(Long id, CriarFuncionarioDTO body) {
        Funcionario funcionario = this.funcionarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado com o id: " + id));

        RegistroPonto registroPonto = new RegistroPonto(body.tipo(), funcionario);
        funcionario.getRegistroPontos().add(registroPonto);

        return new RegistroPontoDTO(registroPonto);
    }

    public Page<GeralFuncionarioDTO> listarTodos(Pageable pageable) {
        return this.funcionarioRepository.findAll(pageable).map(GeralFuncionarioDTO::new);
    }

    public DetalharFuncionarioDTO getFuncionario(Long id) {
        return this.funcionarioRepository.findById(id).map(DetalharFuncionarioDTO::new)
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado com o id: " + id));
    }
}
