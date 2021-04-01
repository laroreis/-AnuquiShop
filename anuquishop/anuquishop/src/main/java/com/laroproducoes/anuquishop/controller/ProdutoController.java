package com.laroproducoes.anuquishop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laroproducoes.anuquishop.model.Produto;
import com.laroproducoes.anuquishop.repository.ProdutoRepository;

@RestController
@CrossOrigin( origins = "*", allowedHeaders = "*")
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> GetById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{tituloProduto}")
	public ResponseEntity<List<Produto>> GetByTitulo (@PathVariable String tituloProduto){
		return ResponseEntity.ok(repository.findAllByTituloProdutoContainingIgnoreCase(tituloProduto));
	}
	
	@GetMapping("/valorMaior/{valor}")
	public ResponseEntity<List<Produto>> GetAllByValorMaior(@PathVariable double valor){
		return ResponseEntity.ok(repository.findAllByValorGreaterThanEqual(valor));
	}
	
	@GetMapping("/valorMenor/{valor}")
	public ResponseEntity<List<Produto>> GetAllByValorLess(@PathVariable double valor){
		return ResponseEntity.ok(repository.findAllByValorLessThanEqual(valor));
	}
	
	@GetMapping("/ativo/{ativo}")
	public ResponseEntity<List<Produto>> GetAllByAtivo(@PathVariable boolean ativo){
		return ResponseEntity.ok(repository.findAllByAtivo(ativo));
	}
	
	//@GetMapping("/valorEntre/{valor}")
	//public ResponseEntity<List<Produto>> GetAllByValorBetween(@PathVariable double valor){
		//return ResponseEntity.ok(repository.findByStartValorBetween(valor));
	//}
	
	@PostMapping
	public ResponseEntity<Produto> post (@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<Produto> put (@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}


}//fim
