/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petmanager.controllers;

import com.petmanager.models.dao.PetDao;
import com.petmanager.views.MainView;
import com.petmanager.views.QueryListPetView;
import com.petmanager.views.QueryPetView;
import com.petmanager.views.RegisterView;

/**
 *
 * @author mvarg
 */
public class Relations {
    
        public Relations(){
        MainView winMain = new MainView();
        RegisterView winRegister = new RegisterView();
        QueryPetView winQueryPet = new QueryPetView();
        QueryListPetView winQueryListPet = new QueryListPetView();

        PetDao myPetDao = new PetDao();

        Coordinator myCoordinator = new Coordinator();


        winMain.setMyCoordinator(myCoordinator);
        winRegister.setMyCoordinator(myCoordinator);
        winQueryPet.setMyCoordinator(myCoordinator);
        winQueryListPet.setMyCoordinator(myCoordinator);

        myPetDao.setCoordinator(myCoordinator);

        myCoordinator.setMainView(winMain);
        myCoordinator.setRegisterView(winRegister);
        myCoordinator.setQueryListView(winQueryListPet);
        myCoordinator.setQueryPetView(winQueryPet);

        myCoordinator.setPetDAO(myPetDao);

        myCoordinator.showMainView();
    }
}