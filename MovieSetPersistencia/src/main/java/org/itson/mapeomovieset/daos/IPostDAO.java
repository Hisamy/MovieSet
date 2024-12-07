package org.itson.mapeomovieset.daos;

import java.util.List;
import org.bson.types.ObjectId;
import org.itson.entidades.PostEntity;
import org.itson.mapeomovieset.excepciones.FindException;
import org.itson.mapeomovieset.excepciones.PersistenciaException;

/**
 *
 * @author hisam
 */
public interface IPostDAO {

    boolean agregarPost(PostEntity post) throws PersistenciaException;

    boolean eliminarPost(ObjectId idPost) throws PersistenciaException;
    
    List<PostEntity> consultarPosts() throws FindException;
}
