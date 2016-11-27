package com.ilyasov.model;

import com.ilyasov.dao.CommunityDAO;
import com.ilyasov.enums.ApplicationMessages;

import java.sql.SQLException;
import java.util.Scanner;

public class Community {
    Scanner scanner = new Scanner(System.in);
    String name;

    public void chooseCommunity() {
        System.out.println("Введите название сообщества, которое хотите изменить");
        Scanner scanner = new Scanner(System.in);
        this.name = scanner.nextLine();
        System.out.println("Сообщество выбрано!");
    }

    public static void changeCommunity() {
        boolean check = true;
        int comand = 0;
        Community community = new Community();
        community.chooseCommunity();
        System.out.println("Как вы хотите изменить данное сообщество?" +
                "1)Переименовать" +
                "2)Изменить описание");
        try {
            while (check) {
                comand = Integer.parseInt(community.scanner.nextLine());
                switch (comand) {
                    case 1: {
                        CommunityDAO communityDAO = new CommunityDAO();
                        communityDAO.renameCommunity();
                        check = false;
                        break;
                    }
                    case 2: {
                        CommunityDAO communityDAO = new CommunityDAO();
                        communityDAO.changeDescription();
                        check = false;
                        break;
                    }
                    default: {
                        System.out.println(ApplicationMessages.INCORRECT_DATA);
                        System.out.println("Введите номер команды снова.");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(ApplicationMessages.OPERATION_IS_NOT_COMPLETED);
        }
    }
}
