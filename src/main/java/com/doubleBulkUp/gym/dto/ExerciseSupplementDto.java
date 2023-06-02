package com.doubleBulkUp.gym.dto;

import com.doubleBulkUp.gym.entity.ExerciseSupplement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseSupplementDto {
    private String supplementName;

    private String usePurpose;

    public ExerciseSupplementDto(ExerciseSupplement es){
        this.supplementName = es.getSupplementName();
        this.supplementName = es.getUsePurpose();
    }
}
