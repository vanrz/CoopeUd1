/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import negocio.Proveedor;

import negocio.Asociado;
import util.CaException;
import util.ServiceLocator;
import java.sql.*;

/**
 *
 * @author vanRz
 */
public class ProveedorDAO {
    Proveedor prov;

    public ProveedorDAO() {
        prov=new Proveedor();
    }
    
    
    
}
