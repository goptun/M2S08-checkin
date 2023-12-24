package org.senai.m2s08.checkin.model.transport;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.senai.m2s08.checkin.model.RegistroPonto;
import org.senai.m2s08.checkin.model.enums.TipoRegistro;

import java.time.LocalDateTime;


public record RegistroPontoDTO(Long id, @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime registradoAs,
                               TipoRegistro tipo) {

    public RegistroPontoDTO(RegistroPonto registroPonto) {
        this(registroPonto.getId(), registroPonto.getRegistradoAs(), registroPonto.getTipo());
    }
}