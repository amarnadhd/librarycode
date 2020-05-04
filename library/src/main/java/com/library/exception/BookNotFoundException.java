package com.library.exception;

public class BookNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -7303971781855981060L;

	public BookNotFoundException(Long id) {

        super(String.format("Book with Id %d not found", id));
    }
}
