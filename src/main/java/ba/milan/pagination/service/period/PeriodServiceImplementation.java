package ba.milan.pagination.service.period;

import ba.milan.pagination.service.genre.GenreRepository;
import ba.milan.pagination.service.genre.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by milanjankovic on 18/08/17.
 */
@Component("periodService")
public class PeriodServiceImplementation implements PeriodService{
    private final PeriodRepository periodRepository;

    @Autowired
    public PeriodServiceImplementation(PeriodRepository periodRepository){
        this.periodRepository = periodRepository;
    }

    @Override
    public List<Integer> getAllIdsFromPeriod() {
        return periodRepository.getAllPeriodIds();
    }
}
