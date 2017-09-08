package ba.milan.pagination.service.author;

import ba.milan.pagination.model.Author;
import ba.milan.pagination.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by milanjankovic on 18/08/17.
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query("SELECT b.id FROM Book b")
    List<Integer> getAllAuthorIds();
}
