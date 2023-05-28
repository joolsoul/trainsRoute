package ru.kudinov.electrictrainscontroll.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.kudinov.electrictrainscontroll.model.Station;

import java.util.Collection;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class StationRepository implements CrudRepository<Station> {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Optional<Station> get(Long id) {
        /*language=SQL*/
        return jdbcTemplate.query("SELECT * FROM stations WHERE id=?",
                        new BeanPropertyRowMapper<>(Station.class), id)
                .stream().findAny();
    }

    @Override
    public Collection<Station> getAll() {
        /*language=SQL*/
        return jdbcTemplate.query("SELECT * FROM stations", new BeanPropertyRowMapper<>(Station.class));
    }

    @Override
    public int save(Station station) {
        /*language=SQL*/
        return jdbcTemplate.update("INSERT INTO stations (name) VALUES(?)",
                station.getName());

    }

    @Override
    public int update(Station station) {
        /*language=SQL*/
        return jdbcTemplate.update("UPDATE stations SET name=? WHERE id=?",
                station.getName(),
                station.getId());
    }

    @Override
    public int delete(Long id) {
        /*language=SQL*/
        return jdbcTemplate.update("DELETE FROM stations WHERE id=?", id);
    }
}
