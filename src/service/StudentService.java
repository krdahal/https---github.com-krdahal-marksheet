package service;

import databaseConnection.DatabaseConnection;
import domain.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 12/18/2016.
 */
public class StudentService {


        public List<Student> getStudentList(){

            List<Student> studentList= new ArrayList<Student>();

            String query="select * from student";

            PreparedStatement pstm= new DatabaseConnection().getPreparedStatement(query);

            ResultSet rs= null;
            try {
                rs = pstm.executeQuery();

                while (rs.next()){
                    Student student=new Student();
                    student.setId(rs.getInt("id"));
                    student.setRollNumber(rs.getInt("rollNumber"));
                    student.setAge(rs.getInt("age"));
                    student.setName(rs.getString("name"));
                    student.setAddress(rs.getString("address"));
                    studentList.add(student);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return studentList;


        }

    public void studentAdd(Student student){

        String query="insert into student(rollNumber,age,name,address) values(?,?,?,?)";

        PreparedStatement pstm =new DatabaseConnection().getPreparedStatement(query);

        try {
            pstm.setInt(1, student.getRollNumber());
            pstm.setInt(2,student.getAge());
            pstm.setString(3,student.getName());
            pstm.setString(4,student.getAddress());
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  Student getStudent(int id){

        Student student=null;
        String query="select * from student where id=?";

        PreparedStatement pstm =new  DatabaseConnection().getPreparedStatement(query);

        try {
            pstm.setInt(1, id);
            ResultSet rs=pstm.executeQuery();

            while (rs.next()){

                student=new Student();
                student.setId(rs.getInt("id"));
                student.setRollNumber(rs.getInt("rollNumber"));
                student.setAge(rs.getInt("age"));
                student.setName(rs.getString("name"));
                student.setAddress(rs.getString("address"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    public void updateStudent(int id, Student student){

        String query="update student set rollNumber=?,age=?,name=?,address=? where id=?";


        PreparedStatement pstm= new DatabaseConnection().getPreparedStatement(query);

        try {
            pstm.setInt(1, student.getRollNumber());
            pstm.setInt(2,student.getAge());
            pstm.setString(3,student.getName());
            pstm.setString(4,student.getAddress());
            pstm.setInt(5, id);
            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public  void deleteStudent(int id){

        String query ="delete from student where id=?";

        PreparedStatement pstm= new DatabaseConnection().getPreparedStatement(query);

        try {
            pstm.setInt(1,id);
            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
