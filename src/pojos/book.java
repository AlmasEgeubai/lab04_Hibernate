package pojos;
// Generated Oct 17, 2020 12:29:09 PM by Hibernate Tools 4.3.1

/**
 * book generated by hbm2java
 */
public class book implements java.io.Serializable {

    private Integer id;
    private String date;
    private String name;
    private String city;
    private String num;

    public book() {
    }

    public book(String date) {
        this.date = date;
    }

    public book(String date, String name, String city, String num) {
        this.date = date;
        this.name = name;
        this.city = city;
        this.num = num;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNum() {
        return this.num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Дата: " + date + ", Имя: " + name + ", Город: " + city + ", Номер: " + num;
    }

}
