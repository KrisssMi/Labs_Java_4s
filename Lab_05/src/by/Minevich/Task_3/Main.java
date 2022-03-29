package by.Minevich.Task_3;

import java.util.Random;
import java.util.concurrent.Semaphore;
//Синхронизаторы – вспомогательные утилиты для синхронизации потоков, которые дают возможность разработчику регулировать
// и/или ограничивать работу потоков и предоставляют более высокий уровень абстракции, чем основные примитивы языка (мониторы).

/* CallCenter. В организации работает n операторов. Оператор может
   обслуживать только одного клиента, остальные должны ждать своей очереди.
   Клиент может положить трубку и перезвонить еще раз через некоторое время. */

public class Main {
    public static final int AMOUNT_OF_OPERATORS = 2;
    public static final int AMOUNT_OF_CLIENTS = 10;

    public static void main(String[] args) {
        Random rand = new Random();
        //Чаще всего, семафоры необходимы, когда нужно ограничить доступ к некоторому общему ресурсу.
        Semaphore semaphore = new Semaphore(AMOUNT_OF_OPERATORS, true);
        CallCenter callCenter = new CallCenter(AMOUNT_OF_OPERATORS);
        try {
            for (int i = 0; i < AMOUNT_OF_CLIENTS; i++) {
                new Client(callCenter, semaphore, i).start();
                Thread.sleep(rand.nextInt(300) + 300 );
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
