package modelo;

import java.io.Serializable;

public class Pet  {
	
	
	
	public static int CLUTCH=1;
	
	public static int MALE=2;
	
	public static int DOG=3;

	public static int CAT=4;
	
	
	
	private Pet next;
	
	private String name;
	
	private String birthDate;
	
	private int gender;
	
	private int kind;
	
	
	
	public Pet(String name,String birthDate,int gender,int kind) {
		this.name=name;
		this.birthDate=birthDate;
		this.gender=gender;
		this.kind=kind;
	}



	public Pet getNext() {
		return next;
	}



	public void setNext(Pet next) {
		this.next = next;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getBirthDate() {
		return birthDate;
	}



	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}



	public int getGender() {
		return gender;
	}



	public void setGender(int gender) {
		this.gender = gender;
	}



	public int getKind() {
		return kind;
	}



	public void setKind(int kind) {
		this.kind = kind;
	}
	
	
	
	
}
