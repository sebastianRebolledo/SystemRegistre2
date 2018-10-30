
package modelo;

public class PetClub {
	
	
private Owner firstOwner;

public PetClub() {
	
}




public Owner getFirstOwner() {
	return firstOwner;
}

public void setFirstOwner(Owner firstOwner) {
	this.firstOwner = firstOwner;
}



//public void registerOwner(Owner newOwner) {
//	
//	if(firstOwner==null) {
//		firstOwner=newOwner;
//	}
//	else {
//		
//		boolean connect=false;
//		Owner current= firstOwner;
//		
//		while(current!=null&&!connect) {
//			
//			if(newOwner.compareTo(current)>0) {
//				if(current.getNext()==null) {
//					current.setNext(newOwner);
//					newOwner.setPrevious(current);
//					connect=true;
//				}
//				else {
//					
//				current=current.getNext();	
//					
//				}
//			}
//			
//			
//			else {
//				
//			if(current.getPrevious()==null) {
//				
//				current.setPrevious(newOwner);
//				newOwner.setNext(current);
//				firstOwner=newOwner;
//				connect=true;
//			}
//			else if(current.getPrevious()!=null&&current.getNext()!=null) {
//				
//				newOwner.setNext(current);
//				newOwner.setPrevious(current.getPrevious());
//				current.getPrevious().setNext(newOwner);
//				current.setPrevious(newOwner);
//				connect=true;
//			}
//			
//			
//			else if(current.getPrevious()!=null&&current.getNext()==null){
//
//				newOwner.setNext(current);
//				newOwner.setPrevious(current.getPrevious());
//				current.getPrevious().setNext(newOwner);
//				current.setPrevious(newOwner);
//				connect=true;
//				
//			}
//				
//				
//			}
//			
//		}
//		
//		
//		
//	}
//	
//}



//public void registerOwner(Owner newOwner) {
//	
//	if(firstOwner==null) {
//		firstOwner=newOwner;
//	}
//	else {
//		
//		boolean connect=false;
//		Owner current= firstOwner;
//		
//		while(current!=null&&!connect) {
//			
//			if(newOwner.compareTo(current)>0) {
//				if(current.getNext()==null) {
//					current.setNext(newOwner);
//					newOwner.setPrevious(current);
//					connect=true;
//				}
//				else {
//					
//				current=current.getNext();	
//					
//				}
//			}
//			
//			
//			else {
//				
//			if(current.getPrevious()==null) {
//				
//				current.setPrevious(newOwner);
//				newOwner.setNext(current);
//				firstOwner=newOwner;
//				connect=true;
//			}
//			
//			
//			else{
//				newOwner.setNext(current);
//				newOwner.setPrevious(current.getPrevious());
//				current.getPrevious().setNext(newOwner);
//				current.setPrevious(newOwner);
//				connect=true;
//				
//			}
//				
//				
//			}
//			
//		}
//		
//		
//		
//	}
//	
//}





public void removeOwner(int identification) {
	
	Owner current= lookUpOwner(identification);
	
	if(current==null) {
		System.out.println("No existe el dueño");
	}
	
	else {
		
		if(current.getPrevious()==null) {
			firstOwner=current.getNext();
		}
		
		else if(current.getNext()==null) {
			Owner previous= current.getPrevious();
			previous.setNext(null);
			current.setPrevious(null);
			
		}
		
		
		else {
			Owner next= current.getNext();
			next.setPrevious(current.getPrevious());
			current.getPrevious().setNext(next);
			current.setNext(null);
			current.setPrevious(null);
			
			
		}
		
		
	}
	
	
}

public Pet lookUpPet(Owner owner,String name) {
	return owner.lookUpPet(name);
}

public Owner lookUpOwner(int identification) {
	Owner ownerFound=null;
	
	Owner current= firstOwner;
	boolean found=false;
	
	while(current!=null&&!found) {
		
		if(current.getIdentification()==identification) {
			found=true;
			ownerFound=current;
		}
		
		else {
		current=current.getNext();	
		}
		
		
		
		
	}
	
	return ownerFound;
	
}



public void registrarDueno(String nombre,String apellido,int cedula,String fechaNacimeinto) {
	
	
	
	if(firstOwner==null) {
		firstOwner= new Owner(nombre,apellido,cedula,fechaNacimeinto);;

	}
	
	else {
		Owner actual=firstOwner;
		Owner nuevo= new Owner(nombre,apellido,cedula,fechaNacimeinto);
		
		boolean enlazo=true;
		
		
		while(actual!=null&&!enlazo) {
			
			if(nuevo.compareTo(actual)>0) {
				
				if(actual.getNext()==null) {
					actual.setNext(nuevo);
					nuevo.setPrevious(actual);
					enlazo=true;
				}
				
				else {
					
					actual=actual.getNext();
					
				}
				
				
			}
			
			
			else {
				
				if(actual.getPrevious()==null) {
					actual.setPrevious(nuevo);
					nuevo.setNext(actual);
					firstOwner=nuevo;
					enlazo=true;
				}
				
				else if(actual.getPrevious()!=null&&actual.getNext()!=null) {
					nuevo.setNext(actual);
					nuevo.setPrevious(actual.getPrevious());
					actual.getPrevious().setNext(nuevo);
					actual.setPrevious(nuevo);
					enlazo=true;
				}
				
				else if(actual.getPrevious()!=null&& actual.getNext()==null) {
					nuevo.setNext(actual);
					nuevo.setPrevious(actual.getPrevious());
					actual.getPrevious().setNext(nuevo);
					actual.setPrevious(nuevo);
					enlazo=true;
					
					
				}
				
				
				
				
			}
			
			
			
			
			
		}
		
		
		
	}
	
}





public boolean buscarDueño2(Owner newOwner) {
	
	int cedula=newOwner.getIdentification();

	Owner current=firstOwner;
	boolean encontro=false;
	while(current!=null&&!encontro) {
		if(current.getIdentification()==newOwner.getIdentification()) {
			encontro=true;
		}else {
			current=current.getNext();
		}
		
	}
	
	return encontro ;
	
	
}





public void mostrar() {
	
	if(firstOwner==null) {
		System.out.println("Esta vacia");
	}else {
		
		Owner current=firstOwner;
		while(current!=null) {
			System.out.println(current.toString() +"\n");
			current= current.getNext();
		}
		
		
		
	}

}






public void registrerOwner(String name,String lastName,int identification,String birthadate) {
	if(firstOwner==null) {
		firstOwner=new Owner(name,lastName,identification,birthadate);
	}
	else {
		Owner current= firstOwner;
		Owner newOwner= new Owner(name, lastName, identification, birthadate);
		
		boolean enlazo=false;
		
		while(current!=null&& !enlazo) {
			
			if(newOwner.getIdentification()>current.getIdentification()) {
				
				if(current.getNext()==null) {
					current.setNext(newOwner);
					newOwner.setPrevious(current);
					enlazo=true;
				}
				
				else {
					current=current.getNext();
				}
				
			}
			
			
			else {
				
				if(current.getPrevious()==null) {
					current.setPrevious(newOwner);
					newOwner.setNext(current);
					firstOwner=newOwner;
					enlazo=true;
				}
				
				else if(current.getPrevious()!=null&&current.getNext()!=null) {
					newOwner.setNext(current);
					newOwner.setPrevious(current.getPrevious());
					current.getPrevious().setNext(newOwner);
					current.setPrevious(newOwner);
					
//					
					enlazo=true;

				}
				
				else if(current.getPrevious()!=null&&current.getNext()==null) {
					
					newOwner.setNext(current);
					newOwner.setPrevious(current.getPrevious());
					current.getPrevious().setNext(newOwner);
					current.setPrevious(newOwner);
					
					enlazo=true;
				}
				
				

				
				
			}
			
			
			
		}
		
		
		
	}
		
	}




public void addPet(Owner owner, Pet pet) {
	owner.addPet(pet);
}




public void modifyPet(Owner owner, Pet pet, String name, String date,int gender, int kind) {
	owner.modificarPet(pet, name, date, gender, kind);	
}

public void modifyOwner(Owner owner,String name,String lastName,int identification,String date) {
	
	if(name!=null) {
		owner.setName(name);
	}
	
	if(lastName!=null) {
		owner.setLastName(lastName);
	}
	
	if(date!=null) {
		owner.setBirthdate(date);
	}
	owner.setIdentification(identification);
	
}


public void removePet(Owner owner,Pet pet) {
	owner.removePet(pet.getName());
}






}
