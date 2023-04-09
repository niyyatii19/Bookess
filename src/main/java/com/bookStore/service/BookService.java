package com.bookStore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.database.BookRepo;
import com.bookStore.entity.Books;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepo;
	
	public List<Books> getAllBooks(){
		List<Books> books = new ArrayList<>();
		bookRepo.findAll().forEach(books :: add);
		return books;
	}
}
