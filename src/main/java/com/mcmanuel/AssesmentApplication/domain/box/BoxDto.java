package com.mcmanuel.AssesmentApplication.domain.entity;

import com.mcmanuel.AssesmentApplication.domain.Camera;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public record BoxDto(
        Integer boxId,
        String txRef,
        int weight,
        int batteryLevel,
        List<Camera> cameras,
        List<Item> items,
        State state
) {}
