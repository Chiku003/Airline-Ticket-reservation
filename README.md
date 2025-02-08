# Airline Ticket Reservation System ✈️  

## **Project Description**  
The **Airline Ticket Reservation System** is a console-based Java application that allows users to **add flights, view flights, book tickets, cancel bookings, and check booking details**. The project is built using:  

- **Java** (Core Java for logic)  
- **MongoDB** (For database storage)  
- **Maven** (For dependency management)  

## **Features**  
✅ Add flight details  
✅ View available flights  
✅ Book flight tickets  
✅ Cancel a flight booking  
✅ View booking details  

## **Technologies Used**  
- **Programming Language:** Java  
- **Database:** MongoDB  
- **Build Tool:** Maven  

## **Installation & Setup**  

### **1. Clone the Repository**  
```sh  
git clone https://github.com/Chiku003/Airline-Ticket-reservation.git  
cd Airline-Ticket-reservation  
```

### **2. Install Dependencies**  
Make sure you have **Maven** installed. If not, install it from [Maven's official website](https://maven.apache.org/download.cgi). Then, run:  

```sh  
mvn clean install  
```

### **3. Set Up MongoDB**  
1. Install MongoDB and start the service.  
2. Create a database named **`airline_reservation`**.  
3. Create a collection named **`flights`**.  

You can start MongoDB and access it using:  
```sh  
mongod  # Starts MongoDB  
mongo   # Opens MongoDB shell  
```

### **4. Run the Application**  
Compile and run the program:  

```sh  
mvn exec:java -Dexec.mainClass="com.rd.atrs.flight_booking.App"  
```

## **Usage**  
When you run the application, the menu will appear:  

```
======= Airline Reservation System =======  
1. Add Flight  
2. View Flight  
3. Book Flight  
4. Cancel Booking  
5. Booking Details  
6. Quit  

Enter your choice:  
```
Simply follow the on-screen instructions to interact with the system.

## **Project Structure**  

```
Airline-Ticket-Reservation/  
│—— src/  
│   ├—— main/java/com/rd/atrs/flight_booking/  
│   │   ├—— App.java  
│   │   ├—— service/  
│   │   │   ├—— ServiceI.java  
│   │   │   ├—— ServiceImpl.java  
│   └—— test/java/  # Unit tests  
│—— pom.xml  # Maven dependencies  
│—— README.md  # Project documentation  
```

## **Contributing**  
Feel free to fork the repository, create a feature branch, and submit a pull request! 🚀  

## **License**  
This project is licensed under the **MIT License**.  

## **Author**  
👨‍💻 **Chiku003** (GitHub: [@Chiku003](https://github.com/Chiku003))

