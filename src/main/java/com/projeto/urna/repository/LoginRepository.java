package com.projeto.urna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.urna.model.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {
	List<Login> findByUsuario(String usuario);
}
