package com.wallum.systems.accountingcore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.UUID;

class JournalEntryTest {

    private static final UUID VALID_ID = UUID.randomUUID();
    private static final Account VALID_DEBIT_ACCOUNT = new Account();
    private static final Account VALID_CREDIT_ACCOUNT = new Account();
    private static final double VALID_AMOUNT = 1;
    private static final Date VALID_DATE = Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC));
    private static final String VALID_DESCRIPTION = "description";

    private static final JournalEntry.Builder builder = new JournalEntry.Builder();

    @BeforeEach
    void setUp() {
        builder.id(VALID_ID)
                .debitAccount(VALID_DEBIT_ACCOUNT)
                .creditAccount(VALID_CREDIT_ACCOUNT)
                .amount(VALID_AMOUNT)
                .date(VALID_DATE)
                .description(VALID_DESCRIPTION);
    }

    @Test
    void testBuilderValidData() {
        JournalEntry entry = builder.build();
        Assertions.assertNotNull(entry);
        Assertions.assertEquals(VALID_ID, entry.getId());
        Assertions.assertEquals(VALID_DEBIT_ACCOUNT, entry.getDebitAccount());
        Assertions.assertEquals(VALID_CREDIT_ACCOUNT, entry.getCreditAccount());
        Assertions.assertEquals(VALID_AMOUNT, entry.getAmount());
        Assertions.assertEquals(VALID_DATE, entry.getDate());
        Assertions.assertEquals(VALID_DESCRIPTION, entry.getDescription());
    }

    @Test
    void testBuilderNullId() {
        // Given
        builder.id(null);
        // Then
        Assertions.assertThrows(AssertionError.class, builder::build);
    }

    @Test
    void testBuilderNullDebitAccount() {
        // Given
        builder.debitAccount(null);
        // Then
        Assertions.assertThrows(AssertionError.class, builder::build);
    }

    @Test
    void testBuilderNullCreditAccount() {
        // Given
        builder.creditAccount(null);
        // Then
        Assertions.assertThrows(AssertionError.class, builder::build);
    }

    @Test
    void testBuilderAmountZero() {
        // Given
        builder.amount(0);
        // Then
        Assertions.assertThrows(AssertionError.class, builder::build);
    }

    @Test
    void testBuilderNullDate() {
        // Given
        builder.date(null);
        // Then
        Assertions.assertThrows(AssertionError.class, builder::build);
    }

    @Test
    void testBuilderNullDescription() {
        // Given
        builder.description(null);
        // Then
        Assertions.assertThrows(AssertionError.class, builder::build);
    }

    @Test
    void testBuilderEmptyDescription() {
        // Given
        builder.description("");
        // Then
        Assertions.assertThrows(AssertionError.class, builder::build);
    }

    @Test
    void testBuilderBlankDescription() {
        // Given
        builder.description(" ");
        // Then
        Assertions.assertThrows(AssertionError.class, builder::build);
    }
}