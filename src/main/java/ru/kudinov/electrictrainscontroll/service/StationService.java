package ru.kudinov.electrictrainscontroll.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kudinov.electrictrainscontroll.model.Station;
import ru.kudinov.electrictrainscontroll.repository.StationRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StationService {

    private final StationRepository repository;

    public List<Station> getAll() {
        return (List<Station>) repository.getAll();
    }

    public Station getById(Long id) {
        return repository.get(id)
                .orElseThrow(() -> new EntityNotFoundException("Station with id: " + id + " does not exist"));
    }

    public Station addStation(Station station) {
        repository.save(station);
        return station;
    }

    public void deleteStation(Long id) {
        if (repository.get(id).isPresent()) {
            repository.delete(id);
        } else {
            throw new EntityNotFoundException("Station with id: " + id + " does not exist");
        }
    }

    public void updateStation(Station station) {
        if (repository.get(station.getId()).isPresent()) {
            repository.update(station);
        } else {
            throw new EntityNotFoundException("Station with id: " + station.getId() + " does not exist");
        }
    }
}
