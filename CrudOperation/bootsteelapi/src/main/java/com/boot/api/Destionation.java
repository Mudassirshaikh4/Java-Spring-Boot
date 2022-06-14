package com.boot.api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Destionation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int destiId;
	private String firstword;
	private String secondword;
	private String duration;
	@OneToOne(mappedBy = "destionation")
	@JsonBackReference
	private Steel steel;
     
	public int getDestiId() {
		return destiId;
	}

	public Steel getSteel() {
		return steel;
	}

	public void setSteel(Steel steel) {
		this.steel = steel;
	}

	public void setDestiId(int destiId) {
		this.destiId = destiId;
	}

	public String getFirstword() {
		return firstword;
	}

	public void setFirstword(String firstword) {
		this.firstword = firstword;
	}

	public String getSecondword() {
		return secondword;
	}

	public void setSecondword(String secondword) {
		this.secondword = secondword;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
}
