package com.example.Bookstore.ControllerLayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.example.Bookstore.Model.Book;
import com.example.Bookstore.Model.RestockRequest;
import com.example.Bookstore.Repository.BookRepository;
import com.example.Bookstore.ServiceLayer.BookService;

@RestController
@RequestMapping("/Book")
public class BookController {
	
	@Autowired
	private BookService bookService;

	
	@GetMapping ("/allBooks")
	public ResponseEntity<List<Book>> getBooks(){
		
		return ResponseEntity.ok(bookService.getAllBooks()) ; 
	}
	
	@PutMapping("/admin/restock")
	public ResponseEntity<?> updateStock(@RequestBody RestockRequest restockRequest) {
		Optional<Book> optionalBook = bookService.findById(restockRequest.getBookId());
        if (optionalBook.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }
        Book book=optionalBook.get();

		if (book.getTitle().contains("Limited Collectors Edition")) {
			return ResponseEntity.badRequest().body("Cannot restock the Limited Collectors Edition");
		}
		if (restockRequest.getQuantity()%10 !=0) {
			return ResponseEntity.badRequest().body("only restock in multiples of 10.");
		}
		
		bookService.updateStock(restockRequest.getBookId(), restockRequest.getQuantity());
		
		return ResponseEntity.ok().build();
	}
}
