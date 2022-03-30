import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Main {

    public static void main(String[] args) {
        List<Account> accounts = Arrays.asList(
                new Account("1", 100, AccountState.ACTIVE),
                new Account("2", -1000, AccountState.BLOCKED),
                new Account("3", 5, AccountState.REMOVED),
                new Account("4", 10000, AccountState.ACTIVE),
                new Account("5", -100, AccountState.BLOCKED)
        );
        // хотим получит MAP ключами которого являются uuid а значениями Balance

        //toMap
        Map<String, Long> balanceByUUID = accounts.stream()
                .collect(toMap(Account::getUuid, Account::getBalance));

        // toCollection
        List<Account> accounts2 = accounts.stream()
                .collect(Collectors.toCollection(() -> new ArrayList<>()));

        //partitioningBy
        Map<Boolean, List<Account>> partitioningByBalance = accounts.stream()
                .collect(partitioningBy((acc) -> acc.getBalance() > 0));

        System.out.println(partitioningByBalance);

        // groupingBy
        Map<AccountState, List<Account>> groupingByState = accounts.stream()
                .collect(groupingBy(Account::getState));
        System.out.println(groupingByState);

        //summing, averaging, max, counting
        System.out.println(accounts.stream().collect(counting()));

        long totalBalance = accounts.stream()
                .collect(summingLong(acc -> acc.getBalance()));

        Account richestAccount = accounts.stream()
                .collect(maxBy(Account::compareTo))
                .orElseThrow();
        System.out.println(richestAccount);

        double averageBalance = accounts.stream()
                .collect(averagingDouble(Account::getBalance));
        System.out.println(averageBalance);

        //reducing
        long totalBalance2 = accounts.stream()
                .collect(reducing(0L, Account::getBalance, (res, currentBalance) -> res + currentBalance));

        //Downstream collectors
        //Пример. Хотим посчитать для кажлого accountState суммарный балланс соответствующих аккаунтов

        Map<AccountState, Long> totalBalanceByAccountState = accounts.stream()
                .collect(groupingBy(Account::getState, summingLong(Account::getBalance)));//summingLong - коллектор
    }
}

class Account implements Comparable<Account> {
    String uuid;
    long balance;
    AccountState state;

    public Account(String uuid, long balance, AccountState state) {
        this.uuid = uuid;
        this.balance = balance;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Account{" +
                "uuid='" + uuid + '\'' +
                ", balance=" + balance +
                ", state=" + state +
                '}';
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    public String getUuid() {
        return uuid;
    }

    public long getBalance() {
        return balance;
    }

    public AccountState getState() {
        return state;
    }

    @Override
    public int compareTo(Account o) {
        return Long.compare(this.balance, o.balance);
    }
}

enum AccountState {
    REMOVED, ACTIVE, BLOCKED
}
