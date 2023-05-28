package ru.kudinov.electrictrainscontroll.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kudinov.electrictrainscontroll.dto.IntermediateStationDto;
import ru.kudinov.electrictrainscontroll.dto.dtoMapper.IntermediateStationDtoMapper;
import ru.kudinov.electrictrainscontroll.model.IntermediateStation;
import ru.kudinov.electrictrainscontroll.repository.IntermediateStationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IntermediateStationService {

    private final IntermediateStationRepository repository;
    private final IntermediateStationDtoMapper mapper;

    public List<IntermediateStation> getAll() {
        return (List<IntermediateStation>) repository.getAll();
    }

    public IntermediateStation getById(Long id) {
        return repository.get(id)
                .orElseThrow(() -> new EntityNotFoundException("Intermediate station with id: " + id + " does not exist"));
    }

    public IntermediateStation addIntermediateStation(IntermediateStationDto intermediateStationDto) {
        IntermediateStation intermediateStation = mapper.toIntermediateStation(intermediateStationDto);
        repository.save(intermediateStation);
        return intermediateStation;
    }

    public void deleteIntermediateStation(Long id) {
        if (repository.get(id).isPresent()) {
            repository.delete(id);
        } else {
            throw new EntityNotFoundException("Intermediate station with id: " + id + " does not exist");
        }
    }

    public void updateIntermediateStation(IntermediateStationDto intermediateStationDto) {
        if (repository.get(intermediateStationDto.getId()).isPresent()) {
            repository.update(mapper.toIntermediateStation(intermediateStationDto));
        } else {
            throw new EntityNotFoundException("Intermediate station with id: " + intermediateStationDto.getId() + " does not exist");
        }
    }
}
