package com.mcmanuel.AssesmentApplication.domain.box.mapper;

import com.mcmanuel.AssesmentApplication.domain.box.dto.BoxDto;
import com.mcmanuel.AssesmentApplication.domain.box.entity.BoxEntity;


public final class DtoMapper {
    public static BoxEntity toBox(BoxDto boxDto) {
        return BoxEntity.builder()
                .boxId(boxDto.boxId())
                .txRef(boxDto.txRef())
                .weight(boxDto.weight())
                .battery(boxDto.battery())
                .items(boxDto.items())
                .build();}

    public static BoxDto toDto(BoxEntity box) {
        return BoxDto.builder()
                .boxId(box.getBoxId())
                .txRef(box.getTxRef())
                .weight(box.getWeight())
                .battery(box.getBattery())
                .items(box.getItems())
                .build();
    }
}
