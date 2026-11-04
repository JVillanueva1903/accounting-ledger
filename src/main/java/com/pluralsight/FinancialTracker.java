package com.pluralsight;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Capstone skeleton – personal finance tracker.
 * ------------------------------------------------
 * File format  (pipe-delimited)
 *     yyyy-MM-dd|HH:mm:ss|description|vendor|amount
 * A deposit has a positive amount; a payment is stored
 * as a negative amount.
 *
 * TODO: create the Transaction class in this package first.
 *       One object = one line of the file. Decide its fields from
 *       the file format above, add a constructor and getters.
 *       This class does not compile until Transaction exists.
 */
public class FinancialTracker {

    /* ------------------------------------------------------------------
       Shared data and formatters
       ------------------------------------------------------------------ */
    private static final ArrayList<Transaction> transactions = new ArrayList<>();
    private static final String FILE_NAME = "transactions.csv";

    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final String TIME_PATTERN = "HH:mm:ss";
    private static final String DATETIME_PATTERN = DATE_PATTERN + " " + TIME_PATTERN;

    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern(DATE_PATTERN);
    private static final DateTimeFormatter TIME_FMT = DateTimeFormatter.ofPattern(TIME_PATTERN);
    private static final DateTimeFormatter DATETIME_FMT = DateTimeFormatter.ofPattern(DATETIME_PATTERN);

