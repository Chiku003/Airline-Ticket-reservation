package DAO;
import java.util.*;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import Repository.Flight;



public class DaoImpl implements DaoI
{
	static HashMap<String, Object> h=new HashMap<String, Object>();
	
	static HashMap<String, Object> h1=new HashMap<String, Object>();
	
	@Override
	public void addFlight(Flight p) 
	{
		h.put(p.getFno(), p);
		System.out.println();
		System.out.println("!!!Flight Added Sucessfully!!!");
		System.out.println();
		
	}

	@Override
	public void viewFlight(String fName,String toName) 
	{
		System.out.println("Inside View Flight");
		// Connect to local MongoDB instance
	    try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
	        // Get the database
	        MongoDatabase database = mongoClient.getDatabase("local");

	        // Get the flights collection
	        MongoCollection<Document> collection = database.getCollection("flights");
	        
	        System.out.println("Collection is :"+collection);

	        // Create the query to search for matching 'from' and 'to' fields
	        Bson filter = Filters.and(
	            Filters.eq("from", fName),
	            Filters.eq("to", toName)
	        );
	        System.out.println("filter is :"+filter);

	        // Retrieve the matching documents
	        FindIterable<Document> documents = collection.find(filter);
	        
	        System.out.println("Document is :"+documents);

	        // Process the results
	        for (Document doc : documents) {
	            // Convert each document to a Flight object (using a method to map the document)
	            Flight flight = convertDocumentToFlight(doc);
	            System.out.println("Flight details: " + flight);
	        }
	    } catch (Exception e) {
	        System.err.println("Error connecting to MongoDB: " + e);
	    }
		
		
		
		
		
		
		
//		Iterator<String> ii = h.keySet().iterator();
//		
//		if(ii.hasNext()) {
//			
//		while(ii.hasNext())
//		{
//					String k=ii.next();
//					
//					Flight p1=(Flight)h.get(k);
//					
//					System.out.println();
//					System.out.println("=================Flight Details======================");
//					System.out.println("Flight No:"+p1.getFno()+"\tFlight Name:"+p1.getFname());
//					System.out.println("From:"+p1.getFrom()+"\tTo:"+p1.getTo()+"\tDate:"+p1.getDate());
//					System.out.println("Arival time:"+p1.getArival()+"\tDeparature Time:"+p1.getDept());
//					System.out.println("=====================================================");
//					System.out.println();
//		}
//		}
//		else
//		{
//			System.out.println();
//			System.out.println("!!!No Flights Available!!!");
//			System.out.println();
//		}
		
	}
	
	private Flight convertDocumentToFlight(Document doc) {
	    Flight flight = new Flight();
	    flight.setFname(doc.getString("fname"));
	    flight.setFno(doc.getString("fno"));
	    flight.setFrom(doc.getString("from"));
	    flight.setTo(doc.getString("to"));
	    flight.setDate(doc.getString("date"));
	    flight.setArival(doc.getString("arival"));
	    flight.setDept(doc.getString("dept"));
	    return flight;
	}
	
	
	@Override
	public void bookFlight(Flight p) 
	{
		String fn1=p.getFno();
		Iterator<String> ii=h.keySet().iterator();
		boolean b=false;
		while(ii.hasNext())
		{
					String k=ii.next();
					Flight p1=(Flight)h.get(k);
					String fn2=p1.getFno();
					if(fn1.equalsIgnoreCase(fn2))
					{
						b=true;
					}
		}
		if(b)
		{
		h1.put(p.getPno(), p);
		System.out.println();
		System.out.println("!!!Flight Booked Sucessfully!!!");
		System.out.println();
		}
		else
		{
			System.out.println();
			System.out.println("!!!Flight Number Doesn't Exist!!!");
			System.out.println();
		}
		
	}

	@Override
	public void cancelFlight(Flight p) 
	{
		Iterator<String> ii=h1.keySet().iterator();
		if(ii.hasNext())
		{
		while(ii.hasNext())
		{
			String k=ii.next();
			if(k.equals(p.getPno())||k==p.getPno())
			{
				Flight p1=(Flight)h1.get(k);
				System.out.println();
				System.out.println("====================Booking Details======================");
				System.out.println("\tFlight No:"+p1.getFno()+"\tPassenger Name:"+p1.getPname());
				System.out.println("\tStatus:"+p.getStatus());
				System.out.println("=========================================================");
				System.out.println();
				h1.remove(p.getPno());
				break;
			}
			else
			{
				System.out.println();
				System.out.println("!!!No Flight Booked at this Passport number!!!");
				System.out.println();
			}
		
			
		}
		}
		else
		{
			System.out.println();
			System.out.println("!!!No Flight Booked at this Passport number!!!");
			System.out.println();
		}
		
	}

	@Override
	public void viewBooking(Flight p) 
	{
		Iterator<String> ii=h1.keySet().iterator();
		if(ii.hasNext())
		{
		while(ii.hasNext())
		{
			String k=ii.next();
			if(k.equals(p.getPno())||k==p.getPno())
			{
				
				Flight p1=(Flight)h1.get(k);
				System.out.println();
				System.out.println("====================Booking Details======================");
				System.out.println("Passenger Name:"+p1.getPname()+"\tFlight No:"+p1.getFno());
				System.out.println("\tStatus:"+p1.getStatus());
				System.out.println("=========================================================");
				System.out.println();
				}
			else {
				System.out.println();
				System.out.println("!!!No Flight Booked at this Passport number!!!");
				System.out.println();
			}
				
			
			
		}
		}
		else {
			System.out.println();
			System.out.println("!!!No Flight Booked at this Passport number!!!");
			System.out.println();
		}
		
		
	}

}
