package ru.kudinov.electrictrainscontroll.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kudinov.electrictrainscontroll.dto.RouteInfoDto;
import ru.kudinov.electrictrainscontroll.dto.dtoMapper.RouteInfoDtoMapper;
import ru.kudinov.electrictrainscontroll.model.RouteInfo;
import ru.kudinov.electrictrainscontroll.repository.RouteInfoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteInfoService {

    private final RouteInfoRepository repository;
    private final RouteInfoDtoMapper mapper;

    public List<RouteInfo> getAll() {
        return (List<RouteInfo>) repository.getAll();
    }

    public RouteInfo getById(Long id) {
        return repository.get(id)
                .orElseThrow(() -> new EntityNotFoundException("Route info with id: " + id + " does not exist"));
    }

    public RouteInfo addSRouteInfo(RouteInfoDto routeInfoDto) {
        RouteInfo routeInfo = mapper.toRouteInfo(routeInfoDto);
        repository.save(routeInfo);
        return routeInfo;
    }

    public void deleteRouteInfo(Long id) {
        if (repository.get(id).isPresent()) {
            repository.delete(id);
        } else {
            throw new EntityNotFoundException("Route info with id: " + id + " does not exist");
        }
    }

    public void updateRouteInfo(RouteInfoDto routeInfoDto) {
        if (repository.get(routeInfoDto.getId()).isPresent()) {
            repository.update(mapper.toRouteInfo(routeInfoDto));
        } else {
            throw new EntityNotFoundException("Route info with id: " + routeInfoDto.getId() + " does not exist");
        }
    }
}
