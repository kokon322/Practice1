package repository.impl;

import model.Movie;
import org.springframework.stereotype.Repository;
import repository.MovieRepository;
import util.ConnectionUtil;

import java.sql.*;
import java.util.List;

@Repository
public class MovieRepositoryImpl implements MovieRepository {


    @Override
    public Movie save(Movie movie) {
        String query = "INSERT INTO movies (title, description) VALUE(?, ?)";
        try (PreparedStatement statement = ConnectionUtil.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, movie.getTitle());
            statement.setString(2, movie.getDescription());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                movie.setId(resultSet.getLong(1));
                return movie;
            }
        } catch (SQLException throwables) {
            throwables.getStackTrace();
        }
        throw new RuntimeException();

    }

    @Override
    public Movie get(Long id) {
        String query = "SELECT * FROM movies WHERE id = ?";
        Movie movie = new Movie();
        try (PreparedStatement statement = ConnectionUtil.getConnection().prepareStatement(query)){
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                movie.setId(resultSet.getLong("id"));
                movie.setTitle(resultSet.getString("title"));
                movie.setDescription(resultSet.getString("description"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return movie;
    }

    @Override
    public List<Movie> getAll() {
        return null;
    }

    @Override
    public Movie delete(Long id) {
        return null;
    }
}
