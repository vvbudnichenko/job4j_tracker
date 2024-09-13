package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(String passport) {
        for (User member : users.keySet()) {
            if (member.getPassport().equals(passport)) {
                users.remove(member);
                break;
            }
        }
    }

    public void addAccount(String passport, Account account) {
        User member = findByPassport(passport);
        if (member != null) {
            List<Account> allAccounts = getAccounts(member);
            if (!allAccounts.contains(account)) {
                allAccounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User member : users.keySet()) {
            if (member.getPassport().equals(passport)) {
                return member;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User member = findByPassport(passport);
        if (member == null) {
            return null;
        }
        List<Account> allAccounts = getAccounts(member);
        for (Account account : allAccounts) {
            if (account.getRequisite().equals(requisite)) {
                return account;
            }
        }
        return null;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        User sourceUser = findByPassport(sourcePassport);
        User destUser = findByPassport(destinationPassport);
        if (sourceUser == null || destUser == null) {
            return false;
        }
        Account sourceAccount = findByRequisite(sourceUser.getPassport(), sourceRequisite);
        Account destAccount = findByRequisite(destUser.getPassport(), destinationRequisite);
        if (sourceAccount == null | destAccount == null) {
            return false;
        }
        if (amount <= 0 || amount > sourceAccount.getBalance()) {
            return false;
        }
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destAccount.setBalance(destAccount.getBalance() + amount);
        return true;

    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}