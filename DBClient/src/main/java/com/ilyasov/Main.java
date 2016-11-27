package com.ilyasov;

import com.ilyasov.database.*;
import com.ilyasov.reports.MostActiveRecipient;
import com.ilyasov.reports.MostActiveVolunteer;
import com.ilyasov.reports.OneUserNews;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by damir on 18.11.16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        String request;
        checkpoint:
        while (check) {
            System.out.println("Введите команду.");
            System.out.println("Доступные команды: Добавить пользователя, Написать сообщение, " +
                    "Оставить заявку, Изменить новость, Изменить сообщество, Посмотреть новости одного пользователя, " +
                    "Показать пользователя, который получил больше всех сообщений," +
                    "Показать самого активного волонтёра");
            request = scanner.nextLine();

            if (request.equals("Добавить пользователя")) {
                UserDAO userDAO = new UserDAO();
                try {
                    userDAO.addUser();
                    userDAO = null;
                } catch (SQLException e) {
                    System.out.println("Не удалось добавить пользователя, возникла ошибка.");
                }
            }
            if (request.equals("Оставить заявку")) {
                RequestDAO requestDAO = new RequestDAO();
                try {
                    requestDAO.addRequest();
                    requestDAO = null;
                } catch (SQLException e) {
                    System.out.println("Не удалось добавить заявку, возникла ошибка.");
                }
            }
            if (request.equals("Написать сообщение")) {
                MessageDAO messageDAO = new MessageDAO();
                try {
                    messageDAO.addMessage();
                    messageDAO = null;
                } catch (SQLException e) {
                    System.out.println("Не удалось написать сообщение, возникла ошибка.");
                }
            }
            if (request.equals("Изменить новость")){
                NewsDAO newsDAO = new NewsDAO();
                    try {
                        newsDAO.changeNews();
                        newsDAO = null;
                    } catch (SQLException e) {
                        System.out.println("Не удалось изменить новость, возникла ошибка");
                    }
            }
            if (request.equals("Изменить сообщество")){
                CommunityDAO communityDAO = new CommunityDAO();
                communityDAO.chooseCommunity();
                System.out.println("Сообщество выбрано! Как вы хотите изменить это сообщество?");
                while (true) {
                    System.out.println("Доступные команды: Переименовать и Изменить описание");
                    String checkCommunityCommand = scanner.nextLine();
                    if (checkCommunityCommand.equals("Переименовать")) {
                        try {
                            communityDAO.renameCommunity();
                            communityDAO = null;
                        } catch (SQLException e) {
                            System.out.println("Не удалось переименовать сообщество, возникла ошибка!");
                        }
                    } else if (checkCommunityCommand.equals("Изменить описание")) {
                        try {
                            communityDAO.changeDescription();
                            communityDAO = null;
                        } catch (SQLException e) {
                            System.out.println("Не удалось изменить описание, возникла ошибка!");
                        }
                    } else if (checkCommunityCommand.equals("Выход")){
                        System.out.println("Прекращаем работу с данным сообществом.");
                        break;
                    }
                }
            }
            if (request.equals("Посмотреть новости одного пользователя")){
                OneUserNews oneUserNews = new OneUserNews();
                try {
                    System.out.println(oneUserNews.getOneUsersNews());
                    oneUserNews = null;
                } catch (SQLException e) {
                    System.out.println("Не удалось посмотреть новости, возникла ошибка!");
                }
            }
            if (request.equals("Показать пользователя, который получил больше всех сообщений")){
                MostActiveRecipient mostActiveRecipient = new MostActiveRecipient();
                try {
                    System.out.println(mostActiveRecipient.getTheMostActiveRecipient());
                    mostActiveRecipient = null;
                } catch (SQLException e) {
                    System.out.println("Не удалось показать пользователя, произошла ошибка!");
                }
            }
            if (request.equals("Показать самого активного волонтёра")){
                MostActiveVolunteer mostActiveVolunteer = new MostActiveVolunteer();
                try {
                    System.out.println(mostActiveVolunteer.getTheMostActiveVolunteer());
                    mostActiveVolunteer = null;
                } catch (SQLException e) {
                    System.out.println("Не удалось показать самого активного волонтёра");
                }
            }
            if (request.equals("Выйти из программы")){
                System.out.println("Завершаем работу");
                check = false;
            }
        }
    }
}
