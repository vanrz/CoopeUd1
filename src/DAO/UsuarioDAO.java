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

        usu = new Usuario();
    }

    public void AñadirUsuario() throws CaException {
        try {
            String stringSQL = "INSERT INTO Usuario VALUES (?,?,?)";
            Connection conex = ServiceLocator.getInstance().tomarConexion();//conexion
            PreparedStatement prepSta = conex.prepareStatement(stringSQL);

            prepSta.setInt(1, usu.getK_idusuario());
            prepSta.setString(2, usu.getO_rol());
            prepSta.setString(3, usu.getO_contraseña());

        } catch (SQLException e) {
            throw new CaException("UsuarioDAO", "No se creó el usuario" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
}
