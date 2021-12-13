package br.com.carlosjunior.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.carlosjunior.hrworker.entities.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
