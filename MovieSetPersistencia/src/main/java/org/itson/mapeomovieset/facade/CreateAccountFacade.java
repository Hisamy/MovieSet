/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mapeomovieset.facade;

import org.itson.mapeomovieset.logica.CreateAccount;
import org.itson.moviesetdtos.UsuarioDTO;

/**
 *
 * @author hisam
 */
public class CreateAccountFacade implements ICreateAccountFacade{

    private CreateAccount createAccount;

    public CreateAccountFacade() {
        createAccount = new CreateAccount();
    }
    
    
    @Override
    public void sendCreateAccountForm(UsuarioDTO usauarioDatos) {
        createAccount.sendUsuarioForm(usauarioDatos);
    }
    
}
