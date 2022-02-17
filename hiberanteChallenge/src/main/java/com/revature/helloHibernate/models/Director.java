package com.revature.helloHibernate.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


// TODO: Let's add our Hibernate Annotations here
@Entity
@Table(name="directors")
public class Director {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="director_id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="year_born")
	private int yearBorn;
	
	@Column(unique = true, nullable = false)
	private String email;
	

//	@JsonManagedReference
//	@ManyToMany(fetch=FetchType.EAGER,
//			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
//					 CascadeType.DETACH, CascadeType.REFRESH})
//	@JoinTable(
//		name="directors_movies",
//		joinColumns = @JoinColumn(name="director_id"),
//		inverseJoinColumns = @JoinColumn(name="movie_id")
//	)
	@JsonManagedReference
	@OneToMany(mappedBy="director", fetch=FetchType.EAGER)
	private List<Movie> movies;
	
//	@JsonManagedReference
//	@OneToMany(mappedBy="director", fetch=FetchType.EAGER)
//	private List<Movie> movies;
	
	
	
	//Boilerplate
	public Director(int id, String firstName, String lastName, int yearBorn) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearBorn = yearBorn;
	}
	public Director(String firstName, String lastName, int yearBorn) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearBorn = yearBorn;
	}
	public Director() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getYearBorn() {
		return yearBorn;
	}
	public void setYearBorn(int yearBorn) {
		this.yearBorn = yearBorn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	@Override
	public String toString() {
		return "Director [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", yearBorn=" + yearBorn
				+ ", email=" + email + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, movies, yearBorn);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Director other = (Director) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName) && Objects.equals(movies, other.movies)
				&& yearBorn == other.yearBorn;
	}
	
	
}
