package ru.kudinov.electrictrainscontroll.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kudinov.electrictrainscontroll.dto.ElectricTrainDto;
import ru.kudinov.electrictrainscontroll.dto.dtoMapper.ElectricTrainDtoMapper;
import ru.kudinov.electrictrainscontroll.model.ElectricTrain;
import ru.kudinov.electrictrainscontroll.repository.ElectricTrainRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ElectricTrainService {

    private final ElectricTrainRepository repository;
    private final ElectricTrainDtoMapper mapper;

    public List<ElectricTrain> getAll() {
        return (List<ElectricTrain>) repository.getAll();
    }

    public ElectricTrain getById(Long id) {
        return repository.get(id)
                .orElseThrow(() -> new EntityNotFoundException("Electric train station with id: " + id + " does not exist"));
    }

    public ElectricTrain addElectricTrain(ElectricTrainDto electricTrainDto) {
        ElectricTrain electricTrain = mapper.toElectricTrain(electricTrainDto);
        repository.save(electricTrain);
        return electricTrain;
    }

    public void deleteElectricTrain(Long id) {
        if (repository.get(id).isPresent()) {
            repository.delete(id);
        } else {
            throw new EntityNotFoundException("Electric train station with id: " + id + " does not exist");
        }
    }

    public void updateElectricTrain(ElectricTrainDto electricTrainDto) {
        if (repository.get(electricTrainDto.getId()).isPresent()) {
            repository.update(mapper.toElectricTrain(electricTrainDto));
        } else {
            throw new EntityNotFoundException("Electric train station with id: " + electricTrainDto.getId() + " does not exist");
        }
    }
}
