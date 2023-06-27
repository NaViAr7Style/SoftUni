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
@Table(name = "bank_accounts")
public class BankAccount extends BillingDetail{

    @Column(name = "bank_name", length = 50)
    private String bankName;

    @Column(name = "SWIFT_code", length = 50)
    private String swiftCode;
}
