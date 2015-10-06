package main.java.com.multithread;

import sun.plugin2.message.Message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by alexandr on 06.10.15.
 * {@link http://tproger.ru/translations/10-java-multithread-practices/}
 * *****************************************************
 * 10 советов по многопоточному программированию на Java
 */
public class ConcurrentTask {

    private static List temp = Collections.synchronizedList(new ArrayList());

//    @Override
    public void execute(Message message) {
        // Используем локальный временный список
        // List temp = new ArrayList();

        // Добавим в список что-нибудь из сообщения
        temp.add("message.getId()");
        temp.add("message.getCode()");

        temp.clear(); // теперь можно переиспользовать
    }

}
