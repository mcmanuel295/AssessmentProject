package com.mcmanuel.AssesmentApplication.domain.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Item {

    @Column(name = "item_name",length = 20)
    @Size(max = 20, message = "Value must be 20 characters or less")
    @Pattern(regexp = "^[A-Z0-9_-]+$", message = "Only uppercase letters, numbers, hyphen and underscores allowed")
    private String itemName;

    private int itemWeight;

    @Column(name = "item_name",length = 20)
    @Pattern(regexp = "^[A-Z0-9_]+$", message = "Only uppercase letters, numbers, and underscores allowed")
    private String itemCode;
    
}
