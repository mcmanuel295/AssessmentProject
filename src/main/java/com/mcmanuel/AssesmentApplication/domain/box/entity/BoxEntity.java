package com.mcmanuel.AssesmentApplication.domain.box.entity;

import com.mcmanuel.AssesmentApplication.domain.pojo.Battery;
import com.mcmanuel.AssesmentApplication.domain.pojo.Camera;
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
public class BoxEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boxId;

    @Column(name = "state",nullable = false)
    private String txRef;

    @Max(value = 500)
    @Min(value = 0)
    @Column(name = "weight",nullable = false)
    private int weight;


    private Battery battery;

    @ElementCollection
    @CollectionTable(name = "camera")
    private List<Camera> cameras;

    private List<Item> items;

    @Enumerated(EnumType.STRING)
    @Column(name = "state",nullable = false)
    private State state;

}