package fr.istic.tpjpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Heater {
	
		private Long id;
		
		private Home home;
		private String date_fabrication;
		private double capacite;
		private String marque;
		
		public Heater(){
		
		}
		
		public Heater(double capacite,String date_fabrication,String marque){
		this.capacite=capacite;
		this.date_fabrication=date_fabrication;
		this.marque=marque;
		}
		@Id
		@GeneratedValue
		public Long getId() {
		return id;
		}
		public void setId(Long id) {
		this.id = id;
		}
		public String getDate_fabrication() {
			return date_fabrication;
		}
		public void setDate_fabrication(String date_fabrication) {
			this.date_fabrication = date_fabrication;
		}
		@OneToOne
		public Home getHome() {
		return home;
		}
		public void setHome(Home home) {
		this.home = home;
		}
		public double getCapacite() {
		return capacite;
		}
		public void setCapacite(double capacite) {
		this.capacite = capacite;
		}
		
		@Override
		public String toString(){
				return "Home[id="+id+",capacite="+capacite+",date fabrication"+date_fabrication+",marque"+marque+"]";
			}

}
