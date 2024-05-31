package bg.softuni.mobilelele.model.dto;

import bg.softuni.mobilelele.model.enums.EngineType;

public class AddOfferDTO {

    private EngineType engineType;

    private String description;

    public EngineType getEngineType() {
        return engineType;
    }

    public AddOfferDTO setEngineType(EngineType engineType) {
        this.engineType = engineType;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddOfferDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public static AddOfferDTO emptyInstance(){
        return new AddOfferDTO()
                .setDescription(null)
                .setEngineType(null);
    }
}
