package ba.milan.pagination.service.period;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by milanjankovic on 18/08/17.
 */
@Service
public interface PeriodService {
    List<Integer> getAllIdsFromPeriod();
}
