package com.hps.vilanova.repository;

import com.hps.vilanova.model.Usuario;
import com.hps.vilanova.model.enums.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    List<Usuario> findByRolesNot(Roles roles);
}
