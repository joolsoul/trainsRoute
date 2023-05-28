package ru.kudinov.electrictrainscontroll.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ElectricTrain {

    private Long id;

    private String number;

    private Route route;
}
