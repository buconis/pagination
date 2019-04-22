package ba.milan.pagination.service.book;

import ba.milan.pagination.model.Book;
import ba.milan.pagination.service.author.AuthorService;
import ba.milan.pagination.service.genre.GenreService;
import ba.milan.pagination.service.period.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by milanjankovic on 18/08/17.
 */
@Component("bookService")
public class BookServiceImplementation implements BookService {
    private static final String ASC = "asc";
    private static final String NATIVE = "native";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final GenreService genreService;
    private final PeriodService periodService;

    @Autowired
    public BookServiceImplementation(BookRepository bookRepository, AuthorService authorService, GenreService genreService, PeriodService periodService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.genreService = genreService;
        this.periodService = periodService;
    }


    @Override
    public Page<Book> getAllPaginatedBooks(Pageable pageable) throws Exception {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Page<Book> searchBooksWithPagination(Integer page, Integer length, String name, List<Integer> genres, List<Integer> periods,
                                                List<Integer> authors, String sort, String sortDirection, String queryType) throws Exception {

        switch (queryType) {
            case NATIVE:
                return bookRepository.getNativePaginatedListOfBooks(handleAuthors(authors), handlePeriods(periods), handleGenres(genres), name,
                        createPageRequest(sort, sortDirection, length, page));
            default:
                return bookRepository.getPaginatedListOfBooks(handleAuthors(authors), handlePeriods(periods), handleGenres(genres), name,
                        createPageRequest(sort, sortDirection, length, page));
        }


    }

    private Pageable createPageRequest(String sort, String sortDirection, Integer length, Integer pageNumber) {
        if (length == null || length.equals(-1)) {
            length = Integer.MAX_VALUE;
            pageNumber = 0;
        }
        if (pageNumber == null)
            pageNumber = 0;
        return new PageRequest(pageNumber, length, new Sort(getDirection(sortDirection), sort));
    }


    private Sort.Direction getDirection(String sortDirection) {
        return (sortDirection == null || ASC.equals(sortDirection)) ?
                Sort.Direction.ASC : Sort.Direction.DESC;
    }

    private List<Integer> handleGenres(List<Integer> genres) {
        if (genres == null || genres.isEmpty() || genres.get(0).equals(-1)) {
            genres = genreService.getAllIdsFromGenre();
        }
        return genres;
    }

    private List<Integer> handlePeriods(List<Integer> periods) {
        if (periods == null || periods.isEmpty() || periods.get(0).equals(-1)) {
            periods = periodService.getAllIdsFromPeriod();
        }
        return periods;
    }

    private List<Integer> handleAuthors(List<Integer> authors) {
        if (authors == null || authors.isEmpty() || authors.get(0).equals(-1)) {
            authors = authorService.getAllAuthorIds();
        }
        return authors;
    }


}
