package pl.madison.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int deposityValue;

    public Investment(int deposityValue) {
        this.deposityValue = deposityValue;
    }
}
