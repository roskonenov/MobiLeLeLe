package bg.softuni.mobilelele.model.dto;

import bg.softuni.mobilelele.model.enums.EngineType;

public class OfferDetailsDTO {

    private Long id;

    private EngineType engineType;

    private Integer mileage;

    private String description;

    public Long getId() {
        return id;
    }

    public OfferDetailsDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public OfferDetailsDTO setEngineType(EngineType engineType) {
        this.engineType = engineType;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferDetailsDTO setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferDetailsDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
