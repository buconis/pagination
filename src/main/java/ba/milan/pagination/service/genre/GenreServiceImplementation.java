package ba.milan.pagination.service.genre;

import ba.milan.pagination.service.book.BookRepository;
import ba.milan.pagination.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by milanjankovic on 18/08/17.
 */
@Component("genreService")
public class GenreServiceImplementation implements GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreServiceImplementation(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }


    @Override
    public List<Integer> getAllIdsFromGenre() {
        return genreRepository.getAllGenreIds();
    }
}
