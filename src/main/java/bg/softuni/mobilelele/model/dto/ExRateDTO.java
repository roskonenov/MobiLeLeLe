package bg.softuni.mobilelele.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Map;

public class ExRateDTO {

    @JsonProperty("base_code")
    private String base;

    @JsonProperty("conversion_rates")
    private Map<String, BigDecimal> rates;

    public String getBase() {
        return base;
    }

    public Map<String, BigDecimal> getRates() {
        return rates;
    }
}
