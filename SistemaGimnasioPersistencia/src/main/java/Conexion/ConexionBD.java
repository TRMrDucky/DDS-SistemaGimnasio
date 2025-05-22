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
 * Clase encargada de gestionar la conexión a la base de datos MongoDB.
 * Implementa el patrón Singleton para garantizar una única instancia del cliente.
 * 
 * La base de datos utilizada se llama "gimnasio" y se conecta al servidor MongoDB 
 * en localhost en el puerto 27017.
 * 
 * Se utiliza un codec personalizado para permitir el uso de POJOs (Plain Old Java Objects).
 * 
 * @author Laboratorios
 */
public class ConexionBD {

    /** Cliente MongoDB usado para conectarse a la base de datos. */
    private static MongoClient mongoClient = null;

    /** URL de conexión al servidor MongoDB. */
    private static final String URL = "mongodb://localhost:27017";

    /** Nombre de la base de datos a utilizar. */
    private static final String DATA_BASE_NAME = "gimnasio";

    /**
     * Constructor vacío.
     * No realiza ninguna acción ya que esta clase gestiona la conexión de forma estática.
     */
    public ConexionBD() {
    }

    /**
     * Obtiene una instancia de la base de datos MongoDB.
     * 
     * Si aún no existe una conexión, se crea una nueva con un registro de codecs
     * que permite trabajar con objetos Java (POJOs). Si ya existe, se reutiliza la conexión.
     * 
     * @return Una instancia de {@link com.mongodb.client.MongoDatabase} conectada a la base "gimnasio".
     */
    public static MongoDatabase getInstance() {
        if (mongoClient == null) {
            // Registro de codecs para permitir el mapeo automático de POJOs
            CodecRegistry pojo = CodecRegistries.fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
            );

            // Configuración del cliente con la URL de conexión y el codec registry
            MongoClientSettings clienteSettings = MongoClientSettings.builder()
                .applyConnectionString(new com.mongodb.ConnectionString(URL))
                .codecRegistry(pojo)
                .build();

            // Creación del cliente
            mongoClient = MongoClients.create(clienteSettings);

            // Retorna la base de datos con los codecs configurados
            return mongoClient.getDatabase(DATA_BASE_NAME).withCodecRegistry(pojo);
        }

        // Si el cliente ya fue creado, retorna la base directamente
        return mongoClient.getDatabase(DATA_BASE_NAME);
    }
}
