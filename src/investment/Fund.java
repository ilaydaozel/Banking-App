package investment;

//Fund class
public class Fund {
 private String name;
 private double value;

 public Fund(String name) {
     this.name = name;
     this.value = 0.0;
 }

 public String getName() {
     return name;
 }

 public double getValue() {
     return value;
 }

 public void setValue(double value) {
     this.value = value;
 }
}
