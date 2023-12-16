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

    public RegistroPonto(Long id, LocalDateTime registradoAs, TipoRegistro tipo, Funcionario funcionario) {
        this.id = id;
        this.registradoAs = registradoAs;
        this.tipo = tipo;
        this.funcionario = funcionario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getRegistradoAs() {
        return registradoAs;
    }

    public void setRegistradoAs(LocalDateTime registradoAs) {
        this.registradoAs = registradoAs;
    }

    public TipoRegistro getTipo() {
        return tipo;
    }

    public void setTipo(TipoRegistro tipo) {
        this.tipo = tipo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
