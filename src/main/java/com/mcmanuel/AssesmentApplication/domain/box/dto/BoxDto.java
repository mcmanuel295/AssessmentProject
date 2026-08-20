package com.mcmanuel.AssesmentApplication.domain.box.dto;

import com.mcmanuel.AssesmentApplication.domain.pojo.Battery;
import com.mcmanuel.AssesmentApplication.domain.pojo.Camera;
import com.mcmanuel.AssesmentApplication.domain.pojo.Item;
import com.mcmanuel.AssesmentApplication.domain.box.entity.State;
import lombok.Builder;

import java.util.List;

@Builder
public record BoxDto(
        Integer boxId,
        String txRef,
        int weight,
        Battery battery,
        List<Camera> cameras,
        List<Item> items,
        State state
) {}
