package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "credit_cards")
public class CreditCard extends BillingDetail {

    @Column(name = "card_type", nullable = false, length = 30)
    private String cardType;

    @Column(name = "expiration_month", nullable = false)
    private Short expirationMonth;

    @Column(name = "expiration_year", nullable = false)
    private Short expirationYear;
}
