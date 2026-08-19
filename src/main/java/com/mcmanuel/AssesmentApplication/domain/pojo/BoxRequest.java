package com.mcmanuel.AssesmentApplication.domain.pojo;

import com.mcmanuel.AssesmentApplication.domain.Camera;
import com.mcmanuel.AssesmentApplication.domain.box.Item;
import lombok.Getter;

import java.util.List;
@Getter
public record BoxRequest(
        String txRef,
        int weight,
        int batteryLevel,
        List<Camera> cameras,
        List<Item> items
) {
}
