package ru.kudinov.electrictrainscontroll.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IntermediateStationDto {

    private Long id;

    private Long RouteId;

    private Long RouteInfoId;
}
