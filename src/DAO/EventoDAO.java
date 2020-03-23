/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import negocio.Evento;

import negocio.Asociado;
import util.CaException;
import util.ServiceLocator;
import java.sql.*;

/**
 *
 * @author vanRz
 */
public class EventoDAO {

    Evento evt;

    public EventoDAO() {

        evt = new Evento();
    }

    public void AñadirEvento() throws CaException {
        try {
            String stringSQL = "INSERT INTO evento VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            Connection conex = ServiceLocator.getInstance().tomarConexion();//conexion
            PreparedStatement prepSta = conex.prepareStatement(stringSQL);

            prepSta.setInt(1, evt.getK_evento());
            prepSta.setString(2, evt.getI_estado());
            prepSta.setString(3, evt.getI_sobrecupo());
            prepSta.setString(4, evt.getF_inicio());//yyyy-mm-dd
            prepSta.setString(5, evt.getF_fin());//yyyy-mm-dd
            prepSta.setString(6, evt.getF_maxins());//yyyy-mm-dd
            prepSta.setString(7, evt.getF_maxcancel());//yyyy-mm-dd
            prepSta.setString(8, evt.getF_cierre());//yyyy-mm-dd
            prepSta.setString(9, evt.getI_tieneins());
            prepSta.setInt(10, evt.getV_total());
            prepSta.setString(11, evt.getN_lugar());
            prepSta.setString(12, evt.getN_descripcion());
            prepSta.setString(13, evt.getN_nombre());
            prepSta.setString(14, evt.getO_observaciones());
            prepSta.setInt(15, evt.getQ_maxpart());

        } catch (SQLException e) {
            throw new CaException("EventoDAO", "No se creó el evento" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }

    }

    public void buscarEvento() throws CaException {
        try {
            String stringSQL = "SELECT * FROM evento WHERE k_evento = ?";//busqueda en sql
            Connection conex = ServiceLocator.getInstance().tomarConexion();//conexion
            PreparedStatement prepSta = conex.prepareStatement(stringSQL);//prepara la busqueda del sql

            prepSta.setInt(1, evt.getK_evento());//reemplaza el interrogante por el valor

            ResultSet resultado = prepSta.executeQuery();//ejecuta el query y guarda el resultado

            while (resultado.next()) {

                evt.setK_evento(resultado.getInt(1));
                evt.setI_estado(resultado.getString(2));
                evt.setI_sobrecupo(resultado.getString(3));
                Date f_inicio = resultado.getDate(4);
                evt.setF_inicio(f_inicio.toString());//yyyy-mm-dd
                Date f_fin = resultado.getDate(5);
                evt.setF_fin(f_fin.toString());//yyyy-mm-dd
                Date f_maxins = resultado.getDate(6);
                evt.setF_maxins(f_maxins.toString());//yyyy-mm-dd
                Date f_maxcancel = resultado.getDate(7);
                evt.setF_maxcancel(f_maxcancel.toString());//yyyy-mm-dd
                Date f_cierre = resultado.getDate(8);
                evt.setF_cierre(f_cierre.toString());//yyyy-mm-dd
                evt.setI_tieneins(resultado.getString(9));
                evt.setV_total(resultado.getInt(10));
                evt.setN_lugar(resultado.getString(11));
                evt.setN_descripcion(resultado.getString(12));
                evt.setN_nombre(resultado.getString(13));
                evt.setO_observaciones(resultado.getString(14));
                evt.setQ_maxpart(resultado.getInt(15));

            }

        } catch (SQLException e) {
            throw new CaException("EventoDAO", "No se encontró el evento" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void borrarEvento() throws CaException {
        try {
            String stringSQL = "DELETE FROM evento WHERE k_evento= ?";//busqueda en sql
            Connection conex = ServiceLocator.getInstance().tomarConexion();//conexion
            PreparedStatement prepSta = conex.prepareStatement(stringSQL);//prepara la busqueda del sql

            prepSta.setInt(1, evt.getK_evento());

            prepSta.executeUpdate();
            prepSta.close();

            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("EventoDAO", "No se eliminó el evento" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

}
