package com.mitocode.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.model.Signos;

@Repository
public interface ISignoRepo extends JpaRepository<Signos, Integer> {

}
