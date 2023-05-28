package ru.kudinov.electrictrainscontroll.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kudinov.electrictrainscontroll.dto.RouteDto;
import ru.kudinov.electrictrainscontroll.dto.dtoMapper.RouteDtoMapper;
import ru.kudinov.electrictrainscontroll.model.Route;
import ru.kudinov.electrictrainscontroll.repository.RouteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository repository;
    private final RouteDtoMapper mapper;

    public List<Route> getAll() {
        return (List<Route>) repository.getAll();
    }

    public Route getById(Long id) {
        return repository.get(id)
                .orElseThrow(() -> new EntityNotFoundException("Route with id: " + id + " does not exist"));
    }

    public Route addSRoute(RouteDto routeDto) {
        Route route = mapper.toRoute(routeDto);
        repository.save(route);
        return route;
    }

    public void deleteRoute(Long id) {
        if (repository.get(id).isPresent()) {
            repository.delete(id);
        } else {
            throw new EntityNotFoundException("Route with id: " + id + " does not exist");
        }
    }

    public void updateRoute(RouteDto routeDto) {
        if (repository.get(routeDto.getId()).isPresent()) {
            repository.update(mapper.toRoute(routeDto));
        } else {
            throw new EntityNotFoundException("Route with id: " + routeDto.getId() + " does not exist");
        }
    }
}
