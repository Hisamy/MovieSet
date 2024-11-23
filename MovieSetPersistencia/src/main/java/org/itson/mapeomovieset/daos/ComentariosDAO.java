/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mapeomovieset.daos;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import org.itson.entidades.ComentarioEntity;
import org.itson.mapeomovieset.conexion.Conexion;
import org.itson.mapeomovieset.conexion.IConexion;
import org.itson.mapeomovieset.excepciones.PersistenciaException;

/**
 *
 * @author castr
 */
public class ComentariosDAO implements IComentariosDAO {

    private final IConexion conexion;
    private MongoCollection<ComentarioEntity> comentarios;

    public ComentariosDAO() {
        this.conexion = Conexion.getInstance(); 
        MongoDatabase baseDeDatos = conexion.conectar();
        this.comentarios = baseDeDatos.getCollection("Comentarios", ComentarioEntity.class);
    }

    @Override
    public boolean agregarComentario(ComentarioEntity comentario) throws PersistenciaException {
        try {
            InsertOneResult result = comentarios.insertOne(comentario);
            return result.wasAcknowledged();
        } catch (MongoException ex) {
            throw new PersistenciaException("Error al crear el comentario");
        }
    }
}
