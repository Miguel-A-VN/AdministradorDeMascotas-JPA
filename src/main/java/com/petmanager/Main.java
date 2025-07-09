package com.petmanager;

import com.petmanager.controllers.App;

public class Main {
    public static void main(String[] args) {
        // Aquí puedes iniciar tu aplicación, por ejemplo, creando una instancia de Coordinator
        // Coordinator coordinator = new Coordinator();
        App app = new App();
        app.start(); // Inicia la aplicación, que a su vez interactúa con el coordinador
        // Puedes agregar más lógica aquí para interactuar con el coordinador o iniciar la interfaz de usuario
    }
}
