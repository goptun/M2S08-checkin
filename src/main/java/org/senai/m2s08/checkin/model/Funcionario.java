package org.senai.m2s08.checkin.model;

import jakarta.persistence.*;
import org.senai.m2s08.checkin.model.transport.CriarFuncionarioDTO;
import org.senai.m2s08.checkin.model.transport.RegistroPontoDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cargo;

    @Column(nullable = false)
    private BigDecimal salario;

    @OneToMany(mappedBy = "funcionario", orphanRemoval = true, cascade = {CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH})
    private List<RegistroPonto> registroPontos = new ArrayList<>();

    public Funcionario() {
    }

    public Funcionario(CriarFuncionarioDTO body) {
        this.nome = body.nome();
        this.cargo = body.cargo();
        this.salario = body.salario();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public List<RegistroPonto> getRegistroPontos() {
        return registroPontos;
    }

    public List<RegistroPontoDTO> getRegistoPontoComoObjeto() {
        return this.registroPontos.stream().map(RegistroPontoDTO::new).toList();
    }
}
