package ua.repository;

import java.util.List;

import javax.inject.Qualifier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.Book;
import ua.entity.BookTopicPidCat;

public interface BookTPCRepository extends JpaRepository<BookTopicPidCat, Integer>, JpaSpecificationExecutor<BookTopicPidCat> {

//	@Query("SELECT DISTINCT b FROM Book b LEFT JOIN FETCH b.booktpc WHERE b.id=:id")
//	@Query("SELECT DISTINCT r FROM BookTopicPidCat r JOIN FETCH r.books a LEFT JOIN FETCH a.booktpc WHERE r.id=?1")
	
	
//	@Query("SELECT b FROM Book b  JOIN  b.booktpc c WHERE c.id=:id")
//	BookTopicPidCat findOne(@Param("id") int id);
//
//	@Query("SELECT b FROM Book b  LEFT JOIN FETCH b.booktpc")
//			List<BookTopicPidCat> findAll();
	BookTopicPidCat findByBooktpc(String name);

	@Query("SELECT a FROM BookTopicPidCat a LEFT JOIN FETCH a.topic")
	List<BookTopicPidCat> findAll();
	
	@Query("SELECT a FROM BookTopicPidCat a LEFT JOIN FETCH a.topic WHERE a.id = ?1")
	BookTopicPidCat findOne(Integer id);
}
	

