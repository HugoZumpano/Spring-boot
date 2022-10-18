package com.hugo.myapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hugo.myapi.domain.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer>{

}
