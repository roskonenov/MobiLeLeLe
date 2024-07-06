package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.dto.ExRateDTO;

import java.math.BigDecimal;
import java.util.Optional;

public interface ExRatesService {

    boolean isDataInit();

    ExRateDTO fetchExRates();

    void updateExRates(ExRateDTO exRateDTO);

    Optional<BigDecimal> getExRate(String from, String to);

    BigDecimal convert(String from, String to, BigDecimal amount);
}
