package com.gerenciamentodelivros.Livros.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamentodelivros.Livros.Entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}

