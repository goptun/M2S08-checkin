package org.senai.m2s08.checkin.model.transport;

import jakarta.validation.constraints.NotNull;
import org.senai.m2s08.checkin.model.enums.TipoRegistro;

public record CriaRegistroPontoDTO(@NotNull TipoRegistro tipo) {
}