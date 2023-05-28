package ru.kudinov.electrictrainscontroll.dto.dtoMapper;

import org.mapstruct.Mapper;
import ru.kudinov.electrictrainscontroll.dto.ElectricTrainDto;
import ru.kudinov.electrictrainscontroll.model.ElectricTrain;

@Mapper(componentModel = "spring")
public interface ElectricTrainDtoMapper {

    ElectricTrain toElectricTrain(ElectricTrainDto electricTrainDto);

    ElectricTrainDto toElectricTrainDto(ElectricTrain electricTrain);
}
