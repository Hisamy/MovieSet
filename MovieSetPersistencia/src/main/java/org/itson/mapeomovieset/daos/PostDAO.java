/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mapeomovieset.daos;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.itson.entidades.PostEntity;
import org.itson.mapeomovieset.conexion.Conexion;
import org.itson.mapeomovieset.conexion.IConexion;
import org.itson.mapeomovieset.excepciones.FindException;
import org.itson.mapeomovieset.excepciones.PersistenciaException;

/**
 *
 * @author hisam
 */
public class PostDAO implements IPostDAO {

    private final IConexion conexion;
    private MongoCollection<PostEntity> post;

    public PostDAO() {
        this.conexion = Conexion.getInstance();
        MongoDatabase baseDeDatos = conexion.conectar();
        this.post = baseDeDatos.getCollection("Post", PostEntity.class);
    }

    @Override
    public boolean agregarPost(PostEntity post) throws PersistenciaException {
        try {
            InsertOneResult result = this.post.insertOne(post);
            return result.wasAcknowledged();
        } catch (MongoException ex) {
            throw new PersistenciaException("Error al crear Post");
        }
    }

    @Override
    public boolean eliminarPost(ObjectId idPost) throws PersistenciaException {
        try {
            DeleteResult result = post.deleteOne(Filters.eq("_id", idPost));
            return result.wasAcknowledged();
        } catch (MongoException ex) {
            throw new PersistenciaException("Error al eliminar Post");
        }
    }

    @Override
    public List<PostEntity> consultarPosts() throws FindException {
        try {
            return post.find().into(new ArrayList<>());
        } catch (MongoException ex) {
            throw new FindException("Error al consultar los posts", ex);
        }
    }

}
