import java.util.Objects;

public class Student {
    private String name;
    private String group;

    public Student(String name, String group){
        this.name = name;
        this.group = group;
    }

    @Override
    public boolean equals(Object other) {
        if(other == this){
            return true;
        }
        if(!(other instanceof Student student)){
            return false;
        }

        return Objects.equals(this.name , student.name) && Objects.equals(this.group , student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name , group);
    }
}
