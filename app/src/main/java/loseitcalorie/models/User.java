package loseitcalorie.models;

public class User {
    private int id;
    private String name, gender, activity, weight, age, duration;
    public User(int id, String name, String gender, String activity, String weight, String age, String duration) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.activity = activity;
        this.weight = weight;
        this.age = age;
        this.duration = duration;
    }

    public User(String name, String gender, String activity, String weight, String age, String duration) {
        this.name = name;
        this.gender = gender;
        this.activity = activity;
        this.weight = weight;
        this.age = age;
        this.duration = duration;
    }

    public User(int id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }
    
    

    public User(String name, String gender, String weight, String age) {
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.age = age;
    }

    public User(String name, String gender, String activity, String weight, String age) {
        this.name = name;
        this.gender = gender;
        this.activity = activity;
        this.weight = weight;
        this.age = age;
    }

    

    public User(String activity) {
        this.activity = activity;
    }

    

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
