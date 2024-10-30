/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mapeomovieset.conexion;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import java.util.TimeZone;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Conexion implements IConexion {

    private static Conexion conexion;
    private MongoClient mongoClient;
    private MongoDatabase baseDatos;

    private Conexion() {
        // Constructor privado para Singleton
    }

    public static Conexion getInstance() {
        if (conexion == null) {
            conexion = new Conexion();
        }
        return conexion;
    }

    /**
     * Crea y establece una conexion con MongoDB, configurando codecs y zona horaria.
     * @return MongoDatabase instancia de la base de datos conectada
     * @throws MongoException si hay error en la conexion
     */
    @Override
    public MongoDatabase conectar() {
        try {
            // Configuracion de la conexion
            String cadenaConexion = "mongodb://127.0.0.1:27017";
            String nombreBaseDatos = "MovieSet";

            // Configurar zona horaria
            TimeZone.setDefault(TimeZone.getTimeZone("America/Hermosillo"));

            // Configurar codec registry para POJOs y fechas
            CodecRegistry pojoCodecRegistry = fromRegistries(
                    MongoClientSettings.getDefaultCodecRegistry(),
                    fromProviders(PojoCodecProvider.builder()
                            .automatic(true)
                            .build())
            );

            // Configurar ServerApi y settings completos
            ServerApi serverApi = ServerApi.builder()
                    .version(ServerApiVersion.V1)
                    .build();
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(cadenaConexion))
                    .serverApi(serverApi)
                    .codecRegistry(pojoCodecRegistry)
                    .build();

            // Crear cliente y conectar a la base de datos
            mongoClient = MongoClients.create(settings);
            baseDatos = mongoClient.getDatabase(nombreBaseDatos);

            System.out.println("Conexion establecida exitosamente a: " + nombreBaseDatos);
            return baseDatos;

        } catch (MongoException ex) {
            System.err.println("Error al conectar a MongoDB: " + ex.getMessage());
            throw ex;
        }
    }

    /**
     * Cierra la conexion con la base de datos de forma segura
     */
    @Override
    public void cerrarConexion() {
        if (mongoClient != null) {
            try {
                mongoClient.close();
                baseDatos = null;
                System.out.println("Conexion cerrada exitosamente");
            } catch (MongoException ex) {
                System.err.println("Error al cerrar la conexion: " + ex.getMessage());
                throw ex;
            }
        }
    }
}