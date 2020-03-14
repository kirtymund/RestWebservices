package com.kirty.restws.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Patients")
public class Patients {
	private long ID;
	private String name;

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}