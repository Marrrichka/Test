package ua.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import filter.BasicFilter;
import ua.entity.BookCover;

public class BookCoverSpecification implements Specification<BookCover> {
	private final BasicFilter filter;
	

	public BookCoverSpecification(BasicFilter filter) {
		super();
		this.filter = filter;
	}


	@Override
	public Predicate toPredicate(Root<BookCover> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(filter.getSearch().isEmpty()) return null;
		return cb.like(root.get("cover"), filter.getSearch()+"%");
				
	}

	

}
