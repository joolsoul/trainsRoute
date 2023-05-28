package ru.kudinov.electrictrainscontroll.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kudinov.electrictrainscontroll.model.Station;
import ru.kudinov.electrictrainscontroll.service.StationService;

@Controller
@RequiredArgsConstructor
@RequestMapping("station")
public class StationController {

    private final StationService service;

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody Station station) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.addStation(station));
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
    public ResponseEntity<?> update(@RequestBody Station station) {
        service.updateStation(station);
        return ResponseEntity
                .status(HttpStatus.OK).build();
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteStation(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Station was successfully deleted");
    }
}
