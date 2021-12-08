package com.nagarjuna.mongodb.adapter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import org.bson.Document;
import org.codehaus.jackson.map.ObjectMapper;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public class MongoAdapter {

	public MongoDatabase db = null;
	public MongoClient mongoClient = null;

	// returns the connected Database(MongoDatabase)
	public MongoDatabase Connection() {
		Properties props = new Properties();
		FileInputStream fis = null;

		try {
			fis = new FileInputStream("Connection.properties");
			props.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String host = props.getProperty("MONGO_HOST");
		int port = Integer.parseInt(props.getProperty("MONGO_PORT"));
		String database = props.getProperty("MONGO_DATABASE");
		mongoClient = new MongoClient(host, port);
		db = mongoClient.getDatabase(database);
		System.out.println("Connected to the " + database + " Database");
		return db;
	}

	// Create a Collection
	public void createCollection(MongoDatabase db) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter name of the collection");
		String collection = scan.next();
		db.createCollection(collection);
		System.out.println("Collection " + collection + " created");
		scan.close();
	}

	// Retrieve all records
	public ArrayList<Employee> readAllRecords(String collection,
			MongoDatabase db) {

		MongoCollection<Document> coll = db.getCollection(collection);
		MongoCursor<Document> cursor = coll.find().iterator();
		ArrayList<Employee> al = new ArrayList<Employee>();

		while (cursor.hasNext()) {
			Employee emp = new Employee();
			Document d = cursor.next();
			emp.set_id(d.getString("_id"));
			emp.setName(d.getString("name"));
			emp.setDesignation(d.getString("designation"));
			al.add(emp);
		}

		return al;
	}

	// insert a document
	public void insert(MongoDatabase db, String collection, Employee emp) {
		MongoCollection<Document> coll = db.getCollection(collection);
		ObjectMapper objMapper = new ObjectMapper();

		try {
			String jsonString = objMapper.writeValueAsString(emp);
			Document doc = Document.parse(jsonString);
			coll.insertOne(doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Document inserted successfully");
	}

	// Search for a document
	public FindIterable<Document> search(MongoDatabase db, String collection,
			String fieldName, String fieldValue) {
		MongoCollection<Document> coll = db.getCollection(collection);
		BasicDBObject query = new BasicDBObject();
		query.append(fieldName, fieldValue);
		FindIterable<Document> fi = coll.find(query);
		return fi;
	}

	// Update a specific record
	public boolean update(MongoDatabase db, String collection, Employee emp) {

		Document filter = new Document();
		filter.append("_id", emp.get_id());
		MongoCollection<Document> coll = db.getCollection(collection);
		ObjectMapper objMapper = new ObjectMapper();
		String jsonString;
		UpdateResult ur = null;
		try {
			jsonString = objMapper.writeValueAsString(emp);
			Document doc = Document.parse(jsonString);
			ur = coll.replaceOne(filter, doc);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ur.wasAcknowledged();
	}

	// Delete a specific record
	public Boolean delete(MongoDatabase db, String col, String fieldName,
			String fieldValue) {

		MongoCollection<Document> collection = db.getCollection(col);
		Document doc = new Document(fieldName, fieldValue);
		DeleteResult res = collection.deleteOne(doc);
		return res.wasAcknowledged();
	}

	// Close a connection
	public void close() {
		mongoClient.close();
		System.out.println("Connection Closed");
	}
}
