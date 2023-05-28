package ru.kudinov.electrictrainscontroll.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Station {

    private Long id;

    private String name;
}
