package fr.istic.tpjpa.jpa;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import fr.istic.tpjpa.domain.ElectronicDevice;
import fr.istic.tpjpa.domain.Friend;
import fr.istic.tpjpa.domain.Heater;
import fr.istic.tpjpa.domain.Home;
import fr.istic.tpjpa.domain.Person;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		//JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		CriteriaBuilder cb=factory.getCriteriaBuilder();
		
		CriteriaQuery<Person> p=cb.createQuery(Person.class);
		Root<Person> person=p.from(Person.class);
		p.select(person);
		
		CriteriaQuery<Home> h=cb.createQuery(Home.class);
		Root<Home> home=h.from(Home.class);
		h.select(home);
		
		CriteriaQuery<ElectronicDevice> e=cb.createQuery(ElectronicDevice.class);
		Root<ElectronicDevice> elec=e.from(ElectronicDevice.class);
		e.select(elec);
		
		
		
		// TODO create entity

		Person p1 = new Person("thiam", "cheikh", "M", "cheikh@gmail.com", 0603,"elkheucha");
		Person p2 = new Person("diop", "modou", "M", "modou@gmail.com", 0305,"modou");
		Person p3 = new Person("sow", "fatou", "S", "fatou@gmail.com", 0407,"fatou");
		Person p4 = new Person("thiam", "sokhna", "S", "sokhna@gmail.com", 2511,"sokhna");

		Home h1 = new Home("rennes",1200, "192.12.6.1");
		Home h2 = new Home("redon", 1700, "198.200.85.6");
		Home h3 = new Home("lemans", 1900, "128.69.4.5");
		Home h4 = new Home("limoges", 2100,"128.69.65.5");
		Home h5 = new Home("lyon", 3900,"136.69.4.5");
		Home h6 = new Home("brest", 1400,"128.69.4.58");
		Home h7 = new Home("paris", 4900,"128.69.88.77");
		//Home h8 = new Home("nice", 1900,"111.65.4.5");
		//Home h9 = new Home("creteil", 1220,"128.69.4.87");
		//Home h10 = new Home("nantes", 1960,"128.33.8.5");
		
		ElectronicDevice e1=new ElectronicDevice("clim","250W","25-10-2010");
		ElectronicDevice e2=new ElectronicDevice("télé","2500W","26-03-2010");
		ElectronicDevice e3=new ElectronicDevice("chauffage","2400W","13-08-2010");
		ElectronicDevice e4=new ElectronicDevice("lingerie","1600W","11-06-2008");
		
		Heater he1=new Heater(15000,"12-12.2001","siemens");
		Heater he2=new Heater(15660,"12-11.2002","samsung");
		Heater he3=new Heater(20000,"04-10.2004","sony");
		Heater he4=new Heater(15680,"05-07-1999","filis");
		
		Friend f1=new Friend("pape","pape05");
		Friend f2=new Friend("sall","sall04");
		Friend f3=new Friend("rafaella","raff52");
		Friend f4=new Friend("philemon","philemon41");
		Friend f5=new Friend("fatou","fatou41");
		
		p1.setHomes(new ArrayList<Home>(Arrays.asList(h1)));
		p2.setHomes(new ArrayList<Home>(Arrays.asList(h2, h3)));
		p3.setHomes(new ArrayList<Home>(Arrays.asList(h4,h5)));
		p4.setHomes(new ArrayList<Home>(Arrays.asList(h6,h7)));
		
		p1.setElectronics(new ArrayList<ElectronicDevice>(Arrays.asList(e1)));
		p1.setElectronics(new ArrayList<ElectronicDevice>(Arrays.asList(e2)));
		p3.setElectronics(new ArrayList<ElectronicDevice>(Arrays.asList(e3)));
		p3.setElectronics(new ArrayList<ElectronicDevice>(Arrays.asList(e4)));
		
		h1.setHeater(he1);
		h2.setHeater(he2);
		h3.setHeater(he3);
		h4.setHeater(he4);
		
		h1.setPerson(p1);
		h2.setPerson(p2);
		h3.setPerson(p2);
		h4.setPerson(p3);
		h5.setPerson(p3);
		h6.setPerson(p4);
		h7.setPerson(p4);
		
		e1.setPerson(p1);
		e2.setPerson(p1);
		e3.setPerson(p3);
		e4.setPerson(p3);
		
		he1.setHome(h1);
		he2.setHome(h2);
		he3.setHome(h3);
		he4.setHome(h4);
		
		p1.setFriends(new ArrayList<Friend>(Arrays.asList(f1)));
		p1.setFriends(new ArrayList<Friend>(Arrays.asList(f2)));
		p2.setFriends(new ArrayList<Friend>(Arrays.asList(f3)));
		p3.setFriends(new ArrayList<Friend>(Arrays.asList(f4)));
		p3.setFriends(new ArrayList<Friend>(Arrays.asList(f5)));
		
		f1.setPerson(p1);
		f2.setPerson(p1);
		f3.setPerson(p2);
		f4.setPerson(p3);
		f5.setPerson(p3);
		
		manager.persist(p1);
		manager.persist(p2);
		manager.persist(p3);
		manager.persist(p4);
		
		manager.persist(h1);
		manager.persist(h2);
		manager.persist(h3);
		manager.persist(h4);
		manager.persist(h5);
		manager.persist(h6);
		manager.persist(h7);
		
		manager.persist(e1);
		manager.persist(e2);
		manager.persist(e3);
		manager.persist(e4);
		
		manager.persist(he1);
		manager.persist(he2);
		manager.persist(he3);
		manager.persist(he4);
		
		manager.persist(f1);
		manager.persist(f2);
		manager.persist(f3);
		manager.persist(f4);
		manager.persist(f5);

		// TODO persist entity

		tx.commit();

		// TODO run request

		System.out.println(".. done");

		manager.close();
	}
	
	/*private void listPerson(){

        List<Person> resultList = manager.createQuery("Select a From Person a", Person.class).getResultList();

        System.out.println("num of person:"+resultList.size());

        for(Person next:resultList){

            System.out.println("next person:"+next);

        }
	}*/
	}