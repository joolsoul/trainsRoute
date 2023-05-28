package ru.kudinov.electrictrainscontroll.dto.dtoMapper;

import org.mapstruct.Mapper;
import ru.kudinov.electrictrainscontroll.dto.RouteDto;
import ru.kudinov.electrictrainscontroll.model.Route;

@Mapper(componentModel = "spring")
public interface RouteDtoMapper {

    Route toRoute(RouteDto routeDto);

    RouteDto toRouteDto(Route route);
}
