package com.bookStore.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
@ToString(exclude = { "likes", "later" })
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String url;
	private String description;

	@ManyToMany(mappedBy = "likedBooks")
	List<Users> likes;

	public void add(Users user) {
		if (user != null) {
			if (likes == null) {
				likes = new ArrayList<>();
			}
			if (!likes.contains(user))
				likes.add(user);
		}
	}

	@ManyToMany(mappedBy = "readLater")
	List<Users> later;

	public void addBooks(Users user) {
		if (user != null) {
			if (later == null) {
				later = new ArrayList<>();
			}
			if (!later.contains(user))
				later.add(user);
		}
	}

}
