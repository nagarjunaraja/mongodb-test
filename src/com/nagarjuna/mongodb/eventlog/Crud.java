package com.nagarjuna.mongodb.eventlog;

import java.util.Scanner;

import org.bson.Document;


import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;

public class Crud {

	public static void createCollection(MongoDatabase db){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter name of the collection");
		String collection = scan.next();
		db.createCollection(collection);
		System.out.println("Collection "+collection+" created");
		scan.close();	
	}
	
	public static void retrieve(String collection,MongoDatabase db){
		
		MongoCollection<Document> coll = db.getCollection(collection);			
		MongoCursor<Document> cursor = coll.find().iterator();
			
        while (cursor.hasNext()) {  
           System.out.println(cursor.next());         
        }
        
	}
	
	public static void insert(MongoDatabase db, String collection){
		MongoCollection<Document> coll = db.getCollection(collection);
		Scanner scan = new Scanner(System.in);
		System.out.println("enter id");
		String id = scan.nextLine();
		System.out.println("enter name");
		String name = scan.nextLine();
		System.out.println("enter designation");
		String designation = scan.nextLine();
		Document document = new Document("_id", id)
                .append("name", name)
                .append("designation", designation);
                
		coll.insertOne(document);
		//System.out.println(result.getUpsertedId());
		System.out.println("Document inserted successfully");
		scan.close();
	}
	
	public static void update(String col,MongoDatabase db){

		Document q = new Document("_id", "NS1272")
                .append("name", "Siva Sai")
                .append("designation", "PAT");
		Document n = new Document("$set",new Document("designation","Associate"));
		
		MongoCollection<Document> coll = db.getCollection(col);
		UpdateResult ur = coll.updateOne(q, n);
		System.out.println("Record updated " + ur);
	}
	
	public static void delete(String col,MongoDatabase db){ 
		
		MongoCollection<Document> collection = db.getCollection(col);
		collection.drop();
		
		
	}
}
