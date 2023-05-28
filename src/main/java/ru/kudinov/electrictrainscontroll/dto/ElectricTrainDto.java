package ru.kudinov.electrictrainscontroll.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElectricTrainDto {

    private Long id;

    private String number;

    private Long routeId;
}
