package com.mcmanuel.AssesmentApplication.domain.pojo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Battery {

    @Max(value = 100)
    @Min(value = 0)
    private int batteryLevel;
}
