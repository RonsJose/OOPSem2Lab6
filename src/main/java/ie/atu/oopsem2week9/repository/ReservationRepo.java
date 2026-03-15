package ie.atu.oopsem2week9.repository;

import ie.atu.oopsem2week9.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepo extends JpaRepository<Book, Long> {
    List<Book> findByBookingDate(LocalDate bookingDate);
    List<Book> findByBookingDateBetween(LocalDate startDate, LocalDate endDate);
    List<Book> findByRoomNumberAndDate(Long bookingNumber, LocalDate date);
}
