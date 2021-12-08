package com.nagarjuna.mongodb.eventlog;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class EventLogDB {
	
	public static void main(String[] args) {
		
		MongoClient client = new MongoClient();
		MongoDatabase database = client.getDatabase("occ_mongo");
		MongoCollection<Document> collection = database.getCollection("event_logs");
		
		// insert a document
		Document document = new Document("LogName", "Application");
		document.append("EventId",100);
		document.append("Entry Type", "Error");
		
		collection.insertOne(document);
				
		// replace a document
		collection.replaceOne(Filters.eq("_id", document.get("_id")), document);
		
		// find documents
		List<Document> foundDocument = collection.find().into(new ArrayList<Document>());
		System.out.println(foundDocument.size());
	}

}
