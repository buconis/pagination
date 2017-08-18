package ba.milan.pagination.service;

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
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("SELECT b from Book LEFT JOIN b.author a LEFT JOIN b.genre g LEFT JOIN b.period p WHERE b.name LIKE concat('%',:search,'%')")
    Page<Book> getPaginatedListOfBooks(@Param("authors") List<Integer> authors, @Param("periods") List<Integer> periods,
                                       @Param("genres") List<Integer> genres, @Param("name") String name, Pageable pageable);
}
