package ru.kudinov.electrictrainscontroll.dto.dtoMapper;

import org.mapstruct.Mapper;
import ru.kudinov.electrictrainscontroll.dto.ElectricTrainDto;
import ru.kudinov.electrictrainscontroll.dto.IntermediateStationDto;
import ru.kudinov.electrictrainscontroll.model.ElectricTrain;
import ru.kudinov.electrictrainscontroll.model.IntermediateStation;

@Mapper(componentModel = "spring")
public interface IntermediateStationDtoMapper {

    IntermediateStation toIntermediateStation(IntermediateStationDto intermediateStationDto);

    IntermediateStationDto toIntermediateStationDto(IntermediateStation intermediateStation);
}
