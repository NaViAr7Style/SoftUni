package bg.softuni.springdataintro.services;

import java.math.BigDecimal;

public interface AccountService {

    void withdrawMoney(BigDecimal money, Long id);

    void depositMoney(BigDecimal money, Long id);
}
