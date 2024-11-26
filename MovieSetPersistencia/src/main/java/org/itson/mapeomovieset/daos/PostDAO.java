/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mapeomovieset.daos;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import org.itson.entidades.PostEntity;
import org.itson.mapeomovieset.conexion.Conexion;
import org.itson.mapeomovieset.conexion.IConexion;
import org.itson.mapeomovieset.excepciones.FindException;
import org.itson.mapeomovieset.excepciones.PersistenciaException;

/**
 *
 * @author hisam
 */
public class PostDAO implements IPostDAO{

    private final IConexion conexion;
    private MongoCollection<PostEntity> post;

    public PostDAO() {
        this.conexion = Conexion.getInstance(); 
        MongoDatabase baseDeDatos = conexion.conectar();
        this.post = baseDeDatos.getCollection("Post", PostEntity.class);
    }
    
    @Override
    public boolean agregarComentario(PostEntity post) throws PersistenciaException {
        try {
            InsertOneResult result = this.post.insertOne(post);
            return result.wasAcknowledged();
        } catch (MongoException ex) {
            throw new PersistenciaException("Error al crear Post");
        }
    }
    
}
