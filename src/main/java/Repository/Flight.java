package Repository;

import org.bson.Document;

public class Flight {
    private String fname;
    private String fno;
    private String from;
    private String to;
    private String date;
    private String pname;
    private String status;
    private String arival;
    private String dept;
    private String pno;
	

    // Getters and Setters for all fields
    // For brevity, I'm showing only one example getter and setter

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFno() {
        return fno;
    }

    public void setFno(String fno) {
        this.fno = fno;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getArival() {
        return arival;
    }

    public void setArival(String arival) {
        this.arival = arival;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
    public String getPno() {
		return pno;
	}
	public void setPno(String pno2) {
		this.pno = pno2;
	}

    // Convert the Flight object to a MongoDB Document
	public Document toDocument() {
	    Document document = new Document();
	    
	    if (this.fname != null) document.append("fname", this.fname);
	    if (this.fno != null) document.append("fno", this.fno);
	    if (this.from != null) document.append("from", this.from);
	    if (this.to != null) document.append("to", this.to);
	    if (this.date != null) document.append("date", this.date);
	    if (this.pname != null) document.append("pname", this.pname);
	    if (this.status != null) document.append("status", this.status);
	    if (this.arival != null) document.append("arival", this.arival);
	    if (this.dept != null) document.append("dept", this.dept);
	    
	    return document;
	}
	
	@Override
	public String toString() {
	    return "Flight{ " +
	            "fname='" + fname + '\'' +
	            ", fno='" + fno + '\'' +
	            ", from='" + from + '\'' +
	            ", to='" + to + '\'' +
	            ", date='" + date + '\'' +
	            ", pname='" + pname + '\'' +
	            ", status='" + status + '\'' +
	            ", arrival='" + arival + '\'' +
	            ", departure='" + dept + '\'' +
	            ", pno='" + pno + '\'' +
	            " }";
	}


}

