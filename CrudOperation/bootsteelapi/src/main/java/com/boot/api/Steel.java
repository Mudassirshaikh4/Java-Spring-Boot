package com.boot.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="steels")
public class Steel
{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="steel_id")	
private int id;
	private String location;	
	@OneToOne(cascade = javax.persistence.CascadeType.ALL)
	@JsonManagedReference
	private Destionation destionation;
	public Steel(int id, String location, Destionation destionation) {
	    this.id = id;
	    this.location = location;
	    this.destionation = destionation;
	}
	public Steel() {
	}
	@Override
	public String toString() {
	    return "steel [destionation=" + destionation + ", id=" + id + ", location=" + location + "]";
	}
	public int getId() {
	    return id;
	}
	public void setId(int id) {
	    this.id = id;
	}
	public String getLocation() {
	    return location;
	}
	public void setLocation(String location) {
	    this.location = location;
	}
	public Destionation getDestionation() {
	    return destionation;
	}
	public void setDestination(Destionation destionation) {
	    this.destionation = destionation;
	}
}
