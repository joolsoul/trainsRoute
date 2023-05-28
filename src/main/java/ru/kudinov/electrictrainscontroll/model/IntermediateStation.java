package ru.kudinov.electrictrainscontroll.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IntermediateStation {

    private Long id;

    private Route route;

    private RouteInfo routeInfo;
}
