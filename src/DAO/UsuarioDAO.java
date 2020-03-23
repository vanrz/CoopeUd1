/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import util.CaException;
import util.ServiceLocator;
import java.sql.*;

import negocio.Usuario;

/**
 *
 * @author vanRz
 */
public class UsuarioDAO {
    
    Usuario usu;

    public UsuarioDAO() {
        
        usu= new Usuario();
    }
    
    
}
