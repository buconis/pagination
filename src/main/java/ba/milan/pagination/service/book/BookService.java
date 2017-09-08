package ba.milan.pagination.service.book;

import ba.milan.pagination.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.SQLSyntaxErrorException;
import java.util.List;

/**
 * Created by milanjankovic on 18/08/17.
 */
@Service
public interface BookService {
    Page<Book> getAllPaginatedBooks(Pageable pageable) throws Exception;

    Page<Book> searchBooksWithPagination(Integer page, Integer length, String name, List<Integer> genres, List<Integer> periods,
                                         List<Integer> authors, String sort, String sortDirection, String queryType) throws Exception;
}
