package com.rjr.myfinances.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rjr.myfinances.model.entity.Registry;

public interface RegistryRepository extends JpaRepository<Registry, Long> {

}
