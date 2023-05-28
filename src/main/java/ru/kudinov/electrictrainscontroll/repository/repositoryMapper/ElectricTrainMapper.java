package ru.kudinov.electrictrainscontroll.repository.repositoryMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.kudinov.electrictrainscontroll.model.ElectricTrain;
import ru.kudinov.electrictrainscontroll.repository.RouteRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@RequiredArgsConstructor
public class ElectricTrainMapper implements RowMapper<ElectricTrain> {

    private final RouteRepository routeRepository;

    @Override
    public ElectricTrain mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ElectricTrain.builder()
                .id(rs.getLong("id"))
                .number(rs.getString("number"))
                .route(routeRepository.get(rs.getLong("route_id")).orElse(null)).build();
    }
}
