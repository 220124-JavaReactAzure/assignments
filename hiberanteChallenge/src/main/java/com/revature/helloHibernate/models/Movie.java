package com.revature.helloHibernate.models;

import java.util.Objects;

//TODO: Impelement me with Hibernate
public class Movie { 
	private int id;
	private String title;
	private String genre;
	public Director director;
	
	
	// Boilerplate
	public Movie(int id, String title, String genre, Director director) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.director = director;
	}
	public Movie(String title, String genre, Director director) {
		super();
		this.title = title;
		this.genre = genre;
		this.director = director;
	}
	public Movie() {
		super();
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", genre=" + genre + ", director=" + director + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(director, genre, id, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(director, other.director) && Objects.equals(genre, other.genre) && id == other.id
				&& Objects.equals(title, other.title);
	}
	
}
