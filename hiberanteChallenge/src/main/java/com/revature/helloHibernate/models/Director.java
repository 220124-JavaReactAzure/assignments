 package com.revature.helloHibernate.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity //@Entity makes a Class a DB table
@Table(name = "directors") //@Table lets us change some table values
@JsonIdentityInfo( // This helps witht he serialization to stop recursion with hibernate joins
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Director {

	@Id //This will make the field a primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //this makes our PK serial
	@Column(name = "director_id") //usually I'll just call a field what I want it to be called instead of doing this...
	private int id;
	
	//I could give these all fields @Column annotations, but Hibernate will handle them on its own 
	//The only time I would NEED @Column is if I'm changing attributes like constraints
	@Column(name ="first_name", unique = true, nullable = false)
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="year_born")
	private int yearBorn;

	//what's mappedBy? It's the field in the Movie Class that references the Director class
	//This is how we can achieve ManyToMany functionality without using the ManyToMany annotation, which has more steps
	
	@OneToMany(mappedBy="director", fetch=FetchType.EAGER)
	@JsonIgnoreProperties(value="director")
	private List<Movie> filmography;

	//boilerplate code below.....................
	
	//Classes come with a no args constructor by default
	//BUT if you add a single constructor, that default constructor goes away
	//So we would need to add a no args (just in case)
	public Director() {
		super(); 
		// TODO Auto-generated constructor stub
	}

	

	public Director(String firstName, String lastName, int yearBorn, List<Movie> filmography) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearBorn = yearBorn;
		this.filmography = filmography;
	}



	public Director(int id, String firstName, String lastName, int yearBorn, List<Movie> filmography) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearBorn = yearBorn;
		this.filmography = filmography;
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

	public List<Movie> getFilmography() {
		return filmography;
	}

	public void setFilmography(List<Movie> filmography) {
		this.filmography = filmography;
	}

	public String toMovieString() {
		return "Director [id=" + id + ", first_name=" + firstName + ", last_name=" + lastName + ", year_born="
				+ yearBorn + "]";
	}
	
	@Override
	public String toString() {
		return "Director [id=" + id + ", first_name=" + firstName + ", last_name=" + lastName + ", year_born="
				+ yearBorn + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filmography == null) ? 0 : filmography.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + yearBorn;
		return result;
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
		if (filmography == null) {
			if (other.filmography != null)
				return false;
		} else if (!filmography.equals(other.filmography))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (yearBorn != other.yearBorn)
			return false;
		return true;
	}

	
	
}
