package ie.atu.oopsem2week9.Controller;

import ie.atu.oopsem2week9.Model.Book;
import ie.atu.oopsem2week9.Service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createBook(@Valid @RequestBody Book book) {
        Book save = bookService.addRoom(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }


    @GetMapping("/Show")
    public ResponseEntity<List<Book>> showBooks(){
        return new ResponseEntity<>(bookService.getBookings(), HttpStatus.OK);
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<Book> showBook(@PathVariable long id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Book>> showBooksByDate(@PathVariable LocalDate date){
        return ResponseEntity.ok(bookService.getAllBooksByDate(date));
    }

    @GetMapping("/room/{roomId}/date/{date}")
    public  ResponseEntity<List<Book>> showBooksByRoom(@PathVariable int roomId, @PathVariable LocalDate date){
        return ResponseEntity.ok(bookService.getAllBooksByRoomNumberAndDate(roomId, date));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<Book>> showBooksByEmail(@PathVariable String email){
        return ResponseEntity.ok(bookService.getBooksbyEmail(email));
    }

    @GetMapping("/Date/{date}/Time1/{time1}/time2/{time2}")
    public ResponseEntity<List<Book>> showBooksByDate(@PathVariable LocalDate date, @PathVariable int time1, @PathVariable int time2){
        return ResponseEntity.ok(bookService.getBooksByDateAndTime(date, time1, time2));
    }

}
