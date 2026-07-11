package com.project.model.enums;

import lombok.Getter;

@Getter
public enum SchoolYear {

    SIXTH_GRADE(6, "6th Grade", "6º Ano"),
    SEVENTH_GRADE(7, "7th Grade", "7º Ano"),
    EIGHTH_GRADE(8, "8th Grade", "8º Ano"),
    NINTH_GRADE(9, "9th Grade", "9º Ano"),
    HIGH_SCHOOL_1(10, "High School 1st Year", "1º Ano Ensino Médio"),
    HIGH_SCHOOL_2(11, "High School 2nd Year", "2º Ano Ensino Médio"),
    HIGH_SCHOOL_3(12, "High School 3rd Year", "3º Ano Ensino Médio");

    private final int value;
    private final String englishLabel;
    private final String portugueseLabel;

    SchoolYear(int value, String englishLabel, String portugueseLabel) {
        this.value = value;
        this.englishLabel = englishLabel;
        this.portugueseLabel = portugueseLabel;
    }

}
