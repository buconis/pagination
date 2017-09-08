package ba.milan.pagination.service.genre;

import ba.milan.pagination.model.Book;
import ba.milan.pagination.model.Genre;
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
public interface GenreRepository extends JpaRepository<Genre, Integer> {

    @Query("SELECT g.id FROM Genre g")
    List<Integer> getAllGenreIds();


}
