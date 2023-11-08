package com.gerenciamentodelivros.Livros.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciamentodelivros.Livros.Entities.Livro;
import com.gerenciamentodelivros.Livros.Repositories.LivroRepository;


   @Service
	public class LivroService {
	   
		private final LivroRepository livroRepository;

		@Autowired
		public LivroService(LivroRepository livroRepository) {
			this.livroRepository = livroRepository;
		}
		
		public Livro getLivroById(Long id) {
			return livroRepository.findById(id).orElse(null);
		}
		
		public List<Livro> getAllLivros() {
			return livroRepository.findAll();
		}

		public Livro saveLivro(Livro livro) {
			return livroRepository.save(livro);
		}
		
		public void deleteLivro(Long id) {
			livroRepository.deleteById(id);
		}
		public Livro updateLivro(Long id, Livro novoLivro) {
	        Optional<Livro> livroOptional = livroRepository.findById(id);
	        if (livroOptional.isPresent()) {
	        	Livro livroExistente = livroOptional.get();
	           	livroExistente.setDescricao(novoLivro.getDescricao());
	        	livroExistente.setIsbn(novoLivro.getIsbn());          
	            return livroRepository.save(livroExistente); 
	        } else {
	            return null; 
	        }
	    
		}

	}
