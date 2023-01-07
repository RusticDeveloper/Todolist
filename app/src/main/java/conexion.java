import android.widget.Toast;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class conexion {
    public static void main(String[] Args) {
        System.out.print("probando coneccion");
        MongoClient mongoClient = null;
        try {
            MongoClientURI connectionString = new MongoClientURI("mongodb+srv://DDRC:C%40p0l1f3@apptest.3euu1.mongodb.net/Android?retryWrites=true&w=majority");
             mongoClient = new MongoClient(connectionString);
        } catch (UnknownError e) {
            e.printStackTrace();
        }
        if (mongoClient != null) {
            DB db = mongoClient.getDB("Android");
            MongoDatabase database = mongoClient.getDatabase("Android");
            MongoCollection<Document> collection = database.getCollection("login");
            Document myDoc = collection.find().first();
            String val =myDoc.toString();
            System.out.print(val);
        }
    }
}
