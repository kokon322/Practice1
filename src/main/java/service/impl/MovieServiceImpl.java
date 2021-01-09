package service.impl;

import lombok.RequiredArgsConstructor;
import model.Movie;
import org.springframework.stereotype.Service;
import repository.MovieRepository;
import service.MovieService;

import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository repository;

    @Override
    public Movie save(Movie movie) throws SQLException {
        return repository.save(movie);
    }

    @Override
    public Movie get(Long id) {
        return repository.get(id);
    }
}
