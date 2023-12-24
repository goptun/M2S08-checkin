package org.senai.m2s08.checkin.model.transport;


import org.senai.m2s08.checkin.model.Funcionario;

import java.math.BigDecimal;
import java.util.List;

public record DetalharFuncionarioDTO(Long id, String nome, String cargo, BigDecimal salario,
                                     List<RegistroPontoDTO> registros) {

    public DetalharFuncionarioDTO(Funcionario funcionario) {
        this(funcionario.getId(), funcionario.getNome(), funcionario.getCargo(), funcionario.getSalario(),
                funcionario.getRegistoPontoComoObjeto());
    }
}
