package service;

import databaseConnection.DatabaseConnection;
import domain.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 12/14/2016.
 */
public class UserService {

    public User getUser(String name, String password){
        User user=null;

        String query= "select * from user where name=? and password=?";

        PreparedStatement pstm =new DatabaseConnection().getPreparedStatement(query);

        try {

            pstm.setString(1, name);
            pstm.setString(2,password);
            ResultSet rs= pstm.executeQuery();

            while (rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  user;


    }

    public List<User> getUserList(){
        List<User> userList =new ArrayList<User>();
        String query="select * from user";
        PreparedStatement pstm =new DatabaseConnection().getPreparedStatement(query);

        try {
            ResultSet rs=pstm.executeQuery();

            while (rs.next()){
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));

                userList.add(user);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public  void addUser(User newUser){


        String query = "insert into user(name,password,role) values(?,?,?)";
        PreparedStatement pstm =new DatabaseConnection().getPreparedStatement(query);

        try {
            pstm.setString(1,newUser.getName());
            pstm.setString(2,newUser.getPassword());
            pstm.setString(3,newUser.getRole());

            pstm.execute();
            System.out.println("executed");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(int id){

        String query="delete from user where id=?";
        PreparedStatement pstm= new DatabaseConnection().getPreparedStatement(query);

        try {
            pstm.setInt(1, id);
            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public User findUser(int id){
        User user=null;

        String query= "select * from user where id=?";

        PreparedStatement pstm =new DatabaseConnection().getPreparedStatement(query);

        try {

            pstm.setInt(1, id);

            ResultSet rs= pstm.executeQuery();

            while (rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  user;


    }
    public void updateUser(int id, User user){

        String query= "update user set name=? ,password=? ,role=? where id=?";

        PreparedStatement pstm =new DatabaseConnection().getPreparedStatement(query);

        try {
            pstm.setString(1, user.getName());
            pstm.setString(2, user.getPassword());
            pstm.setString(3, user.getRole());
            pstm.setInt(4, id);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
