package ru.kudinov.electrictrainscontroll.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.kudinov.electrictrainscontroll.model.ElectricTrain;
import ru.kudinov.electrictrainscontroll.repository.repositoryMapper.ElectricTrainMapper;

import java.util.Collection;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ElectricTrainRepository implements CrudRepository<ElectricTrain> {

    private final JdbcTemplate jdbcTemplate;
    private final ElectricTrainMapper electricTrainMapper;

    @Override
    public Optional<ElectricTrain> get(Long id) {
        /*language=SQL*/
        return jdbcTemplate.query("SELECT * FROM electric_trains WHERE id=?",
                        electricTrainMapper, id)
                .stream().findAny();
    }

    @Override
    public Collection<ElectricTrain> getAll() {
        /*language=SQL*/
        return jdbcTemplate.query("SELECT * FROM electric_trains", electricTrainMapper);
    }

    @Override
    public int save(ElectricTrain electricTrain) {
        /*language=SQL*/
        return jdbcTemplate.update("INSERT INTO electric_trains (number, route_id) VALUES(?, ?)",
                electricTrain.getNumber(),
                electricTrain.getRoute().getId());

    }

    @Override
    public int update(ElectricTrain electricTrain) {
        /*language=SQL*/
        return jdbcTemplate.update("UPDATE electric_trains SET number=?, route_id=? WHERE id=?",
                electricTrain.getNumber(),
                electricTrain.getRoute().getId(),
                electricTrain.getId());
    }

    @Override
    public int delete(Long id) {
        /*language=SQL*/
        return jdbcTemplate.update("DELETE FROM electric_trains WHERE id=?", id);
    }
}
