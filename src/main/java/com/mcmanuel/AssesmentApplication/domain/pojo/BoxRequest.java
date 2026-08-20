package com.mcmanuel.AssesmentApplication.domain.pojo;

import java.util.List;
public record BoxRequest(
        String txRef,
        int weight,
        int batteryLevel,
        List<Item> items
) {
}
