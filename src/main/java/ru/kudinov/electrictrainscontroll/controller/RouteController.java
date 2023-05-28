package ru.kudinov.electrictrainscontroll.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kudinov.electrictrainscontroll.dto.RouteDto;
import ru.kudinov.electrictrainscontroll.service.RouteService;

@Controller
@RequiredArgsConstructor
@RequestMapping("route")
public class RouteController {

    private final RouteService service;

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody RouteDto route) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.addSRoute(route));
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
    public ResponseEntity<?> update(@RequestBody RouteDto route) {
        service.updateRoute(route);
        return ResponseEntity
                .status(HttpStatus.OK).build();
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteRoute(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Route was successfully deleted");
    }
}
