package org.senai.m2s08.checkin.model.transport;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.senai.m2s08.checkin.model.enums.TipoRegistro;

import java.math.BigDecimal;

public record CriarFuncionarioDTO(@NotBlank String nome, @NotBlank String cargo, @NotNull BigDecimal salario,
                                  TipoRegistro tipo) {
}

