package com.laroproducoes.anuquishop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.laroproducoes.anuquishop.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	public List<Produto> findAllByTituloProdutoContainingIgnoreCase( String tituloProduto);
	
	public List<Produto> findAllByValorLessThanEqual (double valor);
	
	public List<Produto> findAllByValorGreaterThanEqual (double valor);
	
	@Query(value = "select * from tb_produto where ativo = :ativo", nativeQuery = true)
	public List<Produto> findAllByAtivo(@Param("ativo") boolean ativo);	
	
	//@Query(value = "select * from tb_produto where valor = :BETWEEN 3 and 60", nativeQuery = true )
	//public List<Produto> findByStartValorBetween(@Param("3, 60") double valor);
	
	//@Query(value = "select * from tb_produto inner join tb_marca on  tb_marca.id = tb_produto.marca_id where tb_marca.descricao = :marca", nativeQuery = true)
	//public List<Produto> findAllProdutoByCategoriaDecicao(@Param("marca") String marca);

}//fim
