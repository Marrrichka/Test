package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import filter.BookFilter;
import form.BookForm;
import ua.entity.Book;

public interface BookService {
	BookForm findOne(int id);
	List<Book>findAll();
	void save(BookForm form);
	void delete(int id);
	Page <Book>findAll(BookFilter filter, Pageable pageable);
}
