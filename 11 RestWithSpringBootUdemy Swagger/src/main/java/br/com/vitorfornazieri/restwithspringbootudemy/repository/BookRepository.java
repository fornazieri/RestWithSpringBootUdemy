package br.com.vitorfornazieri.restwithspringbootudemy.repository;

import br.com.vitorfornazieri.restwithspringbootudemy.data.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
