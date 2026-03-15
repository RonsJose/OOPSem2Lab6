package ie.atu.oopsem2week9.Model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private long id;

    @PositiveOrZero(message = "Must enter a number >= 0")
    @NotEmpty(message = "Must enter a room number")
    private int roomNumber;

    @NotEmpty(message = "Must enter a email")
    @Email(message = "Must enter a valid email")
    private String studentEmail;


    @NotNull(message = "Must enter a date")
    private String bookingDate;

    @Min(value=0,message = "Value too low for start hour")
    @Max(value=23,message = "Value too high for start hour")
    private int startHour;

    @Min(value=1,message = "Value too low for duration")
    @Max(value=24,message = "Value too high for duration")
    private int durationHours;

}
