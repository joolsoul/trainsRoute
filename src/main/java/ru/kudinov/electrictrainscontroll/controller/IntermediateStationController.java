package ru.kudinov.electrictrainscontroll.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kudinov.electrictrainscontroll.dto.IntermediateStationDto;
import ru.kudinov.electrictrainscontroll.service.IntermediateStationService;

@Controller
@RequiredArgsConstructor
@RequestMapping("intermediateStation")
public class IntermediateStationController {

    private final IntermediateStationService service;

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody IntermediateStationDto intermediateStation) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.addIntermediateStation(intermediateStation));
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
    public ResponseEntity<?> update(@RequestBody IntermediateStationDto intermediateStation) {
        service.updateIntermediateStation(intermediateStation);
        return ResponseEntity
                .status(HttpStatus.OK).build();
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteIntermediateStation(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Intermediate station train was successfully deleted");
    }

}
