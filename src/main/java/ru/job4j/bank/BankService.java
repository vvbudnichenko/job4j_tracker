package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс реализует методы для управления банковскими операциями, такими как:
 * добавление и удаление пользователя, добавление банковского счета,
 * поиск пользователя по номеру паспорта, поиск банковского счета по реквизитам,
 * перевод денег с одного счета на другой, и получение всех счетов одного пользователя.
 *
 * @author Vladimir Budnichenko
 * @version 1.0
 */
public class BankService {
    /**
     * Коллекция, в которой данные пользователей хранятся в HashMap.
     * Ключом является объект класса User, а значением — список
     * связанных с ним аккаунтов (объекты класса Account).
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет нового пользователя в коллекцию.
     * Если пользователь уже существует, добавление не выполняется.
     *
     * @param user добавляется в коллекцию users
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаляет пользователя из коллекции на основе паспортных данных.
     * Если пользователь с указанным псспортом не найден, ничего не происходит.
     *
     * @param passport паспортные данные пользователя для удаления
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Добавляет аккаунт для пользователя по его паспортным данным.
     * Если аккаунт уже существует, добавление не выполняется.
     *
     * @param passport паспортные данные
     * @param account  данные аккаунта для добавления в коллекцию
     */
    public void addAccount(String passport, Account account) {
        User member = findByPassport(passport);
        if (member != null) {
            List<Account> allAccounts = getAccounts(member);
            if (!allAccounts.contains(account)) {
                allAccounts.add(account);
            }
        }
    }

    /**
     * Поиск пользователя по данным паспорта.
     *
     * @param passport паспортные данные
     * @return возвращает найденного пользователя или null
     */
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

    /**
     * Ищет аккаунт по паспортным данным и реквизитам счета.
     *
     * @param passport  паспортные данные пользователя
     * @param requisite реквизиты счета
     * @return найденный аккаунт или null, если аккаунт не найден
     */
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

    /**
     * Метод переводить деньги с одного счета на другой счет.
     * Если счет не найден или на счете недостаточно средств, перевод не выполняется.
     *
     * @param sourcePassport       паспортные данные счета, с которого переводят деньги
     * @param sourceRequisite      данные реквизита, с которого переводят деньги
     * @param destinationPassport  паспортные данные счета, на который переводят деньги
     * @param destinationRequisite данные реквизита, на который переводят деньги
     * @param amount               денежная сумма для осуществления перевода
     * @return возвращает true если перевод выполнен, и false если нет
     */
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

    /**
     * Возвращает список аккаунтов, связанных с искомым пользователем.
     *
     * @param user пользователь, по которому осуществляется поиск
     * @return список аккаунтов, принадлежащих пользователю, или null,
     * если пользователь не найден
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}