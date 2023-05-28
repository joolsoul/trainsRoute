package ru.kudinov.electrictrainscontroll.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.kudinov.electrictrainscontroll.model.Route;
import ru.kudinov.electrictrainscontroll.repository.repositoryMapper.RouteMapper;

import java.util.Collection;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RouteRepository implements CrudRepository<Route> {

    private final JdbcTemplate jdbcTemplate;
    private final RouteMapper routeMapper;

    @Override
    public Optional<Route> get(Long id) {
        /*language=SQL*/
        return jdbcTemplate.query("SELECT * FROM routes WHERE id=?",
                        routeMapper, id)
                .stream().findAny();
    }

    @Override
    public Collection<Route> getAll() {
        /*language=SQL*/
        return jdbcTemplate.query("SELECT * FROM routes", routeMapper);
    }

    @Override
    public int save(Route route) {
        /*language=SQL*/
        return jdbcTemplate.update("INSERT INTO routes (start_station_id, end_station_id) VALUES(?, ?)",
                route.getStartStation().getId(),
                route.getEndStation().getId());

    }

    @Override
    public int update(Route route) {
        /*language=SQL*/
        return jdbcTemplate.update("UPDATE routes SET start_station_id=?, end_station_id=? WHERE id=?",
                route.getStartStation().getId(),
                route.getEndStation().getId(),
                route.getId());
    }

    @Override
    public int delete(Long id) {
        /*language=SQL*/
        return jdbcTemplate.update("DELETE FROM routes WHERE id=?", id);
    }
}
