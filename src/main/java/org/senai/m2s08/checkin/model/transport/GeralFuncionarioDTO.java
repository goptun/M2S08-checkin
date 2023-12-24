package org.senai.m2s08.checkin.model.transport;


import org.senai.m2s08.checkin.model.Funcionario;

import java.math.BigDecimal;

public record GeralFuncionarioDTO(Long id, String nome, String cargo, BigDecimal salario) {

    public GeralFuncionarioDTO(Funcionario funcionario) {
        this(funcionario.getId(), funcionario.getNome(), funcionario.getCargo(), funcionario.getSalario());
    }
}