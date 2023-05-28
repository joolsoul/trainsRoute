package ru.kudinov.electrictrainscontroll.repository.repositoryMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.kudinov.electrictrainscontroll.model.RouteInfo;
import ru.kudinov.electrictrainscontroll.repository.StationRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@RequiredArgsConstructor
public class RouteInfoMapper implements RowMapper<RouteInfo> {

    private final StationRepository stationRepository;

    @Override
    public RouteInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        return RouteInfo.builder()
                .id(rs.getLong("id"))
                .station(stationRepository.get(rs.getLong("station_id")).orElse(null))
                .arrivalTime(rs.getDate("arrival_time"))
                .sendingTime(rs.getDate("sending_time")).build();
    }
}
