package fon.stefan.januarski_rok.exception;

public class MyErrorDetails {
    private String message;

    public MyErrorDetails() {
    }

    public MyErrorDetails(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
