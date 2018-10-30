package interfaz;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import Exceptions.TheOwnerDoesNotExist;
import Exceptions.ThePetAlreadyExists;
import Exceptions.ThePetDoesNotExist;
import Exceptions.TheownerAlreadyHastheCedulaException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.util.converter.LocalDateStringConverter;
import modelo.Owner;
import modelo.Pet;

public class SampleController {
	
	
	private static Main main;
	
	
	@FXML
	private Button btnRepeatedOwners;
	
	@FXML
	private Button btnRepeatedPets;
	
	@FXML
	private Button btnOwners;
	
	@FXML
	private Button btnPets;
	
	@FXML
private TextField txtCriterio;
	
	@FXML
	private TextField txtChoose;
	
	@FXML
	private ListView listaNombre;
	
	@FXML
	private ObservableList<String> dataListaNombre= FXCollections.observableArrayList();

	
	@FXML
	private Button btnLookUpPet;
	
	@FXML
	private Button btnModifyPet;
	@FXML
	private Button btnLook;
	
	@FXML
	private Button btnModify;
	
	@FXML
	private TextField txtNamePet;
	@FXML
	private DatePicker datePet;
	
	
	@FXML
	private TextField txtName;
	
	@FXML
	private TextField txtLastName;
	
	@FXML
	private TextField txtIdentification;
	
	@FXML
	private DatePicker date;
	
	@FXML
	private ComboBox<String> combo2;
	
	@FXML
	private ComboBox<String> combo1;
	public SampleController() {
		main= new Main();
		btnModify= new Button();
		btnModifyPet= new Button();
		readOwners();
		combo2= new ComboBox<String>();
		combo1= new ComboBox<String>();
		listaNombre= new ListView();
	
	}
	
	
	public void initialize() {
		ObservableList<String> estados= FXCollections.observableArrayList("DOG","PET");
		combo2.setItems(estados);
		btnModify.setDisable(true);
		btnModifyPet.setDisable(true);
		
		ObservableList<String> estados2= FXCollections.observableArrayList("MALE","CLUTH");
		combo1.setItems(estados2);
	}
	
	public void fecha() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");

