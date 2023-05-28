package ru.kudinov.electrictrainscontroll.repository.repositoryMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.kudinov.electrictrainscontroll.model.IntermediateStation;
import ru.kudinov.electrictrainscontroll.repository.RouteInfoRepository;
import ru.kudinov.electrictrainscontroll.repository.RouteRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@RequiredArgsConstructor
public class IntermediateStationMapper implements RowMapper<IntermediateStation> {

    private final RouteRepository routeRepository;
    private final RouteInfoRepository routeInfoRepository;

    @Override
    public IntermediateStation mapRow(ResultSet rs, int rowNum) throws SQLException {
        return IntermediateStation.builder()
                .id(rs.getLong("id"))
                .route(routeRepository.get(rs.getLong("route_id")).orElse(null))
                .routeInfo(routeInfoRepository.get(rs.getLong("route_info_id")).orElse(null)).build();
    }
}
