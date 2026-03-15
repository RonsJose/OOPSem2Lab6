package ie.atu.oopsem2week9.Execeptions;

public class BookingNotFound extends RuntimeException{
    public BookingNotFound(String message){
        super(message);
    }
}
