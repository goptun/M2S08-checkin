package org.senai.m2s08.checkin.repository;

import org.senai.m2s08.checkin.model.RegistroPonto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontoRegistroRepository extends JpaRepository<RegistroPonto, Long> {
}
