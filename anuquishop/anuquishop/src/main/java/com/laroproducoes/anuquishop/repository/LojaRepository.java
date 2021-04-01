package com.laroproducoes.anuquishop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.laroproducoes.anuquishop.model.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long> {
	public List<Loja> findAllByDescricaoContainingIgnoreCase (String descricao);
}
