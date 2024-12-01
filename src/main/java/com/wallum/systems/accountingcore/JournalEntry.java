package com.wallum.systems.accountingcore;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
public class JournalEntry {
    private final UUID id;
    private final Account debitAccount;
    private final Account creditAccount;
    private final double amount;
    private final Date date;
    private final String description;

    private JournalEntry(UUID id, Account debitAccount, Account creditAccount, double amount, Date date, String description) {
        this.id = id;
        this.debitAccount = debitAccount;
        this.creditAccount = creditAccount;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public static class Builder {
        private UUID id;
        private Account debitAccount;
        private Account creditAccount;
        private double amount;
        private Date date;
        private String description;
        public Builder id(UUID id) {
            this.id = id;
            return this;
        }
        public Builder debitAccount(Account debitAccount) {
            this.debitAccount = debitAccount;
            return this;
        }
        public Builder creditAccount(Account creditAccount) {
            this.creditAccount = creditAccount;
            return this;
        }
        public Builder amount(double amount) {
            this.amount = amount;
            return this;
        }
        public Builder date(Date date) {
            this.date = date;
            return this;
        }
        public Builder description(String description) {
            this.description = description;
            return this;
        }
        public JournalEntry build() {
            assert id != null : "id is null";
            assert debitAccount != null : "debitAccount is null";
            assert creditAccount != null : "creditAccount is null";
            assert amount != 0 : "amount is zero";
            assert date != null : "date is null";
            assert description != null : "description is null";
            assert !description.isEmpty() : "description is empty";
            assert !description.isBlank() : "description is blank";
            return new JournalEntry(id, debitAccount, creditAccount, amount, date, description);
        }
    }
}
