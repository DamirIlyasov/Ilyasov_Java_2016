package com.ilyasov;

import com.ilyasov.DAO.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String commands ="Доступные команды: " + '\n' +
                "1)Добавить пользователя" + '\n' +
                "2)Написать сообщение" + '\n' +
                "3)Оставить заявку" + '\n' +
                "4)Изменить новость" + '\n' +
                "5)Изменить сообщество" + '\n' +
                "6)Посмотреть новости одного пользователя" + '\n' +
                "7)Показать пользователя, который получил больше всех сообщений" + '\n' +
                "8)Показать самого активного волонтёра" + '\n' +
                "Для выхода из программы введите 0";
        boolean check = true;
        String request;
        while (check) {
            System.out.println("Введите номер команды.");
            System.out.println(commands);
            request = scanner.nextLine();

            if (request.equals("1")) {
                UserDAO userDAO = new UserDAO();
                try {
                    userDAO.addUser();
                    userDAO = null;
                } catch (SQLException e) {
                    System.out.println("Не удалось добавить пользователя, возникла ошибка.");
                }
            }
            if (request.equals("3")) {
                RequestDAO requestDAO = new RequestDAO();
                try {
                    requestDAO.addRequest();
                    requestDAO = null;
                } catch (SQLException e) {
                    System.out.println("Не удалось добавить заявку, возникла ошибка.");
                }
            }
            if (request.equals("2")) {
                MessageDAO messageDAO = new MessageDAO();
                try {
                    messageDAO.addMessage();
                    messageDAO = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Не удалось написать сообщение, возникла ошибка.");
                }
            }
            if (request.equals("4")) {
                NewsDAO newsDAO = new NewsDAO();
                try {
                    newsDAO.changeNews();
                    newsDAO = null;
                } catch (SQLException e) {
                    System.out.println("Не удалось изменить новость, возникла ошибка");
                }
            }
            if (request.equals("5")) {
                CommunityDAO communityDAO = new CommunityDAO();
                communityDAO.chooseCommunity();
                System.out.println("Сообщество выбрано! Как вы хотите изменить это сообщество?");
                while (true) {
                    System.out.println("Доступные команды: " +
                            "1)Переименовать " +
                            "2)Изменить описание" +
                            "Для завершения работы с данным сообществом введите 0");
                    String checkCommunityCommand = scanner.nextLine();
                    if (checkCommunityCommand.equals("1")) {
                        try {
                            communityDAO.renameCommunity();
                            communityDAO = null;
                        } catch (SQLException e) {
                            System.out.println("Не удалось переименовать сообщество, возникла ошибка!");
                        }
                    } else if (checkCommunityCommand.equals("2")) {
                        try {
                            communityDAO.changeDescription();
                            communityDAO = null;
                        } catch (SQLException e) {
                            System.out.println("Не удалось изменить описание, возникла ошибка!");
                        }
                    } else if (checkCommunityCommand.equals("0")) {
                        System.out.println("Прекращаем работу с данным сообществом.");
                        break;
                    }
                }
            }
            if (request.equals("6")) {
                OneUserNews oneUserNews = new OneUserNews();
                try {
                    System.out.println(oneUserNews.getOneUsersNews());
                    oneUserNews = null;
                } catch (SQLException e) {
                    System.out.println("Не удалось посмотреть новости, возникла ошибка!");
                }
            }
            if (request.equals("7")) {
                MostActiveRecipient mostActiveRecipient = new MostActiveRecipient();
                try {
                    System.out.println(mostActiveRecipient.getTheMostActiveRecipient());
                    mostActiveRecipient = null;
                } catch (SQLException e) {
                    System.out.println("Не удалось показать пользователя, произошла ошибка!");
                }
            }
            if (request.equals("8")) {
                MostActiveVolunteer mostActiveVolunteer = new MostActiveVolunteer();
                try {
                    System.out.println(mostActiveVolunteer.getTheMostActiveVolunteer());
                    mostActiveVolunteer = null;
                } catch (SQLException e) {
                    System.out.println("Не удалось показать самого активного волонтёра");
                }
            }
            if (request.equals("0")) {
                System.out.println("Завершаем работу");
                check = false;
            }
            else {
                System.out.println("Вы ввели неверный номер команды.");
            }
        }
    }
}
