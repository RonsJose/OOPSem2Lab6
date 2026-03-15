package ie.atu.oopsem2week9.Service;

import ie.atu.oopsem2week9.Execeptions.BookingConflictException;
import ie.atu.oopsem2week9.Execeptions.BookingNotFound;
import ie.atu.oopsem2week9.Model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();
    private long idCounter = 1;

    public Book addRoom(Book book) {
        book.setId(idCounter++);

        for(Book existingBook : books) {
            if(existingBook.getRoomNumber() == book.getRoomNumber() && Objects.equals(existingBook.getBookingDate(), book.getBookingDate())) {

                int existingStart= existingBook.getStartHour();
                int existingEnd=existingStart + existingBook.getDurationHours();

                int newStart = book.getStartHour();
                int newEnd = newStart + book.getDurationHours();

                if(existingStart< newEnd && newStart < existingEnd) {
                    book.setId(idCounter--);
                    throw new BookingConflictException("Time slot already booked");
                }
            }
        }

        books.add(book);
        return book;
    }

    public List<Book> getBookings() {
        return books;
    }

    public Book getBookById(Long id) {
        for(Book book : books) {
            if(book.getId() == id) {
                return book;
            }
        }
        throw new BookingNotFound("Book with id " + id + " not found");
    }

}
