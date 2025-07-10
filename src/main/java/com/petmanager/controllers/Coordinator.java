package com.petmanager.controllers;

import java.util.List;

import com.petmanager.models.dao.PetDao;
import com.petmanager.models.dto.Pet;
import com.petmanager.views.MainView;
import com.petmanager.views.RegisterView;
import com.petmanager.views.QueryPetView;
import com.petmanager.views.QueryListPetView;

public class Coordinator {
    private MainView mainView;
    private RegisterView registerView;
    private QueryPetView queryPetView;
    private QueryListPetView queryListView;
    private PetDao petDAO;
    private Pet pet;

    public void setMainView(MainView mainView) {
        this.mainView = mainView;
    }

    public void setRegisterView(RegisterView registerView) {
        this.registerView = registerView;
    }

    public void setQueryPetView(QueryPetView queryPetView) {
        this.queryPetView = queryPetView;
    }

    public void setQueryListView(QueryListPetView queryListView) {
        this.queryListView = queryListView;
    }

    public void setPetDAO(PetDao petDAO) {
        this.petDAO = petDAO;
    }
    
    public void showMainView(){
        mainView.setVisible(true);
    }
    
    public void showRegisterView(){
        registerView.setVisible(true);
    }
    
    public void showQueryPetView(){
        queryPetView.setVisible(true);
    }
    
    public void showQueryListPetView(){
        queryListView.setVisible(true);
    }
    
    
    
    public String petRegister(Pet newPet) {
	return petDAO.registerPet(newPet);

    }
  
    public Pet queryPet(Long idMascota) {
    	return petDAO.findPet(idMascota);
    }
    
    public List<Pet> queryListPet(Long idPet) {
    	return petDAO.findAllPets();
    }
    
    public List<Pet> queryPetSex(String findSex) {
    	return petDAO.findPetsBySex(findSex);
    }
    
    public String eliminarMascota(Pet delate) {
    	return petDAO.deletePet(delate);
    }
    
    public String updatePet(Pet update) {
	return petDAO.updatePet(update);
    }
    
}
