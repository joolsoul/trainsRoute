package ru.kudinov.electrictrainscontroll.repository.repositoryMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.kudinov.electrictrainscontroll.model.Route;
import ru.kudinov.electrictrainscontroll.repository.StationRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@RequiredArgsConstructor
public class RouteMapper implements RowMapper<Route> {

    private final StationRepository stationRepository;

    @Override
    public Route mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Route.builder()
                .id(rs.getLong("id"))
                .endStation(stationRepository.get(rs.getLong("end_station_id")).orElse(null))
                .startStation(stationRepository.get(rs.getLong("start_station_id")).orElse(null)).build();
    }
}
