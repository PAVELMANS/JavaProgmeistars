package com.pivanovs;

import java.util.Random;

public class SomeBankStuff {

    static Random rand = new Random();

    static class Bank {
        private int balance;

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public int getBalance() {
            return balance;
        }

        public void makeWithdrawal(int sum) {
            this.balance -= sum;
        }
    }

    static class Client extends Thread {
        private Bank account;

        @Override
        public void run() {
            do {
                int invoice = rand.nextInt(account.getBalance() + 1);
                account.setBalance(account.getBalance() - invoice);
            } while (account.getBalance() > 0);
            System.out.println(account.getBalance());
        }

        //@Override
        public synchronized void start(Bank b) {
            super.start();
            this.account = b;
        }
    }

    public static void makeItRain() {
        Bank account = new Bank();
        account.setBalance(500);
        Client client1 = new Client();
        Client client2 = new Client();

        client1.start(account);
        client2.start(account);
    }
}