		DatePicker fecha2 = new DatePicker(LocalDate.now());
		fecha2.setConverter(new LocalDateStringConverter(formatter, null));
//		String fecha=fecha2.getValue()+"";
System.out.println(fecha2.getValue()+"");
		
	}
	
	public void mostrarcc() {
		
	}
	
	
	public void combo1() {
		
		System.out.println(combo1.getValue());
		
	}
	
	public void combo2() {
		
		System.out.println(combo2.getValue());	
	}
	
	
	
	
	
	
	
	public void removeOwner() {
		
		int identification=Integer.parseInt(JOptionPane.showInputDialog(null,"Escriba la cedula del dueño a elimianr"));
		
		
		try {
			Owner ownerWanted=main.darPetClub().lookUpOwner(identification);
			if(ownerWanted==null) {
				throw new TheOwnerDoesNotExist("No existe el dueño");
			}else {
				
				main.darPetClub().removeOwner(identification);
				
				Owner ownerWanted2=main.darPetClub().lookUpOwner(identification);
				
				if(ownerWanted2==null) {
					JOptionPane.showMessageDialog(null, "it was deleted");

				}
				else {
					JOptionPane.showMessageDialog(null, "it was not remved");

				}
				
				
			}

		} catch (TheOwnerDoesNotExist e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		
	}
	
	
	

public void registrerPet() {

	
	Pet newPet;
	String name= txtNamePet.getText();
	String date1= datePet.getValue()+"";
	String  gender= combo1.getValue();
	String kind=combo2.getValue();
	

   
	
	String identification=JOptionPane.showInputDialog(null,"Escriba la cedula del dueño");
	
	int cedula1= Integer.parseInt(identification);
	
	try {

		Owner ownerBuscado=main.darPetClub().lookUpOwner(cedula1);
		
		if(ownerBuscado==null) {
			throw new TheOwnerDoesNotExist("No existe el dueño");
		}
		else {
			
			Pet petLok=ownerBuscado.lookUpPet(name);
			if(petLok!=null) {
				throw new ThePetAlreadyExists("la mascota ya esta registrada");
			}
			else {
				
				
				

				
				if(gender.compareTo("MALE")==0) {
					
					if(kind.compareTo("DOG")==0) {
						 newPet= new Pet(name,date1,Pet.MALE,Pet.DOG);

					}else {
						 newPet= new Pet(name,date1,Pet.MALE,Pet.CAT);
	
					}
				}
				else {
					
					if(kind.compareTo("DOG")==0) {
						 newPet= new Pet(name,date1,Pet.CLUTCH,Pet.DOG);

					}else {
						 newPet= new Pet(name,date1,Pet.CLUTCH,Pet.CAT);

					}
					
				}
						
				main.darPetClub().lookUpOwner(cedula1).addPet(newPet);
				
//			ownerBuscado.addPet(newPet);
			
			
			Pet petBuscado=ownerBuscado.lookUpPet(name);
			
			
			if(petBuscado!=null) {
				JOptionPane.showMessageDialog(null,"Se registro la mascota con exito");

			}else {
				JOptionPane.showMessageDialog(null,"No se puedo registrar la mascota");

				
			}
			}
			

			
		}
		
		
		
		
	}catch (TheOwnerDoesNotExist e) {
		JOptionPane.showMessageDialog(null,e.getMessage());
	}catch (ThePetAlreadyExists e2) {
		JOptionPane.showMessageDialog(null,e2.getMessage());

	}
	
	
	
}
	
	

	public void registrerOwner() {
		

		String name= txtName.getText();
		
		String lastName=txtName.getText();
		int identification=Integer.parseInt(txtIdentification.getText());
		String date1= date.getValue()+"";

		Owner newOwner= new Owner(name,lastName, identification, date1);
		boolean esta=main.darPetClub().buscarDueño2(newOwner);
		if(esta==true) {
			try {
				throw new TheownerAlreadyHastheCedulaException("There is already an owner with the same ID");
			} catch (TheownerAlreadyHastheCedulaException e1) {
			
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}else {
			main.darPetClub().registrerOwner(name, lastName, identification, date1);
			
			saveOwners();

			mostrar();
			System.out.println("Yaa");
		}
	}
	
	
	
	
	
	
	public void saveOwners() {
		
		Owner owners=null;
		
		FileOutputStream fileOut=null;
		ObjectOutputStream out=null;
		
		try {
			fileOut= new FileOutputStream("archivos/owners.dat");
			out= new ObjectOutputStream(fileOut);
			owners=main.darPetClub().getFirstOwner();
			out.writeObject(owners);
		
		}catch(Exception e) {
			System.out.println(e.getMessage()+":D");
		}finally {
			try {
				if(owners!=null) {
					fileOut.close();
				}
				
				if(out!=null) {
					out.close();
				}
				
				
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2.getMessage()+":x");
			}
			
			
			
		}
		
		
		
	}
	
	
	
	public void lookUpOwner() {

		
		int identification=Integer.parseInt(JOptionPane.showInputDialog(null,"Write the owner's ID"));
		
	try {
		
		Owner ownerWanted= main.darPetClub().lookUpOwner(identification);
		
		if(ownerWanted==null) {
			throw new TheOwnerDoesNotExist("The owner does not exist");
			
		}else {
			txtIdentification.setDisable(true);
			txtIdentification.setText(ownerWanted.getIdentification()+"");
			txtName.setText(ownerWanted.getName());
			
			txtLastName.setText(ownerWanted.getLastName());
			btnModify.setDisable(false);
			
		}
		
	} catch (TheOwnerDoesNotExist e) {
		// TODO: handle exception
		JOptionPane.showMessageDialog(null, e.getMessage());
		
	}
		
		
	}
	
	
	
	
	
	
	public void readOwners() {
		
		Owner owners=null;
		
		FileInputStream fileInp=null;
		ObjectInputStream entrada= null;
		
		
		try {
			fileInp=new FileInputStream("archivos/owners.dat");
			entrada= new ObjectInputStream(fileInp);
			owners=(Owner)entrada.readObject();
			main.darPetClub().setFirstOwner(owners);
			


			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage()+"ss");
		}finally {
			
			try {
				
				if(fileInp!=null) {
					fileInp.close();
				}
				
				if(entrada!=null) {
					entrada.close();
				}
				
				
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2.getMessage()+":aa");
			}
			
			
		}
		
		
	}
	
	
	
	//eliminar mascot
	public void removePet() {
		

		String identification=JOptionPane.showInputDialog(null,"Write the owner's ID");
		
		int identification1= Integer.parseInt(identification);
		
		
		try {

			Owner ownerWanted=main.darPetClub().lookUpOwner(identification1);
			
			if(ownerWanted==null) {
				throw new TheOwnerDoesNotExist("The owner doesn't exist");
			}
			else {
				
				ownerWanted.mostrarMascota();
				
				String name=JOptionPane.showInputDialog(null,"Read the Pet's name");
			Pet petWanted= ownerWanted.lookUpPet(name);
			if(petWanted==null) {
				throw new ThePetDoesNotExist("The pet doesn't exist");
			} 
			else {
				
			ownerWanted.removePet(name);
			ownerWanted.mostrarMascota();
			Pet petBuscado2= ownerWanted.lookUpPet(name);

			if(petBuscado2==null) {
				JOptionPane.showMessageDialog(null,"it was deleted");
			}else {
				JOptionPane.showMessageDialog(null,"it doesn't was removed");

			}
			
			}
			
				
			}
			
			
			
			
		}catch (TheOwnerDoesNotExist e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		} catch (ThePetDoesNotExist e2) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e2.getMessage());
		}
		
		
		
	}
	
	
	
	public void lookUpPet() {
		
		try {
			int identification=Integer.parseInt(JOptionPane.showInputDialog(null,"Write the owner's ID"));

			Owner ownerWanted=main.darPetClub().lookUpOwner(identification);
			if(ownerWanted==null) {
				throw new TheOwnerDoesNotExist("The owner doesn't exist");
			} 
			else {
				txtIdentification.setText(ownerWanted.getIdentification()+"");
		txtLastName.setText(ownerWanted.getLastName());
		txtName.setText(ownerWanted.getName());
		

				String namePet=JOptionPane.showInputDialog(null,"Write the Pet's name ");
				Pet petWanted=ownerWanted.lookUpPet(namePet);
				if(petWanted==null) {
					throw new ThePetDoesNotExist("The pet doesn't exist");
				}else {
					txtNamePet.setText(petWanted.getName());
					if(petWanted.getGender()==Pet.CLUTCH) {
						combo1.setValue("CLUTCH");
					}else {
						combo1.setValue("MALE");
					}
					
					
					if(petWanted.getGender()==Pet.DOG) {
						combo2.setValue("DOG");
					}
					else {
						combo2.setValue("CAT");
					}
					
					txtNamePet.setDisable(true);
					
					
					btnModifyPet.setDisable(false);
				}
				
			}
		}catch(TheOwnerDoesNotExist e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		} catch (ThePetDoesNotExist e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e.getMessage());
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());

		}
				
		
	}
	
	
	
	//modifciar mascot
	public void modifyPet(ActionEvent e) {
		
		
	
		String name=txtNamePet.getText();
		
		int identificationOne= Integer.parseInt(txtIdentification.getText());
		
		Owner ownerWanted=main.darPetClub().lookUpOwner(identificationOne);
		ownerWanted.mostrarMascota();
		Pet petWanted=ownerWanted.lookUpPet(name);
		
		if(combo1.getValue().compareTo("CLUTCH")==0) {
			
			
			if(combo2.getValue().compareTo("DOG")==0) {
				ownerWanted.modificarPet(petWanted,name,datePet.getValue()+"" , Pet.CLUTCH, Pet.DOG);

			}else{
				ownerWanted.modificarPet(petWanted,name,datePet.getValue()+"" , Pet.CLUTCH, Pet.CAT);

			}
			

		}
		
		else {
			if(combo2.getValue().compareTo("DOG")==0) {
				ownerWanted.modificarPet(petWanted,name,datePet.getValue()+"" , Pet.MALE, Pet.DOG);

			}else{
				ownerWanted.modificarPet(petWanted,name,datePet.getValue()+"" , Pet.MALE, Pet.CAT);

			}
			
		}
		

		ownerWanted.mostrarMascota();
	}
	
	
	
	//modificar dueño
	public void modifyOwner(ActionEvent e) {			
		
		
		
          main.darPetClub().mostrar();
	
			
			 int identification=Integer.parseInt(txtIdentification.getText());
				Owner ownerModify= main.darPetClub().lookUpOwner(identification);
				
			
				
				main.darPetClub().modifyOwner(ownerModify, txtName.getText(),txtLastName.getText(), identification, date.getValue()+"");
				

		        
		        main.darPetClub().mostrar();


		
	}
	
	
	
	
	

		
		

		
		
	
	
	//Mostrar mascotas
	
	
	
	
	
	
	
	public void showPets() {
		
		String name= JOptionPane.showInputDialog("NAME");
		Owner current= main.darPetClub().getFirstOwner();
		boolean encontro=false;
		while(current!=null&&!encontro) {
			
		
			
			
			if(current.getName().compareTo(name)==0) {
				String arreglo[]=current.getBirthdate().split("-");
				int year= Integer.parseInt(arreglo[0]);
				int month=Integer.parseInt(arreglo[1]);
				int day= Integer.parseInt(arreglo[2]);
				encontro=true;
				System.out.println(year +" . " + month +" ." + day);
			}
			current=current.getNext();
			
		}
		
	}
	
	
	
	public void showOwners() {
String criterio="1.Name\n2.Last Name\n3.BirthDate\n4.Every one" ;
		
		int option= Integer.parseInt(JOptionPane.showInputDialog(null,criterio) );
		
		if(option==1) {
			String name=JOptionPane.showInputDialog(null,"Read name");
			
			Owner current= main.darPetClub().getFirstOwner();
			
			   while(current!=null) {
		        	
		        	if(current.getName().compareTo(name)==0) {
		        		
		        		
		        		
		        		dataListaNombre.add("Nombre: " + current.getName() );
						current=current.getNext();
		        	}else {
		        		current=current.getNext();
		        	}
		        	
		        }
			
			   listaNombre.setItems(dataListaNombre);
			
		}else if(option==2) {
			String lastName=JOptionPane.showInputDialog(null,"Write Last Name");
			

			Owner current= main.darPetClub().getFirstOwner();
			
			   while(current!=null) {
		        	
		        	if(current.getLastName().compareTo(lastName)==0) {
		        		dataListaNombre.add("Apellido: " + current.getLastName() );
					current=current.getNext();
		        	}else {
		        		current=current.getNext();
		        	}
		        	
		        }
			
			
			   listaNombre.setItems(dataListaNombre);

			
			
		}else if(option==3){


			int day=Integer.parseInt(JOptionPane.showInputDialog("Write day"));
			int month=Integer.parseInt(JOptionPane.showInputDialog("Write month"));
			int year= Integer.parseInt(JOptionPane.showInputDialog("Write year"));
			

			Owner current= main.darPetClub().getFirstOwner();
			
			   while(current!=null) {
		        	
				   String arreglo[]=current.getBirthdate().split("-");
				   int año=Integer.parseInt(arreglo[0]);
				  int mes= Integer.parseInt(arreglo[1]);
				  int dia= Integer.parseInt(arreglo[2]);
				   
				  if(año==year&&day==dia&&mes==month) {
					  dataListaNombre.add("Birtdate: " + current.getBirthdate());
				  }
		        	current=current.getNext();
		        	
		        }
			
			
			   listaNombre.setItems(dataListaNombre);
			
			
		}
		else {
			
			Owner current= main.darPetClub().getFirstOwner();
			
			   while(current!=null) {
		        	
	        		dataListaNombre.add("Name: " + current.getName() +" Last name: " + current.getLastName() + " Birthdate" + current.getBirthdate() + "Identification :" + current.getIdentification());;
                  current=current.getNext();
		        	
		        }
	
			   listaNombre.setItems(dataListaNombre);
	
		}
		
	}
	
	
	
	
	public void showRepatedOwners() {
		String criterio="1.Last Name\n2.BirthDate\n3.none" ;

		int criterioElegido= Integer.parseInt(JOptionPane.showInputDialog(criterio));

		
		if(criterioElegido==1) {
			
			String apellido= JOptionPane.showInputDialog("Digita el apellido");
			
			Owner actual= main.darPetClub().getFirstOwner();
			
			
			
               while(actual!=null) {
				
				Owner siguiente= actual.getNext();
				while(siguiente!=null) {
					
					if(actual.getName().compareTo(siguiente.getName())==0) {
		        		dataListaNombre.add(" Nombre: " + actual.getName() );

					}
					siguiente=siguiente.getNext();
					
				}
				
				Owner anterior=actual.getPrevious();
				while(anterior!=null) {
					if(actual.getName().compareTo(anterior.getName())==0) {
		        		dataListaNombre.add("Name: " + actual.getName() );

					}
					anterior=anterior.getPrevious();
					
				}
				actual=actual.getNext();

			}
			
			
			
               Owner actual2= main.darPetClub().getFirstOwner();
			while(actual2!=null) {
				
				if(actual2.getLastName().compareTo(apellido)==0) {
	        		dataListaNombre.add("Apellido: " + actual2.getLastName());

				}
				actual2=actual2.getNext();
			}
		
			   listaNombre.setItems(dataListaNombre);


		}
		
		
		else if(criterioElegido==2){
			
			int dia=Integer.parseInt(JOptionPane.showInputDialog("Digita el dia"));
			int mes=Integer.parseInt(JOptionPane.showInputDialog("Digita el mes"));
			int año= Integer.parseInt(JOptionPane.showInputDialog("Digita el año"));
		
			String nuevaFecha=año+"-"+"-"+mes+"-"+dia;
			
			Owner actual= main.darPetClub().getFirstOwner();
			
			 while(actual!=null) {
					
					Owner siguiente= actual.getNext();
					while(siguiente!=null) {
						
						if(actual.getName().compareTo(siguiente.getName())==0) {
			        		dataListaNombre.add(" Nombre: " + actual.getName() );

						}
						siguiente=siguiente.getNext();
						
					}
					
					Owner anterior=actual.getPrevious();
					while(anterior!=null) {
						if(actual.getName().compareTo(anterior.getName())==0) {
			        		dataListaNombre.add("Name: " + actual.getName() );

						}
						anterior=anterior.getPrevious();
						
					}
					actual=actual.getNext();

				}
			
			
			
			
			
			
			
			Owner actual2=main.darPetClub().getFirstOwner();
			while(actual2!=null) {
				
				if(actual2.getBirthdate().compareTo(nuevaFecha)==0) {
	        		dataListaNombre.add("Date: " + actual2.getBirthdate() );

				}
				actual2=actual2.getNext();
				
			}

			
			   listaNombre.setItems(dataListaNombre);

	
		}else {
			
			
			Owner actual= main.darPetClub().getFirstOwner();
			
			
			
            while(actual!=null) {
				
				Owner siguiente= actual.getNext();
				while(siguiente!=null) {
					
					if(actual.getName().compareTo(siguiente.getName())==0) {
		        		dataListaNombre.add(" Nombre: " + actual.getName() );

					}
					siguiente=siguiente.getNext();
					
				}
				
				Owner anterior=actual.getPrevious();
				while(anterior!=null) {
					if(actual.getName().compareTo(anterior.getName())==0) {
		        		dataListaNombre.add("Name: " + actual.getName() );

					}
					anterior=anterior.getPrevious();
					
				}
				actual=actual.getNext();

			}
			
			
			
			
			   listaNombre.setItems(dataListaNombre);

			
			
		}
		
		

		
	}
	
	
	
	
	
	public void mostraPetsRepetidos() {
		String criterio="1.Nombre\n2.Tipo\n3.FechaNacimiento\n4.Genero" ;
int criterioElegido= Integer.parseInt(JOptionPane.showInputDialog(criterio));

if(criterioElegido==1) {
	String nombre= JOptionPane.showInputDialog("Escribe el nombre");
	
	Owner actual= main.darPetClub().getFirstOwner();
	
	while(actual!=null) {
		
		Pet petActual= actual.getFirstPet();
		
		while(petActual!=null) {
			
			if(petActual.getName().compareTo(nombre)==0) {
        		dataListaNombre.add("Nombre:  " +petActual.getName());

			}
			petActual=petActual.getNext();
		}
		
		actual=actual.getNext();
	}
	   listaNombre.setItems(dataListaNombre);

	
}else if(criterioElegido==2) {
	
	
	
	
	
}else if(criterioElegido==3) {
	
}else {
	
}



	}
	
	
	
	public void mostrar() {
		main.darPetClub().mostrar();
	}
	
}
