package com.mcmanuel.AssesmentApplication.domain.box.service;

import com.mcmanuel.AssesmentApplication.domain.box.dto.BoxDto;
import com.mcmanuel.AssesmentApplication.domain.pojo.Item;
import com.mcmanuel.AssesmentApplication.domain.pojo.BoxRequest;

import java.util.List;
import java.util.Optional;

public interface BoxService {
    BoxDto createBox(BoxRequest boxRequest);
    BoxDto getBoxByTxRef(String txRef);
    BoxDto loadBox(String txRef,List<Item> items);
    List<Item> getItems(String boxId);
    List<BoxDto> getAllBoxes();
    List<BoxDto> getAvailableBoxes();
    Optional<Integer> checkBatteryLevel(String txRef);

}