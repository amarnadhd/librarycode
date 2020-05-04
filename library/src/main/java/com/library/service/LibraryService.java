package com.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.model.Book;
import com.library.model.Library;
import com.library.repository.BooksRepository;
import com.library.repository.LibraryRepository;

@Service
public class LibraryService {

	@Autowired
	private LibraryRepository libraryRepository;
	
	@Autowired
	private BooksRepository booksRepository;
	
	public List<Library> getLibraries() {
		System.out.println("Inside getLibraries() method of LibraryService class");
		List<Library> libraries = libraryRepository.findAll();
		return libraries;
	}
	
	public Library getLibrary(Long labraryid) {
		System.out.println("Inside getLibrary() method of LibraryService class");
		Optional<Library> library = libraryRepository.findById(labraryid);
		return library.get();
	}
	
	public List<Book> getAllBooks() {
		System.out.println("Inside getAllBooks() method of LibraryService class");
		List<Book> books = booksRepository.findAll();
		return books;
	}
	
	public Book getBook(Long bookid) {
		System.out.println("Inside getBook() method of LibraryService class");
		Book book = null;
		Optional<Book> bookOptional = booksRepository.findById(bookid);
		if(bookOptional.isPresent())
			book = bookOptional.get();
		return book;
	}
	
	public Book saveBook(Book book) {
		System.out.println("Inside saveBook() method of LibraryService class");
		Book sBook = booksRepository.save(book);
		return sBook;
	}
	
	public void updateBook(Book book) {
		System.out.println("Inside updateBook() method of LibraryService class");
		booksRepository.updateBook(book.getName(), book.getAuthor(), book.getBookId());
	}
}
