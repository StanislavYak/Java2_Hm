package ru.hm.hm8;

public interface AuthService {
    String getNick(String login, String pass);

    boolean login(String login, String pass);

    boolean contains(String userName);
}