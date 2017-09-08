package ba.milan.pagination.controller;

import ba.milan.pagination.model.Book;
import ba.milan.pagination.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by milanjankovic on 18/08/17.
 */
@RestController
public class PaginationController {

    private final BookService bookService;

    @Autowired
    public PaginationController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ResponseEntity getAllPaginatedBooks(Pageable pageable) {
        try {
            Page<Book> books = bookService.getAllPaginatedBooks(pageable);
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/books-search", method = RequestMethod.GET)
    public ResponseEntity getSearchedPaginatedBooks(@RequestParam("type") String queryType,
                                                    @RequestParam("search") String searchTerm,
                                                    @RequestParam("sort") String sort,
                                                    @RequestParam("page") Integer page,
                                                    @RequestParam("length") Integer length,
                                                    @RequestParam("direction") String sortDirection,
                                                    @RequestParam("authors") List<Integer> authors,
                                                    @RequestParam("genres") List<Integer> genres,
                                                    @RequestParam("periods") List<Integer> periods) {
        try {
            Page<Book> books = bookService.searchBooksWithPagination(page, length, searchTerm, genres, periods, authors, sort, sortDirection, queryType);
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
