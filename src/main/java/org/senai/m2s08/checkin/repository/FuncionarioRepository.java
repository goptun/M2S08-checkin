package org.senai.m2s08.checkin.repository;

import org.senai.m2s08.checkin.model.Funcionario;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepositoryImplementation<Funcionario, Long> {
}
