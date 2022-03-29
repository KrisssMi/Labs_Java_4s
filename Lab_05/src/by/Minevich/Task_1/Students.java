package by.Minevich.Task_1;

import java.util.Random;

public class Students extends Thread {
    public String studentName;
    Random random = new Random();
    Auditorium auditorium;

    public Students(int studentName, Auditorium auditorium) {
        this.studentName=String.valueOf(studentName);
        this.auditorium=auditorium;
        System.out.println("Student: " + this.studentName + " come.");
    }

    public String getStudentName(){
        return this.studentName;
    }

    @Override
    public void run() {
        synchronized (auditorium) {
            if (auditorium.getFreePlace() == -1) {             // если нет свободного места, студент ожидает
                int waitingTime = random.nextInt(1000); // время ожидания = рандомное число, значение которого должно быть меньше 1000
                System.out.println("Student: " + this.getStudentName() + " is waiting...");
                try {
                    auditorium.wait(waitingTime);   // поток ожидает
                }
                catch (InterruptedException e) {    // выполняется, когда поток в режиме ожидания
                }
            }
        }
        if (auditorium.getFreePlace() != -1) {  // если есть свободные места
            auditorium.setStudent(this);        // добавляется студент
            auditorium.showAuditorium();        // вывод аудитории
            try {
                Thread.sleep(random.nextInt(3000));     // поток прекращает свой процесс на рандомное время, значение которого должно быть меньше 3000
            }
            catch (Exception e) {
            }

            auditorium.leaveStudent(this);     // один студент покидает аудиторию
            synchronized (auditorium) {
                auditorium.notify();           // пробуждает поток, который ожидает на мониторе этого объекта
                // по умолчанию наши потоки wait, т.е. заморожены;
                // notify все потоки оживит
            }
        }
            else{
                System.out.println("Student: " + this.getStudentName() + " left.");
            }
        }
    }
