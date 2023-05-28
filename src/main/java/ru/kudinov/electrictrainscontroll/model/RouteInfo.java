package ru.kudinov.electrictrainscontroll.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RouteInfo {

    private Long id;

    private Station station;

    private Date arrivalTime;

    private Date sendingTime;
}
