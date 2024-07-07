package bg.softuni.mobilelele.model.dto;

import bg.softuni.mobilelele.model.enums.EngineType;

import java.util.List;

public class OfferDetailsDTO {

    private Long id;

    private Integer price;

    private EngineType engineType;

    private Integer mileage;

    private String description;

    private List<String> allCurrencies;

    public Long getId() {
        return id;
    }

    public OfferDetailsDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public OfferDetailsDTO setPrice(Integer price) {
        this.price = price;
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

    public List<String> getAllCurrencies() {
        return allCurrencies;
    }

    public OfferDetailsDTO setAllCurrencies(List<String> allCurrencies) {
        this.allCurrencies = allCurrencies;
        return this;
    }
}
