package com.gerenciamentodelivros.Livros.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciamentodelivros.Livros.Entities.Livro;
import com.gerenciamentodelivros.Livros.Service.LivroService;

public class Controller {



	@RestController
	@RequestMapping("/livros")
	public class JogoController {

		@GetMapping("/home")
		public String paginaInicial() {
			return "index";
		}

		private final livroService livroService;

		@Autowired
		public LivroController(LivroService livroService) {
			this.livroService = livroService;
		}

		@PostMapping
		public Livro createLivvro(@RequestBody Livro livro) {
			return LivroService.saveLivro(livro);
		}

		@DeleteMapping("/{id}")
		public void deleteJogo(@PathVariable Long id) {
			LivroService.deleteLivro(id);
		}
		
		@GetMapping("/{id}")	
	    public ResponseEntity<Livro> getLivro(@PathVariable Long id) {
	        Livro livro = LivroService.getLivroById(id);
	        if (livro != null) {
	            return ResponseEntity.ok(livro);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

		@GetMapping
		public ResponseEntity<List<LIvro>> getAllLivro(RequestEntity<Void> requestEntity) {
			String method = requestEntity.getMethod().descricao();
			String contentType = requestEntity.getHeaders().getContentType().toString();
			List<Livro> livro = LivroService.getAllLivro();
			return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
					.body(livro);
		}

		@PutMapping("/{id}")
		public Livro updateLivro(@PathVariable Long id, @RequestBody Livro livro) {
			return LivroService.updateLivro(id, livro);
		}
}

