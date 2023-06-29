package bg.softuni.springdataintro.services;

import bg.softuni.springdataintro.models.Account;
import bg.softuni.springdataintro.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountServiceImpl implements  AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal money, Long id) {
        Optional<Account> accountOpt = accountRepository.findById(id);

        if (accountOpt.isEmpty()) {
            throw new IllegalArgumentException("Account is missing");
        }

        Account account = accountOpt.get();

        BigDecimal newAmount = account.getBalance().subtract(money);

        if (newAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Not enough money");
        }

        account.setBalance(newAmount);

        accountRepository.save(account);
    }

    @Override
    public void depositMoney(BigDecimal money, Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account is missing"));

        if (money.compareTo((BigDecimal.ZERO)) <= 0) {
            throw new IllegalArgumentException("No money to deposit");
        }

        BigDecimal newBalance = account.getBalance().add(money);
        account.setBalance(newBalance);

        accountRepository.save(account);
    }
}
