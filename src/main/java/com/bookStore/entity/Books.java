package com.bookStore.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = {"likes"})
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String url;
	private String description;
	
	@ManyToMany(mappedBy = "likedBooks")
	Set<Users> likes;
	
	public void add(Users user) {
		if(user != null) {
			if(likes == null) {
				likes = new HashSet<>();
			}
			if(!likes.contains(user)) likes.add(user);
		}
	}
	
	
}
