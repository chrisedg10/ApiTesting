package ravn;

public class Booking {
    private String firstname;
    private String lastname;
    private String totalprice;
    private Boolean depositpaid;
    private Bookingdates bookingdates;
    private String additionalneeds;

    public Booking(){}

    //Used for POST requests
    public Booking(String firstname, String lastname, String totalprice, Boolean depositpaid, Bookingdates bookingdates, String additionalneeds){
        setFirstname(firstname);
        setLastname(lastname);
        setTotalprice(totalprice);
        setDepositpaid(depositpaid);
        setBookingdates(bookingdates);
        setAdditionalneeds(additionalneeds);
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTotalprice() {
        return this.totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public Boolean getDepositpaid() {
        return this.depositpaid;
    }

    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public Bookingdates getBookingdates() {
        return this.bookingdates;
    }

    public void setBookingdates(Bookingdates bookingdates) {
        this.bookingdates = bookingdates;
    };

    public String getAdditionalneeds() {
        return this.additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }


}
