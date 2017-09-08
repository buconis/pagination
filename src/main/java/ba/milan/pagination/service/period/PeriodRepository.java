package ba.milan.pagination.service.period;

import ba.milan.pagination.model.Genre;
import ba.milan.pagination.model.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by milanjankovic on 18/08/17.
 */
@Repository
public interface PeriodRepository extends JpaRepository<Period, Integer> {

    @Query("SELECT p.id FROM Period p")
    List<Integer> getAllPeriodIds();


}
