package ru.kudinov.electrictrainscontroll.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kudinov.electrictrainscontroll.dto.ElectricTrainDto;
import ru.kudinov.electrictrainscontroll.dto.RouteInfoDto;
import ru.kudinov.electrictrainscontroll.service.ElectricTrainService;
import ru.kudinov.electrictrainscontroll.service.RouteInfoService;

@Controller
@RequiredArgsConstructor
@RequestMapping("routeInfo")
public class RouteInfoController {

    private final RouteInfoService service;

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody RouteInfoDto routeInfo) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.addSRouteInfo(routeInfo));
    }

    @GetMapping("get")
    public ResponseEntity<?> getAll() {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getAll());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getById(id));
    }

    @PatchMapping("update")
    public ResponseEntity<?> update(@RequestBody RouteInfoDto routeInfo) {
        service.updateRouteInfo(routeInfo);
        return ResponseEntity
                .status(HttpStatus.OK).build();
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteRouteInfo(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Route info train was successfully deleted");
    }
}
