package ba.milan.pagination.service.author;

import ba.milan.pagination.service.book.BookRepository;
import ba.milan.pagination.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by milanjankovic on 18/08/17.
 */
@Service("authorService")
public class AuthorServiceImplementation implements AuthorService{
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImplementation(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Integer> getAllAuthorIds() {
        return authorRepository.getAllAuthorIds();
    }
}
