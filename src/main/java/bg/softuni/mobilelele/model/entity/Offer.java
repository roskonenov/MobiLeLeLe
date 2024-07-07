package bg.softuni.mobilelele.model.entity;

import bg.softuni.mobilelele.model.enums.EngineType;
import jakarta.persistence.*;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {

    @Column(nullable = false)
    private Integer price;

    @Column(name = "engine_type")
    @Enumerated(EnumType.STRING)
    private EngineType engineType;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Integer mileage;

    public Integer getPrice() {
        return price;
    }

    public Offer setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public Offer setEngineType(EngineType engineType) {
        this.engineType = engineType;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Offer setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public Offer setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }
}
