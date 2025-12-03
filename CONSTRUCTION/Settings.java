public class Settings {
    private UserType userType;
    private PaymentType paymentType;


    public Settings(UserType userType, PaymentType paymentType) {
        this.userType = userType;
        this.paymentType = paymentType;
    }


    public UserType getUserType() { return userType; }
    public void setUserType(UserType userType) { this.userType = userType; }


    public PaymentType getPaymentType() { return paymentType; }
    public void setPaymentType(PaymentType paymentType) { this.paymentType = paymentType; }
}