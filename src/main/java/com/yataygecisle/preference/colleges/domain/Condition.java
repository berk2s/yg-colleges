package com.yataygecisle.preference.colleges.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Condition {

    @Id
    @Column(name = "condition_id")
    private UUID conditionId;

    @Column(name = "reference_number")
    private Integer referenceNumber;

    @Column(name = "condition_description")
    private String conditionDescription;

    @ManyToMany(mappedBy = "conditions", fetch = FetchType.LAZY)
    private List<Course> courses = new ArrayList<>();

}
