package com.mcmanuel.AssesmentApplication.domain.entity;


class Mapper {
    public static BoxEntity toBox(BoxDto boxDto) {
        return BoxEntity.builder()
                .boxId(boxDto.boxId())
                .txRef(boxDto.txRef())
                .weight(boxDto.weight())
                .batteryLevel(boxDto.batteryLevel())
                .items(boxDto.items())
                .cameras(boxDto.cameras())
                .build();}

    public static BoxDto toDto(BoxEntity box) {
        return BoxDto.builder()
                .boxId(box.getBoxId())
                .txRef(box.getTxRef())
                .weight(box.getWeight())
                .batteryLevel(box.getBatteryLevel())
                .items(box.getItems())
                .cameras(box.getCameras())
                .build();
    }
}
