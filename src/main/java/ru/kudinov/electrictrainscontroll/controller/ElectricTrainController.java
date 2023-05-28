package ru.kudinov.electrictrainscontroll.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kudinov.electrictrainscontroll.dto.ElectricTrainDto;
import ru.kudinov.electrictrainscontroll.service.ElectricTrainService;

@Controller
@RequiredArgsConstructor
@RequestMapping("electricTrain")
public class ElectricTrainController {

    private final ElectricTrainService service;

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody ElectricTrainDto electricTrain) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.addElectricTrain(electricTrain));
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
    public ResponseEntity<?> update(@RequestBody ElectricTrainDto electricTrain) {
        service.updateElectricTrain(electricTrain);
        return ResponseEntity
                .status(HttpStatus.OK).build();
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteElectricTrain(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Electric train was successfully deleted");
    }
}
