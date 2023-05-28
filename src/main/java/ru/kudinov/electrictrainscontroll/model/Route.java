package ru.kudinov.electrictrainscontroll.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Route {

    private Long id;

    private Station startStation;

    private Station endStation;
}
