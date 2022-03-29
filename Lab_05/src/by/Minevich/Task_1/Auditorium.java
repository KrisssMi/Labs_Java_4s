package by.Minevich.Task_1;

public class Auditorium {
    private Students[] students;
    private int auditoriumSize;

    public Auditorium(int size) {
        this.auditoriumSize = size;
        students=new Students[size];
    }

    public int getFreePlace() {
        for (int i = 0; i< auditoriumSize; i++) {
            if (students[i]==null)
                return i;
        }
        return -1;
    }

    public void setStudent(Students student) { // добавление студента
        System.out.println("Student: " + student.getStudentName() + " is placed.");
        students[getFreePlace()] = student; // если есть свободное место, то добавляется студент
    }

    public void leaveStudent(Students student){ // удаление студента
        for(int i = 0; i< auditoriumSize; i++){
            if(students[i] == student){
                students[i] = null;
                System.out.println("Student: " + student.getStudentName() + " leave the auditorium.");
            }
        }
    }

    public void showAuditorium() {              // вывод аудитории (количества студентов)
        System.out.println("Auditorium places: {");
        for (int i = 0; i < auditoriumSize; i++) {
            if(students[i] != null){
                System.out.println("\t"+i + ") " + students[i].getStudentName());
            }
            else{
                System.out.println("\t"+ i + ") empty.");
            }
        }
        System.out.println("}");
    }
}
