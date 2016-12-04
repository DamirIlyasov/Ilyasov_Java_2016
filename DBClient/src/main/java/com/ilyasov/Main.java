package com.ilyasov;

import com.ilyasov.dao.*;
import com.ilyasov.enums.ApplicationMessages;
import com.ilyasov.model.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        String request;
        while (check) {
            System.out.println("Введите номер команды.");
            System.out.println(ApplicationMessages.COMMANDS);
            request = scanner.nextLine();

            switch (request) {
                case "1": {
                    User.addToDatabase();
                    break;
                }
                case "2": {
                    Message.addToDatabase();
                    break;
                }
                case "3": {
                    Request.addToDatabase();
                    break;
                }
                case "4": {
                    News.change();
                    break;
                }
                case "5": {
                    Community.changeCommunity();
                    break;
                }
                case "6": {
                    User.getUsersNews();
                    break;
                }
                case "7": {
                    User.getTheMostActiveRecipient();
                    break;
                }
                case "8": {
                    User.getTheMostActiveVolunteer();
                    break;
                }
                case "9": {
                    User.getThePercentageOfBannedUsers();
                    break;
                }
                case "0": {
                    System.out.println("Завершаем работу");
                    check = false;
                    break;
                }
                default:
                    System.out.println("Вы ввели неверный номер команды");
            }
        }
    }
}
