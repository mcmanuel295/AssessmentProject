package com.mcmanuel.AssesmentApplication.domain.box.dto;

import com.mcmanuel.AssesmentApplication.domain.Camera;
import com.mcmanuel.AssesmentApplication.domain.box.entity.Item;
import com.mcmanuel.AssesmentApplication.domain.box.entity.State;
import lombok.Builder;

import java.util.List;

@Builder
public record BoxDto(
        Integer boxId,
        String txRef,
        int weight,
        int batteryLevel,
        List<Camera> cameras,
        List<Item> items,
        State state
) {}
