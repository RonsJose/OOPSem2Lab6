package ie.atu.oopsem2week9.Service;

import ie.atu.oopsem2week9.Execeptions.BookingConflictException;
import ie.atu.oopsem2week9.Execeptions.BookingNotFound;
import ie.atu.oopsem2week9.Model.Book;
import ie.atu.oopsem2week9.repository.ReservationRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BookService {
    private List<Book> books;
    private final ReservationRepo reservationRepository;

    public BookService(ReservationRepo reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Book addRoom(Book book) {

       books = reservationRepository.findAll();

        for(Book existingBook : books) {
            if(existingBook.getRoomNumber() == book.getRoomNumber() && Objects.equals(existingBook.getBookingDate(), book.getBookingDate())) {

                int existingStart= existingBook.getStartHour();
                int existingEnd=existingStart + existingBook.getDurationHours();

                int newStart = book.getStartHour();
                int newEnd = newStart + book.getDurationHours();

                if(existingStart< newEnd && newStart < existingEnd) {
                    throw new BookingConflictException("Time slot already booked");
                }
            }
        }
        reservationRepository.save(book);
        return book;
    }

    public List<Book> getBookings() {
        return reservationRepository.findAll();
    }

    public Book getBookById(Long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new BookingNotFound("Book with id " + id + " not found"));
    }

    public List<Book> getAllBooksByDate(LocalDate bookingDate) {
        return reservationRepository.findByBookingDate(bookingDate);
    }

    public List<Book> getAllBooksByRoomNumberAndDate(Long bookingNumber, LocalDate bookingDate) {
        return reservationRepository.findByRoomNumberAndDate(bookingNumber, bookingDate);
    }

}
