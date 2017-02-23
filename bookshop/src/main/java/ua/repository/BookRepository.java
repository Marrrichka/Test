package ua.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book>{

	@Query("SELECT b FROM Book b LEFT JOIN FETCH b.bookadition LEFT JOIN FETCH b.bookautors  "
			+ "LEFT JOIN FETCH b.bookcover  LEFT JOIN FETCH b.booklanguage  LEFT JOIN FETCH b.bookpromo  "
			+ "LEFT JOIN FETCH b.booktpc")
	List<Book>findAll();
	
	@Query("SELECT b FROM Book b LEFT JOIN FETCH b.bookadition LEFT JOIN FETCH b.bookautors  "
			+ "LEFT JOIN FETCH b.bookcover  LEFT JOIN FETCH b.booklanguage  LEFT JOIN FETCH b.bookpromo  "
			+ "LEFT JOIN FETCH b.booktpc WHERE b.id=:id")
	Book findOne(@Param("id") int id);
//	@Query(value="SELECT b FROM Book b LEFT JOIN FETCH b.bookadition LEFT JOIN FETCH b.bookautors  "
//			+ "LEFT JOIN FETCH b.bookcover  LEFT JOIN FETCH b.booklanguage  LEFT JOIN FETCH b.bookpromo  "
//			+ "LEFT JOIN FETCH b.booktpc", countQuery="SELECT count(b.id) FROM Book b")
	Page<Book> findAll(Pageable pageable);
	
	Book findByBookname(String name);
	
}
