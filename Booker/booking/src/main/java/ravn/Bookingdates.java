package ravn;

public class Bookingdates {
    private String checkin;
    private String checkout;

    public Bookingdates(){}

    public Bookingdates(String checkin, String checkout){
        setCheckin(checkin);
        setCheckout(checkout);
    }

    public String getCheckin() {
        return this.checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return this.checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }


}
