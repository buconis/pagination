package ba.milan.pagination.service;

import ba.milan.pagination.model.Book;

import java.util.List;

/**
 * Created by milanjankovic on 18/08/17.
 */
public interface PaginationService {
    List<Book> getPaginatedListOfBooks();

}
