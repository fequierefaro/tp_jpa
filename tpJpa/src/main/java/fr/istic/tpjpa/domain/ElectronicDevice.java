package fr.istic.tpjpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class ElectronicDevice {
	
	private Long id;
	
	private String name;
	private String capacite;
	private String date_fabrication;
	private Person person;
	
	public ElectronicDevice(){
		
	}
	public ElectronicDevice(String name,String capacite,String date_fabrication){
		
		this.name=name;
		this.capacite=capacite;
		this.date_fabrication=date_fabrication;
	}
		public String getDate_fabrication() {
		return date_fabrication;
	}
	public void setDate_fabrication(String date_fabrication) {
		this.date_fabrication = date_fabrication;
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
		public String getCapacite() {
		return capacite;
	}
		public void setCapacite(String capacite) {
		this.capacite = capacite;
	}
		@ManyToOne
		public Person getPerson() {
			return person;
		}
		public void setPerson(Person person) {
			this.person = person;
		}
		
		@Override
		public String toString(){
			return "Home[id="+id+",name="+name+",capacite="+capacite+",date fabrication="+date_fabrication+"]";
		}
		
	

}
