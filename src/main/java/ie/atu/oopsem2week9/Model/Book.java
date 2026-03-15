    package ie.atu.oopsem2week9.Model;

    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.validation.constraints.*;
    import lombok.*;

    import java.time.LocalDate;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @PositiveOrZero(message = "Must enter a number >= 0")
        private int roomNumber;

        @NotEmpty(message = "Must enter a email")
        @Email(message = "Must enter a valid email")
        private String studentEmail;


        @NotNull(message = "Must enter a date")
        private LocalDate bookingDate;

        @Min(value=0,message = "Value too low for start hour")
        @Max(value=23,message = "Value too high for start hour")
        private int startHour;

        @Min(value=1,message = "Value too low for duration")
        @Max(value=24,message = "Value too high for duration")
        private int durationHours;

    }
