package com.petmanager.controllers;

import java.util.List;
import javax.swing.JOptionPane;
import com.petmanager.models.dao.PetDao;
import com.petmanager.models.dto.Pet;

public class App {

	PetDao petDao = new PetDao();

	public void start() {
		String menu = "MENÚ DE OPCIONES\n\n"
				+ "1. Registrar Mascota\n"
				+ "2. Consultar Mascota\n"
				+ "3. Consultar Lista de Mascotas\n"
				+ "4. Consultar Lista de Mascotas por sexo\n"
				+ "5. Actualizar Mascota\n"
				+ "6. Eliminar Mascota\n"
				+ "7. Salir\n";

		int option = 0;
		while (option != 7) {
			option = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (option) {
				case 1 -> registerPet();
				case 2 -> findPet();
				case 3 -> listPets();
				case 4 -> listPetsBySex();
				case 5 -> updatePet();
				case 6 -> deletePet();
				case 7 -> petDao.close(); // cerrar conexión
			}
		}
	}

	private void registerPet() {
		Pet pet = new Pet();
		pet.setPetId(null);
		pet.setName(JOptionPane.showInputDialog("Ingrese el nombre de la mascota"));
		pet.setBreed(JOptionPane.showInputDialog("Ingrese la raza de la mascota"));
		pet.setColor(JOptionPane.showInputDialog("Ingrese el color de la mascota"));
		pet.setSex(JOptionPane.showInputDialog("Ingrese el sexo de su mascota"));

		System.out.println(petDao.registerPet(pet));
		System.out.println();
	}

	private void findPet() {
		Long id = Long.parseLong(JOptionPane.showInputDialog("Ingrese el id de la Mascota"));
		Pet pet = petDao.findPet(id);
		if (pet != null) {
			System.out.println(pet);
		} else {
			System.out.println("No se encontró la mascota");
		}
		System.out.println();
	}

	private void listPets() {
		System.out.println("Lista de Mascotas");
		List<Pet> pets = petDao.findAllPets();
		pets.forEach(System.out::println);
		System.out.println();
	}

	private void listPetsBySex() {
		System.out.println("Lista de Mascotas por sexo");
		String sex = JOptionPane.showInputDialog("Ingrese el sexo de la Mascota");
		List<Pet> pets = petDao.findPetsBySex(sex);
		pets.forEach(System.out::println);
		System.out.println();
	}

	private void updatePet() {
		Long id = Long.parseLong(JOptionPane.showInputDialog("Ingrese el id de la Mascota para actualizar"));
		Pet pet = petDao.findPet(id);
		if (pet != null) {
			System.out.println(pet);
			pet.setName(JOptionPane.showInputDialog("Ingrese el nombre de la mascota"));
			pet.setBreed(JOptionPane.showInputDialog("Ingrese la raza de la mascota"));
			pet.setColor(JOptionPane.showInputDialog("Ingrese el color de la mascota"));
			pet.setSex(JOptionPane.showInputDialog("Ingrese el sexo de su mascota"));

			System.out.println(petDao.updatePet(pet));
		} else {
			System.out.println("No se encontró la mascota");
		}
		System.out.println();
	}

	private void deletePet() {
		Long id = Long.parseLong(JOptionPane.showInputDialog("Ingrese el id de la Mascota para eliminar"));
		Pet pet = petDao.findPet(id);
		if (pet != null) {
			System.out.println(pet);
			System.out.println(petDao.deletePet(pet));
		} else {
			System.out.println("No se encontró la mascota");
		}
		System.out.println();
	}
}
