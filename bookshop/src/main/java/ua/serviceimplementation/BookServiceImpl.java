package ua.serviceimplementation;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import filter.BookFilter;
import form.BookForm;
import ua.entity.BookAutor;
import ua.repository.BookAutorRepository;
import ua.repository.BookRepository;
import ua.service.BookService;
import ua.service.FileWriter;
import ua.service.FileWriter.Folder;
import ua.specification.BookSpecification;
import ua.entity.Book;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookAutorRepository bookautorrepository;
	@Autowired
	private BookRepository bookrepository;
	@Autowired
	private FileWriter fileWriter;

	@Override
	@Transactional
	public BookForm findOne(int id) {
//			Book b= (Book)bookrepository.findOne(id); 
//			BookForm form = new BookForm(); 
//			// для цих зробити фетчі для пошуку
//			form.setBookadition(b.getBookadition()); 
////			form.setBookautors(b.getBookautors()); 
////			form.getBookautors().addAll(b.getBookautors()); 
//			form.setBookcover(b.getBookcover()); 
//			form.setBooklanguage(b.getBooklanguage()); 
//			form.setBookpromo(b.getBookpromo()); 
//			form.setBooktpc(b.getBooktpc()); 
//			// 
////			form.setBookname(b.getBookname());
//			form.setBookname(b.getBookname()); 
//			form.setBookPrice(String.valueOf(b.getBookPrice())); 
//			form.setBookPages(String.valueOf(b.getBookPages())); 
//			form.setBookYear(String.valueOf(b.getBookYear())); 
//			form.setId(b.getId()); 
//			return form; 
		Book b= (Book) bookrepository.findOne(id); 
		BookForm form = new BookForm(); 
		// 
		form.setBookadition(b.getBookadition()); 
		// form.setBookautors(b.getBookautors()); 
		form.getBookautors().addAll(b.getBookautors()); 
		form.setBookcover(b.getBookcover()); 
		form.setBooklanguage(b.getBooklanguage()); 
		form.setBookpromo(b.getBookpromo()); 
		form.setBooktpc(b.getBooktpc()); 
		// 
		form.setBookname(b.getBookname()); 
		form.setBookPrice(String.valueOf(b.getBookPrice())); 
		form.setBookPages(String.valueOf(b.getBookPages())); 
		form.setBookYear(String.valueOf(b.getBookYear())); 
		form.setId(b.getId()); 
		return form; 
			}
	
	@Override
	@Transactional
	public void save(BookForm form) {
//			List<BookAutor> collect = form.getBookautors().stream().map(BookAutor::getAutor).
//					map(e->Integer.parseInt(e)).map(e->bookautorrepository.findOne(e)).collect(Collectors.toList()); 
//			form.setBookautors(collect); 
			
//		Book b=new Book(); 
//		List <BookAutor> booka= new ArrayList<>();
//		for(BookAutor ba : form.getBookautors()){
//			booka.add(ba);
//		}
//		b.setBookautors(booka);
//			b.setBookautors(booka);
//		    b.setBookautors(collect);
//			b.setID(form.getId());
//			b.setBookadition(form.getBookadition()); 
////			b.getBookautors().addAll(form.getBookautors()); 
//			b.setBookcover(form.getBookcover()); 
//			b.setBooklanguage(form.getBooklanguage()); 
//			b.setBookpromo(form.getBookpromo()); 
//			b.setBooktpc(form.getBooktpc()); 
//			b.setBookname(form.getBookname()); 
//			b.setBookPrice(new BigDecimal(form.getBookPrice().replace(',','.'))); 
//			b.setBookPages(Integer.valueOf(form.getBookPages())); 
//			b.setBookYear(Integer.valueOf(form.getBookYear())); 
			
		 
				List<BookAutor> collect = form.getBookautors().stream().map(BookAutor::getAutor).map(e->Integer.parseInt(e)).map(e->bookautorrepository.findOne(e)).collect(Collectors.toList()); 
				form.setBookautors(collect); 
				Book b=new Book(); 
				b.setID(form.getId()); 
				b.setBookadition(form.getBookadition()); 
				b.getBookautors().addAll(form.getBookautors()); 
				b.setBookcover(form.getBookcover()); 
				b.setBooklanguage(form.getBooklanguage()); 
				b.setBookpromo(form.getBookpromo()); 
				b.setBooktpc(form.getBooktpc()); 
				b.setBookname(form.getBookname()); 
				b.setBookPrice(new BigDecimal(form.getBookPrice().replace(',','.'))); 
				b.setBookPages(Integer.valueOf(form.getBookPages())); 
				b.setBookYear(Integer.valueOf(form.getBookYear())); 
				
			
			if(fileWriter.write(Folder.ITEM, form.getFile(), b.getId())){
				if(b.getVersion()==null)b.setVersion(0);
				else b.setVersion(b.getVersion()+1);
			}
			System.out.println("kkk");
			bookrepository.save(b); 
		
	}

	@Override
	public List<Book> findAll() {
		return bookrepository.findAll();
	}

	@Override
	public void delete(int id) {
		bookrepository.delete(id);
		
	}

	@Override
	public Page<Book> findAll(BookFilter filter, Pageable pageable) {
		Page<Book> b = bookrepository.findAll(new BookSpecification(filter), pageable);
		return b;
	}
}
