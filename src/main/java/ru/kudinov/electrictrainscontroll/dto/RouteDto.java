package ru.kudinov.electrictrainscontroll.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RouteDto {

    private Long id;

    private Long startStationId;

    private Long endStationId;
}
