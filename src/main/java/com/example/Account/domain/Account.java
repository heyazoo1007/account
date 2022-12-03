package com.example.Account.domain;

import com.example.Account.exception.AccountException;
import com.example.Account.type.AccountStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import static com.example.Account.type.ErrorCode.AMOUNT_EXCEED_BALANCE;
import static com.example.Account.type.ErrorCode.INVALID_REQUEST;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Account extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private AccountUser accountUser;

    private String accountNumber;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    private Long balance;

    private LocalDateTime registeredAt;

    private LocalDateTime unRegisteredAt;

    // 중요한 로직은 entity 안에 작성하기
    public void useBalance(Long amount) {
        if (amount > balance) {
            throw new AccountException(AMOUNT_EXCEED_BALANCE);
        }
        balance -= amount;
    }

    public void cancelBalance(Long amount) {
        if (amount < 0) {
            throw new AccountException(INVALID_REQUEST);
        }
        balance += amount;
    }
}
