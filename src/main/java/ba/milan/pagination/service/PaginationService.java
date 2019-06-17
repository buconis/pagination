package ba.milan.pagination.service;

import ba.milan.pagination.model.Book;

import java.util.List;

/**
 * Created by milan jankovic on 18/08/17.
 */
public interface PaginationService {
    List<Book> getPaginatedListOfBooks();

}
