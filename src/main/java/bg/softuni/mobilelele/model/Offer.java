package bg.softuni.mobilelele.model;

import bg.softuni.mobilelele.model.enums.EngineType;
import jakarta.persistence.*;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {

    @Column(name = "engine_type")
    @Enumerated(EnumType.STRING)
    private EngineType engineType;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    private Integer mileage;


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
