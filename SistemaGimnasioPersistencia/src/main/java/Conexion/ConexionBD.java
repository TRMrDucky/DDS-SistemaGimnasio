/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author Laboratorios
 */
public class ConexionBD {
    private static MongoClient mongoClient = null;
    private static final String URL = "mongodb://localhost:27017";
    private static final String DATA_BASE_NAME = "gimnasio";

    public ConexionBD() {
    }
    
    public static MongoDatabase getInstance(){
        if(mongoClient == null){
            CodecRegistry pojo = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
            MongoClientSettings clienteSettings = MongoClientSettings.builder().applyConnectionString(new com.mongodb.ConnectionString(URL)).codecRegistry(pojo).build();
            mongoClient = MongoClients.create(clienteSettings);
            return mongoClient.getDatabase(DATA_BASE_NAME).withCodecRegistry(pojo);
        }
        
        return mongoClient.getDatabase(DATA_BASE_NAME);
    }
}
