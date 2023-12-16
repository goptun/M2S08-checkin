package org.senai.m2s08.checkin.model;

import jakarta.persistence.*;

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

    public Funcionario(Long id, String nome, String cargo, BigDecimal salario, List<RegistroPonto> registroPontos) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.registroPontos = registroPontos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public List<RegistroPonto> getRegistroPontos() {
        return registroPontos;
    }

    public void setRegistroPontos(List<RegistroPonto> registroPontos) {
        this.registroPontos = registroPontos;
    }
}
