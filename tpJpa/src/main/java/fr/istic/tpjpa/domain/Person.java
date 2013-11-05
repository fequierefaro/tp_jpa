package fr.istic.tpjpa.domain;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
	private Long id;
	private String name;
	private String firstname;
	private String genre;
	private String mail;
	private List<Home> homes = new ArrayList<Home>();
	private double datenaissance;
	private String profile_facebook;
	private List<ElectronicDevice> electronics = new ArrayList<ElectronicDevice>();
	private List<Friend> friends=new ArrayList<Friend>();
	

	public Person() {

	}

	public Person(String name, String firstname, String genre, String mail,
			double datenaissance, String profile_facebook) {
		this.name = name;
		this.firstname = firstname;
		this.genre = genre;
		this.mail = mail;
		this.datenaissance = datenaissance;
		this.profile_facebook = profile_facebook;
		//this.homes=(List<Home>) homes;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getProfile_facebook() {
		return profile_facebook;
	}

	public void setProfile_facebook(String profile_facebook) {
		this.profile_facebook = profile_facebook;
	} 

	@OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
	public List<Home> getHomes() {
		return homes;
	}

	public void setHomes( List<Home> homes) {
		this.homes = homes;
	}
	
	@OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
	public List<ElectronicDevice> getElectronics() {
		return electronics;
	}

	public void setElectronics( List<ElectronicDevice> electronics) {
		this.electronics=electronics;
	}
	
	public double getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(double datenaissance) {
		this.datenaissance = datenaissance;
	}
	@OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
	public List<Friend> getFriends() {
		return friends;
	}

	public void setFriends(List<Friend> friends) {
		this.friends = friends;
	}

	@Override
	public String toString() {
		return "Person[id=" + id + ",name=" + name + ",firstname=" + firstname
				+ ",genre=" + genre + ",date naissane=" + datenaissance
				+ ",mail=" + mail + ",profil facebook=" + profile_facebook
				+ "]";
	}

}
