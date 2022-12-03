package com.example.Account.dto;

import com.example.Account.aop.AccountLockIdInterface;
import com.example.Account.type.TransactionResultType;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

public class CancelBalance {

    /**
     * {
     *     "transactionId": "skdhfkhk25hdksjfh",
     *     "accountNumber" : "1000000000",
     *     "amount": 1000
     * }
     */
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Request implements AccountLockIdInterface {
        @NotBlank
        private String transactionId;

        @NotBlank
        @Size(min = 10, max = 10)
        private String accountNumber;

        @NotNull
        @Min(10)
        @Max(1000_000_000)
        private Long amount;
    }

    /**
     * {
     *     "accountNumber" : "123456789",
     *     "transactionResult": "S",
     *     "transactionId": "dsfjsldf"
     *     "amount": 1000,
     *     "transactedAt": dsf
     * }
     */
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private String accountNumber;
        private TransactionResultType transactionResult;
        private String transactionId;
        private Long amount;
        private LocalDateTime transactedAt;

        public static CancelBalance.Response from(TransactionDto transactionDto) {
            return CancelBalance.Response.builder()
                    .accountNumber(transactionDto.getAccountNumber())
                    .transactionResult(transactionDto.getTransactionResultType())
                    .transactionId(transactionDto.getTransactionId())
                    .amount(transactionDto.getAmount())
                    .transactedAt(transactionDto.getTransactedAt())
                    .build();
        }
    }
}
