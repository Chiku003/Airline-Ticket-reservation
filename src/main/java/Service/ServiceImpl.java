package Service;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import DAO.DaoI;
import DAO.DaoImpl;
import Repository.Flight;

public class ServiceImpl implements ServiceI
{
	Scanner ss=new Scanner(System.in);
	
	@Override
	public void addFlight() {
	    System.out.println();
	    System.out.print("Enter Admin pin: ");
	    String pin = new Scanner(System.in).nextLine();
	    if(pin.equals("1010")) {
	        System.out.println();
	        System.out.print("Enter Flight Name: ");
	        String fname = new Scanner(System.in).nextLine();

	        System.out.println();
	        System.out.print("Enter Flight No: ");
	        String fno = new Scanner(System.in).nextLine();

	        System.out.println();
	        System.out.print("Enter Date: ");
	        String date = new Scanner(System.in).nextLine();

	        System.out.println();
	        System.out.print("From Location: ");
	        String from = new Scanner(System.in).nextLine();

	        System.out.println();
	        System.out.print("To Location: ");
	        String to = new Scanner(System.in).nextLine();

	        System.out.println();
	        System.out.print("Arrival Time: ");
	        String arrival = new Scanner(System.in).nextLine();

	        System.out.println();
	        System.out.print("Departure Time: ");
	        String departure = new Scanner(System.in).nextLine();

	        // Create a new flight document
	        Flight flight =new Flight();
	        flight.setFname(fname);
	        flight.setFno(fno);
	        flight.setFrom(from);
	        flight.setTo(to);
	        flight.setDate(date);
	        flight.setArival(arrival);
	        flight.setDept(departure);
	        
	        Document flightDoc = flight.toDocument();

	        // Connect to local MongoDB instance
			try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
			    // Get the database
			    MongoDatabase database = mongoClient.getDatabase("local");

			    // Insert the single flight document into the 'flights' collection
			    database.getCollection("flights").insertOne(flightDoc);

			    System.out.println("Flight added successfully to MongoDB.");
			} catch (Exception e) {
			    System.err.println("Error connecting to MongoDB: " + e);
			}

	    } else {
	        System.out.println();
	        System.out.println("!!!Invalid Pin!!!");
	        System.out.println();
	    }
	}
	
	@Override
	public void viewFlight()
	{
		System.out.println();
        System.out.print("Enter from location");
        String fName = new Scanner(System.in).nextLine();

        System.out.println();
        System.out.print("Enter to location");
        String tName = new Scanner(System.in).nextLine();
		
		
		Flight p = new Flight();
		
		
		DaoI di=new DaoImpl();
		
		di.viewFlight(fName,tName);
		
	}


	@Override
	public void bookFlight() {
		System.out.println();
		System.out.print("Enter Passenger Name: ");
		String pname=null;
		try {
			 pname=new DataInputStream(System.in).readLine();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
		System.out.println();
		System.out.print("Enter Passport No: ");
		String pno=new Scanner(System.in).nextLine();
		
		System.out.println();
		System.out.print("Enter Flight No: ");
		String fno=new Scanner(System.in).nextLine();
		
		String st="Booked";
		
		Flight p=new Flight();
		p.setPname(pname);
		p.setPno(pno);
		p.setFno(fno);
		p.setStatus(st);
		
		DaoI di=new DaoImpl();
		di.bookFlight(p);
		
		
	}

	@Override
	public void cancelFlight() 
	{
		System.out.println();
		System.out.print("Enter Passport No: ");
		String pno=new Scanner(System.in).nextLine();
		
		System.out.println();
		System.out.print("Enter Flight No: ");
		String fno=new Scanner(System.in).nextLine();
		
		String st="Canceled";
		
		Flight p=new Flight();
		
		p.setPno(pno);
		p.setFno(fno);
		p.setStatus(st);
		DaoI di=new DaoImpl();
		di.cancelFlight(p);
	}

	@Override
	public void viewBooking()
	{
		System.out.println();
		System.out.print("Enter Passport No: ");
		String pno = new Scanner(System.in).nextLine();
		Flight p=new Flight();
		p.setPno(pno);
		DaoI di=new DaoImpl();
		di.viewBooking(p);
		
	}

}
