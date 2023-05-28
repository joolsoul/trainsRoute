package ru.kudinov.electrictrainscontroll.dto.dtoMapper;

import org.mapstruct.Mapper;
import ru.kudinov.electrictrainscontroll.dto.RouteInfoDto;
import ru.kudinov.electrictrainscontroll.model.RouteInfo;

@Mapper(componentModel = "spring")
public interface RouteInfoDtoMapper {

    RouteInfo toRouteInfo(RouteInfoDto routeInfoDto);

    RouteInfoDto toRouteInfoDto(RouteInfo routeInfo);
}
