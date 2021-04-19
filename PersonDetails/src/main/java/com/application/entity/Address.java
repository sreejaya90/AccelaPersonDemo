package com.application.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String street;
	private String city;
	private String state;
	private String postalCode;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personId")
    private Person person;
	
	private Address(){
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

//	public Person getPerson() {
//		return person;
//	}

	public void setPerson(Person person) {
		this.person = person;
	}
	@Override
    public String toString() {
        return "Address [id=" + id + ", state=" + getState() + "]";
    }
}
