package ie.atu.oopsem2week9.Execeptions;

public class BookingConflictException extends RuntimeException{
    public BookingConflictException(String message){
        super(message);
    }
}