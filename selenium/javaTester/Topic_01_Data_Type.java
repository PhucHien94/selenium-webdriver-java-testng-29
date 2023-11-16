package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Topic_01_Data_Type {
    // Kieu du lieu trong Java - 2 nhom

    // I - Kieu du lieu nguyên thuỷ (Primitive Type)
    //8 loai
    // So nguyen : byte - short - int - long
    // ko có phần thập phân
    // Range
    byte bNumber = 40;
    short sNumber = 3000;
    int iNumber = 15635658;
    long lNumber = 234343400;

    // Số thực : float - double
    // có phần thập phân
    float fNumber = 9.99F;
    double dNumber = 9.99d;

    // Ki tu : char
    // Đại diện cho 1 ký tự
    char c = 'M';

    // Logic : Boolean - Chỉ có 2 giá trị true/ false
    boolean status1 = true;
    boolean status2 = false;

    // II - Kieu du lieu tham chiếu (Reference Type)
    // Class
    FirefoxDriver firefox = new FirefoxDriver();
    Select select = new Select(firefox.findElement(By.className("")));
    Topic_01_Data_Type topic01 = new Topic_01_Data_Type();

    // Interface
    WebDriver driver;
    JavascriptExecutor jsExecutor;

    // Object
    Object name = "Automation FC";

    // Array (kiểu nguyên thuỷ/ tham chiếu)
    int[] studentAge = {15,20,8};
    String[] studentName = {"Automation","Manual"};

    // Collection: List/ Set/ Queue
    List<String> studentAddress = new ArrayList<String>();
    List<String> studentCity = new LinkedList<>();
    List<String> studentPhone = new Vector<>();

    // String - Chuỗi ký tự
    String nameString = "Name";

    // Khai báo 1 biến để lưu trữ 1 loại dữ liệu
    // Access Modifier: Phạm vi truy cập (Public/ Private/ Protected/ Default)
    // Kiểu dữ liệu
    // Tên biến
    // Giá trị của biến - gán vào với phép =
    // Nếu như không gán : dữ liệu mặc định
    int numberStudent = 200;
}
