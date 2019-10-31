public class Student {
    public String sn;
    public String name;
    public int age;
    public int gender;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Student)) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        return sn.equals(((Student) obj).sn);
    }
}
