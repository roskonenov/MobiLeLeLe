package bg.softuni.mobilelele.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
@Entity
@Table(name = "ex_rate")
public class ExRate extends BaseEntity{

    @NotBlank
    @Column(nullable = false, unique = true)
    private String currency;

    @Positive
    @NotNull
    private BigDecimal rate;

    public String getCurrency() {
        return currency;
    }

    public ExRate setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public ExRate setRate(BigDecimal rate) {
        this.rate = rate;
        return this;
    }
}
