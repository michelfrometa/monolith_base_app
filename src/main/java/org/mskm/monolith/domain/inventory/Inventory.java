package org.mskm.monolith.domain.inventory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Document
@Getter
@Setter
@Builder
public class Inventory {

    @Id
    private String id;

    private String name;

    private double value;

}
