package ru.kudinov.electrictrainscontroll.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.kudinov.electrictrainscontroll.model.IntermediateStation;
import ru.kudinov.electrictrainscontroll.repository.repositoryMapper.IntermediateStationMapper;

import java.util.Collection;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class IntermediateStationRepository implements CrudRepository<IntermediateStation> {

    private final JdbcTemplate jdbcTemplate;
    private final IntermediateStationMapper intermediateStationMapper;

    @Override
    public Optional<IntermediateStation> get(Long id) {
        /*language=SQL*/
        return jdbcTemplate.query("SELECT * FROM intermediate_stations WHERE id=?",
                        intermediateStationMapper, id)
                .stream().findAny();
    }

    @Override
    public Collection<IntermediateStation> getAll() {
        /*language=SQL*/
        return jdbcTemplate.query("SELECT * FROM intermediate_stations", intermediateStationMapper);
    }

    @Override
    public int save(IntermediateStation intermediateStation) {
        /*language=SQL*/
        return jdbcTemplate.update("INSERT INTO intermediate_stations (route_id, route_info_id) VALUES(?, ?)",
                intermediateStation.getRoute().getId(),
                intermediateStation.getRouteInfo().getId());

    }

    @Override
    public int update(IntermediateStation intermediateStation) {
        /*language=SQL*/
        return jdbcTemplate.update("UPDATE intermediate_stations SET route_id=?, route_info_id=? WHERE id=?",
                intermediateStation.getRoute().getId(),
                intermediateStation.getRouteInfo().getId(),
                intermediateStation.getId());
    }

    @Override
    public int delete(Long id) {
        /*language=SQL*/
        return jdbcTemplate.update("DELETE FROM intermediate_stations WHERE id=?", id);
    }
}
