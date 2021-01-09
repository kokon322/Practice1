package service;

import model.Movie;

import java.sql.SQLException;

public interface MovieService {
    Movie save (Movie movie) throws SQLException;

    Movie get(Long id);

}
