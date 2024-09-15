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
        users.remove(new User(passport, ""));
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
        User result = null;
        for (User member : users.keySet()) {
            if (member.getPassport().equals(passport)) {
                result = member;
                break;
            }
        }
        return result;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User member = findByPassport(passport);
        if (member != null) {
            List<Account> allAccounts = getAccounts(member);
            for (Account account : allAccounts) {
                if (account.getRequisite().equals(requisite)) {
                    result = account;
                    break;
                }
            }
        }
        return result;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account sourceAccount = findByRequisite(findByPassport(sourcePassport).getPassport(), sourceRequisite);
        Account destAccount = findByRequisite(findByPassport(destinationPassport).getPassport(), destinationRequisite);
        if (sourceAccount != null && destAccount != null && amount > 0 && amount <= sourceAccount.getBalance()) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            result = true;
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}