import java.io.Serializable;

public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name; 
    private String email;
    private Integer age;
    private String phone;

    public Contact (String name, String email, int age, String phone){
        this.name = name;
        this.email=email;
        this.age=age;
        this.phone=phone;
        

    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String print(){
        return "Contact{" +
                "name='" + name +'\''+
                ", email='"+ email+'\''+
                ", age='"+ age +'\''+
                ", phone'" + phone+'\'' +
                '}';
    }
}
