package com.library.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.exception.BookNotFoundException;
import com.library.model.Book;
import com.library.model.Library;
import com.library.service.LibraryService;

@RestController
@RequestMapping("/library")
@CrossOrigin
public class LibraryController {

	@Autowired
	private LibraryService libraryService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Library> getLibraries() {
		System.out.println("Inside getLibraries() method of LibraryController class");
		List<Library> libraries = libraryService.getLibraries();
		return libraries;
	}
	
	@RequestMapping(value="/{libraryid}", method = RequestMethod.GET)
	public Library getLibrary(@PathVariable String libraryid) {
		System.out.println("Inside getLibrary() method of LibraryController class");
		Library library = libraryService.getLibrary(Long.parseLong(libraryid));
		return library;
	}
	
	@RequestMapping(value="/book", method = RequestMethod.GET)
	public List<Book> getAllBooks() {
		System.out.println("Inside getBooks() method of LibraryController class");
		List<Book> books = libraryService.getAllBooks();
		return books;
	}
	
	@RequestMapping(value="/{libraryid}/book", method = RequestMethod.GET)
	public List<Book> getBooksByLibrary(@PathVariable String libraryid) {
		System.out.println("Inside getBooks() method of LibraryController class");
		Library library = libraryService.getLibrary(Long.parseLong(libraryid));
		List<Book> books = new ArrayList<Book>(library.getBooks());
		return books;
	}
	
	@RequestMapping(value="/book/{bookid}", method = RequestMethod.GET)
	public Book getBook(@PathVariable Long bookid) {
		System.out.println("Inside getBook() method of LibraryController class");
		Book book = libraryService.getBook(bookid);
		if(book == null) {
			throw new BookNotFoundException(bookid);
		}
		return book;
	}
	
	@RequestMapping(value="/book", method = RequestMethod.POST)
	public Book saveBook(@RequestBody Book book) {
		System.out.println("Inside saveBook() method of LibraryController class");
		Book sBook = libraryService.saveBook(book);
		return sBook;
	}
	
	@RequestMapping(value="/book", method = RequestMethod.PUT)
	public String updateBook(@RequestBody Book book) {
		System.out.println("Inside updateBook() method of LibraryController class");
		libraryService.updateBook(book);
		return "Success";
	}
}
