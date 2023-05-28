package ru.kudinov.electrictrainscontroll.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RouteInfoDto {

    private Long id;

    private Long stationId;

    private Date arrivalTime;

    private Date sendingTime;
}
