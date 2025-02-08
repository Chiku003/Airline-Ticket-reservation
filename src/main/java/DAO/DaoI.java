package DAO;

import Repository.Flight;

public interface DaoI 
{
	void addFlight(Flight p);
	void viewFlight(String fName,String toName);
	void bookFlight(Flight p);
	void cancelFlight(Flight p);
	void viewBooking(Flight p); 
}
