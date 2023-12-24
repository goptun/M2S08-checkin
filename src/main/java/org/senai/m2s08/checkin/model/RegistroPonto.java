package org.senai.m2s08.checkin.model;

import jakarta.persistence.*;
import org.senai.m2s08.checkin.model.enums.TipoRegistro;

import java.time.LocalDateTime;

@Entity
public class RegistroPonto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime registradoAs;

    @Enumerated(EnumType.STRING)
    private TipoRegistro tipo;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false, referencedColumnName = "id")
    private Funcionario funcionario;

    public RegistroPonto() {
    }

    public RegistroPonto(TipoRegistro tipo, Funcionario funcionario) {
        this.registradoAs = LocalDateTime.now();
        this.tipo = tipo;
        this.funcionario = funcionario;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getRegistradoAs() {
        return registradoAs;
    }

    public TipoRegistro getTipo() {
        return tipo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
}
