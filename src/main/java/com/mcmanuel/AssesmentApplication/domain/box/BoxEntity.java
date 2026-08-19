package com.mcmanuel.AssesmentApplication.domain.box;

import com.mcmanuel.AssesmentApplication.domain.Camera;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;


import java.util.List;

@Entity
@Table(name = "boxes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class BoxEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boxId;

    @Column(name = "state",nullable = false)
    private String txRef;

    @Max(value = 500)
    @Min(value = 0)
    @Column(name = "state",nullable = false)
    private int weight;

    @Max(value = 100)
    @Min(value = 0)
    @Column(name = "state",nullable = false)
    private int batteryLevel;

    @ElementCollection
    @CollectionTable(name = "camera")
    private List<Camera> cameras;

    private List<Item> items;

    @Enumerated(EnumType.STRING)
    @Column(name = "state",nullable = false)
    private State state;

}