package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.BookAutor;
import ua.entity.BookPromo;

public interface BookAutorRepository extends JpaRepository<BookAutor, Integer>, JpaSpecificationExecutor<BookAutor>{
	BookAutor findByAutor(String name);
//	@Query("SELECT DISTINCT b FROM Book b LEFT JOIN FETCH b.bookautors WHERE c.id = :id")
//	BookAutor findOne(@Param("id") int id);
	List<BookAutor> findAll();
}
