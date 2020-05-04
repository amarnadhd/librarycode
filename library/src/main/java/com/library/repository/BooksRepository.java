package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.library.model.Book;

@Repository
@Transactional(readOnly = true)
public interface BooksRepository extends JpaRepository<Book, Long>{
	
	@Modifying
	@Query("update Book b set b.name = ?1, b.author = ?2 where b.id = ?3")
	public void updateBook(String name, String author, Long bookid);
}
