package ru.kudinov.electrictrainscontroll.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.kudinov.electrictrainscontroll.model.RouteInfo;
import ru.kudinov.electrictrainscontroll.repository.repositoryMapper.RouteInfoMapper;

import java.util.Collection;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class RouteInfoRepository implements CrudRepository<RouteInfo> {

    private final JdbcTemplate jdbcTemplate;
    private final RouteInfoMapper routeInfoMapper;

    @Override
    public Optional<RouteInfo> get(Long id) {
        /*language=SQL*/
        return jdbcTemplate.query("SELECT * FROM routes_info WHERE id=?",
                        routeInfoMapper, id)
                .stream().findAny();
    }

    @Override
    public Collection<RouteInfo> getAll() {
        /*language=SQL*/
        return jdbcTemplate.query("SELECT * FROM routes_info", routeInfoMapper);
    }

    @Override
    public int save(RouteInfo routeInfo) {
        /*language=SQL*/
        return jdbcTemplate.update("INSERT INTO routes_info (station_id, arrival_time, sending_time) VALUES(?, ?, ?)",
                routeInfo.getStation().getId(),
                routeInfo.getArrivalTime(),
                routeInfo.getSendingTime());

    }

    @Override
    public int update(RouteInfo routeInfo) {
        /*language=SQL*/
        return jdbcTemplate.update("UPDATE routes_info SET station_id=?, arrival_time=?, sending_time=? WHERE id=?",
                routeInfo.getStation().getId(),
                routeInfo.getArrivalTime(),
                routeInfo.getSendingTime(),
                routeInfo.getId());
    }

    @Override
    public int delete(Long id) {
        /*language=SQL*/
        return jdbcTemplate.update("DELETE FROM routes_info WHERE id=?", id);
    }
}
