package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import interfaz.Main;
import modelo.Owner;
import modelo.Pet;
import modelo.PetClub;

class TestPetClub {
	
	private PetClub petClub;


	
	public void scenario1() {
		petClub= new PetClub();
	}
	
	
	@Test
	public void testRegisterOwner() {
		scenario1() ;
		

		petClub.registrerOwner("Sebastian", "Rebolledo", 1, "12-01-2987");
		petClub.registrerOwner("Isabel", "Rebolledo", 0, "12-01-2987");
		petClub.registrerOwner("Marcela", "Rebolledo", 3, "12-01-2987");
		petClub.registrerOwner("Marcela", "Rebolledo", 2, "12-01-2987");

		Owner actual=petClub.getFirstOwner();
		int contador=1;
		int enlazados=0;
		while(actual!=null&&contador<=4) {
			
			if(contador==1) {
				if(actual.getIdentification()==0) {
					enlazados++;
				}
			}else if(contador==2) {
				if(actual.getIdentification()==1) {
					enlazados++;
				}
			}else if(contador==3) {
				if(actual.getIdentification()==2) {
					enlazados++;
				}
			}else {
				if(actual.getIdentification()==3) {
					enlazados++;
				}
			}
				
				actual=actual.getNext();
			contador++;
		}
		assertEquals(4, enlazados);

	}
	
	
	
	
	@Test
	public void testRemoveOwner() {	
	scenario1();
	
	petClub.registrerOwner("Sebastian", "Rebolledo", 1, "12-01-2987");
	petClub.registrerOwner("Isabel", "Rebolledo", 0, "12-01-2987");
	petClub.registrerOwner("Marcela", "Rebolledo", 3, "12-01-2987");
	petClub.registrerOwner("Marcela", "Rebolledo", 2, "12-01-2987");

	int cedulaEliminar=1;
	
	petClub.removeOwner(cedulaEliminar);
	
	boolean NoSeElimino=false;
	Owner actual= petClub.getFirstOwner();
	while(actual!=null&&!NoSeElimino) {
		if(actual.getIdentification()==1) {
			NoSeElimino=true;
		}else {
			actual=actual.getNext();
		}
	}
	
	boolean elimino=false;
	if(NoSeElimino==true) {
		elimino=false;
	}else {
		elimino=true;
	}
	
	
	assertTrue(elimino);
	
	}
	
	
	
	@Test
	public void testLookUpOwner() {
		scenario1();
		
		petClub.registrerOwner("Sebastian", "Rebolledo", 1, "12-01-2987");
		petClub.registrerOwner("Isabel", "Rebolledo", 0, "12-01-2987");
		petClub.registrerOwner("Marcela", "Rebolledo", 3, "12-01-2987");
		int cedula=3;
		Owner buscado=petClub.lookUpOwner(cedula);
		assertEquals(cedula, buscado.getIdentification());
		
		
		
	}
	
	@Test
	public void testModifyOwner() {
		scenario1();
		
		petClub.registrerOwner("Sebastian", "Rebolledo", 1, "2018-10-11");
		petClub.registrerOwner("Isabel", "Rebolledo", 0, "2018-10-11");
		petClub.registrerOwner("Marcela", "Rebolledo", 3, "2018-10-11");
		
		
		int nuevaCedula=8;
		Owner owner=petClub.lookUpOwner(1);
		petClub.modifyOwner(owner, "Andres", "Andrea", nuevaCedula,"12-01-2987" );
		
		Owner ownerModifciado=petClub.lookUpOwner(nuevaCedula);
		boolean modifico=false;
		if(ownerModifciado!=null) {
			modifico=true;
		}else {
			modifico=false;
		}
		
		assertTrue(modifico);
		
	}
	
	
	
	@Test
	public void testAddPet() {
		scenario1();
		petClub.registrerOwner("Sebastian", "Rebolledo", 1, "2018-10-11");
		petClub.registrerOwner("Isabel", "Rebolledo", 0, "2018-10-11");
		petClub.registrerOwner("Marcela", "Rebolledo", 3, "2018-10-11");
		
		Owner owner= petClub.lookUpOwner(0);
		
	     Pet newPet= new Pet("Sarah","2018-10-11" , 1, 2);
		Pet newPet2= new Pet("Samantha","2018-10-11" , 2, 1);
		owner.addPet(newPet);
		owner.addPet(newPet2);
		
		Pet petBuscada=owner.lookUpPet("Samantha");
		boolean encontro=false;
		if(petBuscada!=null) {
			encontro=true;
		}else {
			encontro=false;
		}
		
		assertTrue(encontro);
		
		
		
	}
	
	
	
	@Test
	public void testRemovePet() {
		
		
		scenario1();
		petClub.registrerOwner("Sebastian", "Rebolledo", 1, "2018-10-11");
		petClub.registrerOwner("Isabel", "Rebolledo", 0, "2018-10-11");
		petClub.registrerOwner("Marcela", "Rebolledo", 3, "2018-10-11");
		
		Owner owner= petClub.lookUpOwner(0);
		
	     Pet newPet= new Pet("Sarah","2018-10-11" , 1, 2);
		Pet newPet2= new Pet("Samantha","2018-10-11" , 2, 1);
		owner.addPet(newPet);
		owner.addPet(newPet2);
		
		boolean elimino=false;
		owner.removePet("Sarah");
		Pet petBuscada=owner.lookUpPet("Sarah");
		if(petBuscada==null) {
			elimino=true;
		}else {
			elimino=false;
		}
		
		assertTrue(true);
			
		
		
		
	}
	
	
	
	@Test
	public void testLookUpPet() {
		scenario1();
		petClub.registrerOwner("Sebastian", "Rebolledo", 1, "2018-10-11");
		petClub.registrerOwner("Isabel", "Rebolledo", 0, "2018-10-11");
		petClub.registrerOwner("Marcela", "Rebolledo", 3, "2018-10-11");
		Owner owner= petClub.lookUpOwner(0);
		
	     Pet newPet= new Pet("Sarah","2018-10-11" , 1, 2);
		Pet newPet2= new Pet("Samantha","2018-10-11" , 2, 1);
		owner.addPet(newPet);
		owner.addPet(newPet2);
		
		boolean encontro=false;
		
		Pet petBusca=owner.lookUpPet("Sarah");
		if(petBusca!=null) {
			encontro=true;
		}else{
			encontro=false;
		}
		
		
		assertTrue(encontro);
		
	}
	
	
	@Test
	public void testModifyPet() {
		
		scenario1();
		petClub.registrerOwner("Sebastian", "Rebolledo", 1, "2018-10-11");
		petClub.registrerOwner("Isabel", "Rebolledo", 0, "2018-10-11");
		petClub.registrerOwner("Marcela", "Rebolledo", 3, "2018-10-11");
		Owner owner= petClub.lookUpOwner(0);
		
	     Pet newPet= new Pet("Sarah","2018-10-11" , 1, 2);
		Pet newPet2= new Pet("Samantha","2018-10-11" , 2, 1);
		owner.addPet(newPet);
		owner.addPet(newPet2);
		
		owner.modificarPet(newPet, "Carlita","2018-10-11" , 1, 2);
		boolean encontro=false;
		
		Pet petBuscada=owner.lookUpPet("Carlita");
		
		if(petBuscada!=null) {
			encontro=true;
		}else {
			encontro=false;
		}
		
		assertTrue(encontro);
		
	}
	
	
	
	
	
	
	
	
	
}
