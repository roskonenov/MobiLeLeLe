package bg.softuni.mobilelele.model.dto;

import bg.softuni.mobilelele.model.enums.EngineType;
import jakarta.validation.constraints.*;

public class AddOfferDTO {

    @NotNull
    @PositiveOrZero
    private Integer price;

    @NotNull
    private EngineType engineType;

    @NotBlank(message = "{add.offer.description.not.empty}")
    @Size(message = "{add.offer.description.length}", min = 5, max = 255)
    private String description;

    @NotNull(message = "{add.offer.mileage.not.empty}")
    @PositiveOrZero(message = "{add.offer.mileage.positive}")
    @Max(value = 999999, message = "{add.offer.mileage.below.million}")
    private Integer mileage;

    public Integer getPrice() {
        return price;
    }

    public AddOfferDTO setPrice(Integer price) {
        this.price = price;
        return this;
    }

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

    public Integer getMileage() {
        return mileage;
    }

    public AddOfferDTO setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }
}
