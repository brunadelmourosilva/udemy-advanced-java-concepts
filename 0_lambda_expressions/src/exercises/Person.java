package exercises;

public class Person {

  private String name;
  private Integer age;
  private Double height;

  public Person(String name, Integer age, Double height) {
    this.name = name;
    this.age = age;
    this.height = height;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getHeight() {
    return height;
  }

  public void setHeight(Double height) {
    this.height = height;
  }

  @Override
  public String toString() {
    return "Person{" + "name='" + name + '\'' + ", age=" + age + ", height=" + height + '}';
  }
}