    /* ------------------------------------------------------------------
       Main menu
       ------------------------------------------------------------------ */
    public static void main(String[] args) {
        loadTransactions(FILE_NAME);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to TransactionApp");
            System.out.println("Choose an option:");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");

            String input = scanner.nextLine().trim();

            switch (input.toUpperCase()) {
                case "D" -> addDeposit(scanner);
                case "P" -> addPayment(scanner);
                case "L" -> ledgerMenu(scanner);
                case "X" -> running = false;
                default -> System.out.println("Invalid option");
            }
        }
        scanner.close();
    }

    /* ------------------------------------------------------------------
       File I/O
       ------------------------------------------------------------------ */

    /**
     * Load transactions from FILE_NAME.
     * • If the file doesn’t exist, create an empty one so that future writes succeed.
     * • Each line looks like: date|time|description|vendor|amount
     */
    public static void loadTransactions(String fileName) {
        // TODO: create file if it does not exist, then read each line,
        //       parse the five fields, build a Transaction object,
        //       and add it to the transactions list.
    }

    /* ------------------------------------------------------------------
       Add new transactions
       ------------------------------------------------------------------ */

    /**
     * Prompt for ONE date+time string in the format
     * "yyyy-MM-dd HH:mm:ss", plus description, vendor, amount.
     * Validate that the amount entered is positive.
     * Store the amount as-is (positive) and append to the file.
     */
    private static void addDeposit(Scanner scanner) {
        // TODO
    }

    /**
     * Same prompts as addDeposit.
     * Amount must be entered as a positive number,
     * then converted to a negative amount before storing.
     */
    private static void addPayment(Scanner scanner) {
        // TODO
    }

    /* ------------------------------------------------------------------
       Ledger menu
       ------------------------------------------------------------------ */
    private static void ledgerMenu(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("Ledger");
            System.out.println("Choose an option:");
            System.out.println("A) All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");

            String input = scanner.nextLine().trim();

            switch (input.toUpperCase()) {
                case "A" -> displayLedger();
                case "D" -> displayDeposits();
                case "P" -> displayPayments();
                case "R" -> reportsMenu(scanner);
                case "H" -> running = false;
                default -> System.out.println("Invalid option");
            }
        }
    }

    /* ------------------------------------------------------------------
       Display helpers: show data in neat columns
       ------------------------------------------------------------------ */
    private static <Transaction> void displayLedger() {
        // TODO – print all transactions in column format, newest first
        System.out.printf("%-15s %-30s %10s%n", "Date", "Description", "Amount");
        System.out.println("-----------------------------------------------------------");

        for (int i = transactions.size() - 1; i >= 0; i--) {
            FinancialTracker.Transaction t = transactions.get(i);
            System.out.printf("%-15s %-30s %10.2f%n",
                    t.getDate(),
                    t.getDescription(),
                    t.getAmount());
        }
    }

    private static <Transaction> void displayDeposits() {
        // TODO – only amount > 0
        System.out.printf("%-15s %-30s %10s%n", "Date", "Description", "Amount");
        System.out.println("-----------------------------------------------------------");

        for (int i = transactions.size() - 1; i >= 0; i--) {
            FinancialTracker.Transaction t = transactions.get(i);

            if (t.getAmount() <= 0) {
                continue;
            }
            System.out.printf("%-15s %-30s %10.2f%n",
                    t.getDate(),
                    t.getDescription(),
                    t.getAmount());
        }
    }

    private static <Transaction> void displayPayments() {
        // TODO – only amount < 0
        System.out.printf("%-15s %-30s %10s%n", "Date", "Description", "Amount");
        System.out.println("-----------------------------------------------------------");

        for (int i = transactions.size() - 1; i >= 0; i--) {
            FinancialTracker.Transaction t = transactions.get(i);

            if (t.getAmount() < 0) {
                System.out.printf("%-15s %-30s %10.2f%n",
                        t.getDate(),
                        t.getDescription(),
                        t.getAmount());
            }
        }
    }
    /* ------------------------------------------------------------------
       Reports menu
       ------------------------------------------------------------------ */
    private static void reportsMenu(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("Reports");
            System.out.println("Choose an option:");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("6) Custom Search");
            System.out.println("0) Back");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> {/* TODO – month-to-date report */ }
                case "2" -> {/* TODO – previous month report */ }
                case "3" -> {/* TODO – year-to-date report   */ }
                case "4" -> {/* TODO – previous year report  */ }
                case "5" -> {/* TODO – prompt for vendor then report */ }
                case "6" -> customSearch(scanner);
                case "0" -> running = false;
                default -> System.out.println("Invalid option");
            }
        }
    }

    /* ------------------------------------------------------------------
       Reporting helpers
       ------------------------------------------------------------------ */
    private static void filterTransactionsByDate(LocalDate start, LocalDate end) {
        // TODO – iterate transactions, print those within the range
        for (Transaction transaction : transactions) {
            LocalDate date = LocalDate.from(transaction.getDate());

            if ((date.isEqual(start) || date.isAfter(start)) &&
                    (date.isEqual(end) || date.isBefore(end))) {
                System.out.println(transaction);
            }
        }
    }

    private static void filterTransactionsByVendor(String vendor) {
        // TODO – iterate transactions, print those with matching vendor
        for (Transaction transaction : transactions) {
            if (transaction.getVendor().equalsIgnoreCase(vendor)) {
                System.out.println(transaction);
            }
        }
    }

    private static void customSearch(Scanner scanner) {
        // TODO – prompt for any combination of date range, description,
        //        vendor, and exact amount, then display matches

        System.out.print("Start date (yyyy-MM-dd, leave blank to skip): ");
        String startInput = scanner.nextLine();

        System.out.print("End date (yyyy-MM-dd, leave blank to skip): ");
        String endInput = scanner.nextLine();

        System.out.print("Description (leave blank to skip): ");
        String description = scanner.nextLine();

        System.out.print("Vendor (leave blank to skip): ");
        String vendor = scanner.nextLine();

        System.out.print("Exact amount (leave blank to skip): ");
        String amountInput = scanner.nextLine();

        LocalDate startDate = startInput.isBlank() ? null : LocalDate.parse(startInput);
        LocalDate endDate = endInput.isBlank() ? null : LocalDate.parse(endInput);
        Double amount = amountInput.isBlank() ? null : Double.parseDouble(amountInput);

        for (Transaction transaction : transactions) {
            boolean match = true;

            if (startDate != null) {
                assert transaction.getDate() != null;
                if (!transaction.getDate().isBefore(LocalTime.from(startDate))) {
                } else {
                    match = false;
                }
            }

            if (endDate != null &&
                    transaction.getDate().isAfter(LocalTime.from(endDate))) {
                match = false;
            }

            if (!description.isBlank() &&
                    !Boolean.parseBoolean(transaction.getDescription().getClass().toString())) {
                match = false;
            }

            if (!vendor.isBlank() &&
                    !transaction.getVendor().equalsIgnoreCase(vendor)) {
                match = false;
            }

            if (amount != null &&
                    transaction.getAmount() != amount) {
                match = false;
            }

            if (match) {
                System.out.println(transaction);
            }
        }
    }

    /* ------------------------------------------------------------------
           Utility parsers (you can reuse in many places)
           ------------------------------------------------------------------ */
    private static LocalDate parseDate(String s) {
        /* TODO – return LocalDate or null */
        try {
            return LocalDate.parse(s);
        } catch (Exception e) {
            return null;
        }
    }

    private static Double parseDouble(String s) {
            /* TODO – return Double or null */
            try {
                return Double.parseDouble(s);
            } catch (Exception e) {
                return null;
            }
        }

    public class Transaction {
        public String getVendor() {
            return null;
        }

        public LocalTime getDate() {
            return null;
        }

        public Object getDescription() {
            return null;
        }

        public int getAmount() {
            return 0;
        }
    }
}


