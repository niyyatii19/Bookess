package com.bookStore.service;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.database.BookRepo;
import com.bookStore.database.UserRepo;
import com.bookStore.dto.LoginDto;
import com.bookStore.entity.Books;
import com.bookStore.entity.Users;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;
	@Autowired
	private BookRepo bookRepo;
	
	public Users validateUser(LoginDto loginDto) throws Exception {
		Users user = userRepo.findByEmail(loginDto.getEmail());
		if(user == null) {
			throw new EntityNotFoundException("User with "+ loginDto.getEmail()+ " not exisits! please register");
		}
		else if(!user.getPassword().equals(loginDto.getPassword())) {
			throw new Exception("Wrong credentials");
		}
		
		return user;
	}
	
	public String registerUser(Users user) {
		Users savedUser = userRepo.saveAndFlush(user);
		if(savedUser == null) {
			throw new EntityExistsException("User id already exists");
		}
		return "Inserted Successfully";
	}
	
	public Set<Books> getAllLikedBooks(int id){
		Set<Books> likedBooks = userRepo.findById(id).get().getLikedBooks();
		Set<Books> allLikedBooks = new HashSet<>();
		likedBooks.forEach(allLikedBooks :: add);
		return allLikedBooks;
	}
	
	public String addToLikedBooks(int userId, int bookId) {
		Users user  = userRepo.findById(userId).get();
		Books book = bookRepo.findById(bookId).get();
		user.add(book);
		userRepo.save(user);
		
		return "Added to Liked successfully";
		
	}
	
	
}
