package modelo;

import java.io.Serializable;

public class Owner implements Serializable,Comparable<Owner>{
	
	@Override
	public String toString() {
		return "identification: " + identification + "lastName: " + lastName + "name: " + name + "birthdate: "
				+ birthdate + "]";
	}


	private Owner next;
	
	private Owner previous;
	
private Pet firstPet;
	


	private int identification;
	
	private String lastName;
	
	private String name;
	
	
	private String birthdate;
	
	
	
	public Owner(String name, String lastName, int identificator,String birthdate) {
		this.name=name;
		this.lastName=lastName;
		this.birthdate=birthdate;
		this.identification=identificator;
	}
	
	public int getIdentification() {
		return identification;
	}

	public void setIdentification(int identification) {
		this.identification = identification;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}




	public Owner getPrevious() {
		return previous;
	}

	public void setPrevious(Owner previous) {
		this.previous = previous;
	}



	public Owner getNext() {
	return next;
}

public void setNext(Owner next) {
	this.next = next;
}

public Pet getFirstPet() {
	return firstPet;
}

public void setFirstPet(Pet firstPet) {
	this.firstPet = firstPet;
}

	@Override
	public int compareTo(Owner o2) {
		int result=0;
		
//		if(this.identification.compareTo(o2.getIdentification())>0) {
//			result=1;
//		}else if(this.identification.compareTo(o2.getIdentification())<0) {
//			result=-1;
//		}else {
//			result=0;
//		}
//		// TODO Auto-generated method stub
		return result;
	}
	
	public void addPet(Pet newPet) {
		
		if(firstPet==null) {
			firstPet=newPet;
		}else {
			
			Pet current= firstPet;
			Boolean connect=false;
			while(current!=null&&!connect) {
				
				if(current.getNext()==null) {
					current.setNext(newPet);
					connect=true;
					current=current.getNext();	
				}
				
				else{
				current=current.getNext();
					
				}
				
				
				
				
			}
			
			
			
		}
		
	}
	
	
	public void removePet(String name) {
		Pet wantedPet= lookUpPet(name);
		Pet current= firstPet;
		Pet previous= null;
		
		if(wantedPet==null) {
			//excedption
			System.out.println("No existe la mascota");
		}
		else {
			if(current.getName().compareTo(wantedPet.getName())==0) {
				current=current.getNext();
				firstPet=current;
			}else {
				boolean remove=false;
				
				while(current!=null&&!remove) {
					
					if(current.getName().compareTo(wantedPet.getName())==0) {
						
						if(previous!=null&& current.getNext()!=null) {
							previous.setNext(current.getNext());
							current.setNext(null);
						}
						
						else {
							previous.setNext(null);
						}
						
						
					}
					
					
					else {
						
						previous=current;
						current=current.getNext();
						
					}
					
					
				}
			}
			
		}
		
		
	}
	
	
	
	
	
	public void mostrarMascota() {
		int contador=0;
		if(firstPet==null) {
			System.out.println("Esta vacia");
		}else {
			
			Pet actual=firstPet;
			while(actual!=null) {
				contador++;
				System.out.println("Mascota actual es:" + contador +" Nombre mascota"+actual.getName() +"\n");
				
				actual= actual.getNext();
			}
			
			
			
		}
	
	}
	
	
	public Pet lookUpPet(String name) {
		Pet wantedPet=null;
		boolean foundThePet=false;
		
		Pet current= firstPet;
		while(current!=null&& !foundThePet) {
			if(current.getName().compareTo(name)==0) {
				foundThePet=true;
				wantedPet=current;
			}
			else {
				current=current.getNext();
			}
		}
		return wantedPet;
		
	}
	
	
	
	public void modificarPet(Pet pet,String name,String fecha,int genero,int kind) {
		if(name!=null) {
			pet.setName(name);
		}
		if(fecha!=null) {
			pet.setBirthDate(fecha);
		}
		
		pet.setGender(genero);
		pet.setKind(kind);
	}
	
	
	

}
