package com.project.model;

import com.project.model.enums.SchoolYear;
import com.project.model.enums.Subject;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "topics")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Enumerated(EnumType.STRING)
    private SchoolYear schoolYear;

    @Enumerated(EnumType.STRING)
    private Subject subject;

    @OneToMany(mappedBy = "topic")
    private List<Question> questions;

}
