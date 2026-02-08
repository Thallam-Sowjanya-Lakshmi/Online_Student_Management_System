package dao;
import java.sql.*;
import java.util.*;
import model.Student;
import util.DBConnection;


public class StudentDAO {
public static int save(Student s) {
int status = 0;
try {
Connection con = DBConnection.getConnection();
PreparedStatement ps = con.prepareStatement(
"INSERT INTO students(name,email,course,phone) VALUES(?,?,?,?)"
);
ps.setString(1, s.getName());
ps.setString(2, s.getEmail());
ps.setString(3, s.getCourse());
ps.setString(4, s.getPhone());
status = ps.executeUpdate();
} catch (Exception e) { e.printStackTrace(); }
return status;
}
public List<Student> getAllStudents() {
List<Student> list = new ArrayList<>();
try {
Connection con = DBConnection.getConnection();
PreparedStatement ps = con.prepareStatement("SELECT * FROM students");
ResultSet rs = ps.executeQuery();
while (rs.next()) {
Student s = new Student();
s.setId(rs.getInt("id"));
s.setName(rs.getString("name"));
s.setEmail(rs.getString("email"));
s.setCourse(rs.getString("course"));
s.setPhone(rs.getString("phone"));
list.add(s);
}
} 
catch (Exception e) { e.printStackTrace(); }
return list;
}
public List<Student> searchStudent(String keyword) {
    List<Student> list = new ArrayList<>();

    try {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM students WHERE id=? OR name LIKE ?"
        );

        ps.setInt(1, keyword.matches("\\d+") ? Integer.parseInt(keyword) : 0);
        ps.setString(2, "%" + keyword + "%");

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Student s = new Student();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setEmail(rs.getString("email"));
            s.setCourse(rs.getString("course"));
            s.setPhone(rs.getString("phone"));
            list.add(s);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}
public Student getStudentById(int id) {

    Student s = null;

    try {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM students WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            s = new Student();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setEmail(rs.getString("email"));
            s.setCourse(rs.getString("course"));
            s.setPhone(rs.getString("phone"));
        }

        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return s;
}

public void updateStudent(Student s) {

    boolean status = false;

    try {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "UPDATE students SET name=?, email=?, course=?, phone=? WHERE id=?"
        );
        ps.setString(1, s.getName());
        ps.setString(2, s.getEmail());
        ps.setString(3, s.getCourse());
        ps.setString(4, s.getPhone());
        ps.setInt(5, s.getId());
        ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void deleteStudent(int id) {
    try {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps =
            con.prepareStatement("DELETE FROM students WHERE id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}


}