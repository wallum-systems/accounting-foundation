package com.wallum.systems.accountingcore;

import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.UUID;

@RequiredArgsConstructor
public class JournalEntry {
    private UUID id;
    private Account debitAccount;
    private Account creditAccount;
    private double amount;
    private Date date;
    private String description;
}
