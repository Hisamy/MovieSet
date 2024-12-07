/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mapeomovieset.daos;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.types.ObjectId;
import org.itson.entidades.ComentarioEntity;
import org.itson.entidades.PostEntity;
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
    private MongoCollection<PostEntity> posts;

    public ComentariosDAO() {
        this.conexion = Conexion.getInstance(); 
        MongoDatabase baseDeDatos = conexion.conectar();
        this.comentarios = baseDeDatos.getCollection("Comentarios", ComentarioEntity.class);
        this.posts = baseDeDatos.getCollection("Post", PostEntity.class);
    }

    @Override
    public boolean agregarComentario(ComentarioEntity comentario, String postId) throws PersistenciaException {
        try {
            // Primero, insertar el comentario
            InsertOneResult resultComentario = comentarios.insertOne(comentario);
            
            if (!resultComentario.wasAcknowledged()) {
                return false;
            }

            // Obtener el ID del comentario insertado
            ObjectId comentarioId = resultComentario.getInsertedId().asObjectId().getValue();

            // Actualizar el post para agregar la referencia al comentario
            UpdateResult resultPost = posts.updateOne(
                Filters.eq("_id", new ObjectId(postId)),
                Updates.push("comentarios", comentarioId)
            );

            return resultPost.getModifiedCount() > 0;
        } catch (MongoException ex) {
            throw new PersistenciaException("Error al crear el comentario: " + ex.getMessage());
        }
    }
}
