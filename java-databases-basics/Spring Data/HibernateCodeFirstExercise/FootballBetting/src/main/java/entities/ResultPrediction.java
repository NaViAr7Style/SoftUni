package entities;

import entities.enums.ResultPredictionValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "result_predictions")
public class ResultPrediction extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private ResultPredictionValue resultPrediction;
}
