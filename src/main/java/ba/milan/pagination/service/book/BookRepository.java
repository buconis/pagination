package ba.milan.pagination.service.book;

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

    @Query("SELECT b FROM Book b LEFT JOIN b.author a LEFT JOIN b.genre g LEFT JOIN b.period p " +
            "WHERE b.name LIKE concat('%',:name,'%') AND a.id IN(:authors) AND p.id IN(:periods) AND g.id IN(:genres)")
    Page<Book> getPaginatedListOfBooks(@Param("authors") List<Integer> authors, @Param("periods") List<Integer> periods,
                                       @Param("genres") List<Integer> genres, @Param("name") String name, Pageable pageable);


    @Query(value = "SELECT * FROM Book b LEFT JOIN author a on a.id=b.author_id " +
            "LEFT JOIN genre g on g.id=b.genre_id LEFT JOIN period p on p.id=b.period_id " +
            "WHERE b.name LIKE concat('%',:name,'%') AND a.id IN(:authors) AND p.id IN(:periods) AND g.id IN(:genres) \n#pageable\n",
            countQuery = "SELECT count(b.id) FROM Book b LEFT JOIN author a on a.id=b.author_id " +
                    "LEFT JOIN genre g on g.id=b.genre_id LEFT JOIN period p on p.id=b.period_id " +
                    "WHERE b.name LIKE concat('%',:name,'%') AND a.id IN(:authors) AND p.id IN(:periods) AND g.id IN(:genres) \n#pageable\n",
            nativeQuery = true)
    Page<Book> getNativePaginatedListOfBooks(@Param("authors") List<Integer> authors, @Param("periods") List<Integer> periods,
                                       @Param("genres") List<Integer> genres, @Param("name") String name, Pageable pageable);
}
