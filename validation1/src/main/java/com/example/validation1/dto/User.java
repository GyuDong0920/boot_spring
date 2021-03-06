

import javax.validation.constraints.Email;

/**
{
  "name" : "홍길동",
  "age" : 10,
  "email" : "aanaver.com",
  "phonNumber" : "010-1234-1234"
}
 * 
 *
 */
public class User {

    private String name;
    private int age;
    @Email
    private String email;
    private String PhonNumber;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhonNumber() {
        return PhonNumber;
    }
    public void setPhonNumber(String phonNumber) {
        PhonNumber = phonNumber;
    }
    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + ", email=" + email + ", PhonNumber=" + PhonNumber + "]";
    }



}