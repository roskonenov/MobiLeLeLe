package bg.softuni.mobilelele.model.dto;

import bg.softuni.mobilelele.model.enums.EngineType;

public class offerSummaryDTO {

    private long id;

    private Integer mileage;

    private EngineType engineType;

    public long getId() {
        return id;
    }

    public offerSummaryDTO setId(long id) {
        this.id = id;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public offerSummaryDTO setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public offerSummaryDTO setEngineType(EngineType engineType) {
        this.engineType = engineType;
        return this;
    }
}
