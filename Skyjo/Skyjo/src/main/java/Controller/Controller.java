/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Model;
import fxLayout.mainFx;
import javafx.application.Application;

/**
 *
 * @author Gregory
 */
public class Controller {
    
    private Model game;
    
    public void start(String[] args) {
        Application.launch(mainFx.class, args);
    }
}
