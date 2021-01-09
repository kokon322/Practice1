package repository;

import model.Movie;

import java.sql.SQLException;
import java.util.List;

public interface MovieRepository {
    Movie save(Movie movie) throws SQLException;

    Movie get(Long id);

    List<Movie> getAll();

    Movie delete (Long id);
}
