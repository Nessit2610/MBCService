package com.ftec.MBCService.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="roles")
public class Role {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="namerole")
	private String namerole;
	
	@Column(name="descriptions")
	private String descriptions;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(int id, String namerole, String descriptions) {
		super();
		this.id = id;
		this.namerole = namerole;
		this.descriptions = descriptions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNamerole() {
		return namerole;
	}

	public void setNamerole(String namerole) {
		this.namerole = namerole;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	
	
}
