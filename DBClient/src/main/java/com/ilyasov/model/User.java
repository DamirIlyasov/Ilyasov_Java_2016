package com.ilyasov.model;

import com.ilyasov.dao.UserDAO;
import com.ilyasov.enums.ApplicationMessages;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private long id;
    private String name;
    private String surname;


    static List<News> getNewsByUserId(long id ){
        UserDAO userDAO = new UserDAO();
        try {
            return userDAO.getOneUsersNews(id);
        } catch (SQLException e) {
            System.out.println(ApplicationMessages.OPERATION_IS_NOT_COMPLETED);
        }
        return null;
    }
    public static void getUsersNews(){
        System.out.println("Введите id пользователя, чьи новости вы хотите посмотреть");
        Scanner scanner = new Scanner(System.in);
        try{
            long id = Long.parseLong(scanner.nextLine());
            System.out.println(getNewsByUserId(id));
        }catch (NumberFormatException e){
            System.out.println(ApplicationMessages.INCORRECT_DATA);
        }
    }
    public static void getTheMostActiveRecipient() {
        UserDAO userDAO = new UserDAO();
        System.out.println("За какое время года вы хотите посмотреть статистику?" +
                "1)Зима" +
                "2)Весна" +
                "3)Лето" +
                "4)Осень");
        Scanner scanner = new Scanner(System.in);
        try {
            int season = Integer.parseInt(scanner.nextLine());
            System.out.println(userDAO.getTheMostActiveRecipient(season));
        } catch (SQLException | NumberFormatException e) {
            System.out.println(ApplicationMessages.OPERATION_IS_NOT_COMPLETED);
        }
    }

    public static void addToDatabase(){
        UserDAO userDAO = new UserDAO();
        try {
            userDAO.addUser();
        } catch (SQLException e) {
            System.out.println(ApplicationMessages.OPERATION_IS_NOT_COMPLETED);
        }
    }
    private void setId(long id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setSurname(String surname) {
        this.surname = surname;
    }

    public static List<User> buildListOfUsers(ResultSet resultSet) throws SQLException {
        List<User> users = new ArrayList<User>();
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getLong(1));
            user.setName(resultSet.getString(2));
            user.setSurname(resultSet.getString(3));
            users.add(user);
        }
        return users;
    }

  public static void getTheMostActiveVolunteerByAdress(String regEx){
      UserDAO userDAO = new UserDAO();
      try {
          userDAO.getTheMostActiveVolunteer(regEx);
      } catch (SQLException e) {
          System.out.println(ApplicationMessages.OPERATION_IS_NOT_COMPLETED);
      }
  }
  public static void getTheMostActiveVolunteer(){
      System.out.println("По какому адресу будем сортировать?");
      Scanner scanner = new Scanner(System.in);
      String regEx = scanner.nextLine();
      getTheMostActiveVolunteerByAdress(regEx);
  }
  public static void getThePercentageOfBannedUsers(){
      UserDAO userDAO = new UserDAO();
      try {
          System.out.println(userDAO.getThePercentageOfBannedUsers()+" %");
      } catch (SQLException e) {
          System.out.println(ApplicationMessages.OPERATION_IS_NOT_COMPLETED);
      }
  }
    @Override
    public String toString() {
        return "Информация о пользователе{" +
                "id:" + id + "\n" +
                "Имя:" + name + '\n' +
                "Фамилия:" + surname + '\n' +
                '\n';
    }
}
