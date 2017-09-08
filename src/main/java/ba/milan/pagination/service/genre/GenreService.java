package ba.milan.pagination.service.genre;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by milanjankovic on 18/08/17.
 */
@Service
public interface GenreService {
    List<Integer> getAllIdsFromGenre();
}
