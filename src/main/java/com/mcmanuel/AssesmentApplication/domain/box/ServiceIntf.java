package com.mcmanuel.AssesmentApplication.domain.entity;

import com.mcmanuel.AssesmentApplication.domain.pojo.BoxRequest;

import java.util.List;
import java.util.Optional;

public interface ServiceIntf {
    BoxDto createBox(BoxRequest boxRequest);
    BoxDto getBoxByTxRef(String txRef);
    BoxDto loadBox(String txRef,List<Item> items);
    BoxDto loadBox(String txRef,Item items);
    List<Item> getItems(String boxId);
    List<BoxDto> getAllBoxes();
    List<BoxDto> getAvailableBoxes();
    Optional<Integer> checkBatteryLevel(String txRef);

}