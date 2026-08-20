package com.mcmanuel.AssesmentApplication.domain.pojo;

import com.mcmanuel.AssesmentApplication.domain.box.entity.Item;

import java.util.List;
public record BoxRequest(
        String txRef,
        int weight,
        int batteryLevel,
        List<Camera> cameras,
        List<Item> items
) {
}
