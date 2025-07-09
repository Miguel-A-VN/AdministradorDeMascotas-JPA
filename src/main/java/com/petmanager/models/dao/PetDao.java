package com.petmanager.models.dao;

import java.util.ArrayList;
import java.util.List;

import com.petmanager.controllers.Coordinator;
import com.petmanager.controllers.JPAutil;
import com.petmanager.models.dto.Pet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class PetDao {

	private Coordinator coordinator;
	private EntityManager entityManager = JPAutil.getEntityManagerFactory().createEntityManager();

	public String registerPet(Pet pet) {
		System.out.println("Entrando a PetDAO.registerPet");

		entityManager.getTransaction().begin();
		entityManager.persist(pet);
		entityManager.getTransaction().commit();

		return "Mascota registrada";
	}

	public Pet findPet(Long petId) {
		Pet pet = entityManager.find(Pet.class, petId);
		return pet; // retorna null si no existe
	}

	public List<Pet> findAllPets() {
		Query q = entityManager.createQuery("SELECT p FROM Pet p", Pet.class);
		return q.getResultList();
	}

	public List<Pet> findPetsBySex(String sex) {
		Query q = entityManager.createQuery(
				"SELECT p FROM Pet p WHERE p.sex = :petSex", Pet.class);
		q.setParameter("petSex", sex);
		return q.getResultList();
	}

	public String updatePet(Pet pet) {

		entityManager.getTransaction().begin();
		entityManager.merge(pet);
		entityManager.getTransaction().commit();

		String resp = "Mascota Actualizada!";

		return resp;
	}

	public String deletePet(Pet pet) {

		entityManager.getTransaction().begin();
		entityManager.remove(pet);
		entityManager.getTransaction().commit();

		String resp = "Mascota Eliminada!";

		return resp;
	}

	public void close() {
		entityManager.close();
		JPAutil.shutdown();
	}

	public void setCoordinator(Coordinator coordinator) {
		this.coordinator = coordinator;
	}
}
