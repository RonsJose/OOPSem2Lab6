package ie.atu.oopsem2week9.repository;

import ie.atu.oopsem2week9.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ReservationRepo extends JpaRepository<Book, Long> {
    List<Book> findByBookingDate(LocalDate bookingDate);
    List<Book> findByRoomNumberAndBookingDate(Long bookingNumber, LocalDate bookingDate);

    List<Book> findByBookingDateAndStartHour(LocalDate bookingDate, int StartTime, int EndTime);
    List<Book> findByStudentEmail(String studentEmail);
}
