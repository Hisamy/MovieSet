package org.itson.mapeomovieset.daos;

import org.bson.types.ObjectId;
import org.itson.entidades.PostEntity;
import org.itson.mapeomovieset.excepciones.PersistenciaException;

/**
 *
 * @author hisam
 */
public interface IPostDAO {

    boolean agregarComentario(PostEntity post) throws PersistenciaException;

    boolean eliminarComentario(ObjectId idPost) throws PersistenciaException;
}
