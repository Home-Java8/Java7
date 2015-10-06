
Запуск и выполнение программы
=============================
Программа - это набор инструкций для процессора.
Каждая инструкция выполняется процессором за 1-проход.

Храниться программа на (дисковом) носителе информации как файл.
При запуске, инструкции из этого файла загружаются в рабочую область памяти (ОЗУ) - это есть процесс (те инструкции которые размещаются в ОЗУ).
Чтобы выполнять эти инструкции, нужно выделить время процессору для выполнения этой программы - это есть поток (создание потока).

В программе присутствует основной-зарезервированый метод 'main()', который создает 'основной поток'.
Каждый поток характеризуется таким параметром как 'приоритет' - это частота обращений процессора к потоку.
По умолчанию (обычно простая) программа создает один поток со средним приоритетом для одного процесса.

Многопоточная программа
=======================
> Итак, обычно однопоточные программы состоят из:
>
1. Файл программы (в одном экземпляре) храниться на (дисковом) носителе информации
2. При запуске программы инструкции из этого файла загружаются в рабочую область ОЗУ. Для запуска нескольких программ происходит загрузка инструкций в несколько (разных) областей ОЗУ
3. Для каждой рабочей области ОЗУ создается отдельный поток для выполнения (инструкций) каждой программы отдельно (в отдельном потоке).
>
> Недостаток однопоточных программ в том, что они неэфективно расходуют много ресурсов ОЗУ.

> Многопоточная программа использует (повторно общую) одну и ту-же рабочую область ОЗУ для нескольких потоков.
>
> Достоинством многопоточных программ в том что эффективно используются ресурсы (области) ОЗУ.
>
> Недостатки многопоточных программ в том что существует высокий уровень ошибок при работе с общими ресурсами.

Криические секции в многопоточных программах
============================================
Пересечение (искажение/потеря) данных на общем ресурсе в многопоточной программе - это есть критическия секция.
Сохранение целостности данных для критических секций в многопоточной программе решается с помощью получения атомарности (то есть, в 1-проход для этих критических секций).
Поэтому, на протяжении всего цикла работы многопоточной программы решаются проблемы (борьба) с получением атомарности для критических секций.
1. Переменные простого и ссылочного типа - здесь важно чтобы операции на запись/чтение выполнялись за 1-проход (это атомарные set()/get() функции) - такие классы-данных являются бинами.
   + в таких случаях переменные-классы можно делать как 'volatile';
   + считается хорошим тоном в таких случаях применять библиотечные классы ('concurent', которые гарантируют стабильность для всех типов данных независимо от JVM).

Синхронизация критических секций для участка кода в многопоточной программе решается способом блокировки потока (получения атомарности для выполнения внутрених операций).
Блокировка потока выполняется/контролируется через (объект) монитор.
Существует два способа синхронизации (критических секций) участка кода:
1. Синхронизация функции - когда нужно получить атомарность для сложных выполнения функций:
   - здесь используются много (локальных) мониторов;
   - плюсы такого способа в том, что такой способ стабильный;
   - минусы такого способа в том, что блокируется вся функция И это сильно замедляет скорость работы программы (потому-что другие потоки долго ожидают/удерживаются пока один поток полностью будет выполнен);
2. Синхронизация блока - для реализации задач с очередями потоков и строгим порядком организации зависимостей их выполнения:
   - здесь используются один (глобальный) монитор;
   - плюсы такого способа в том, что такой способ быстрее работает (за счет частичной блокировки функции операторами wait()/notify() И это оставляет больше времени для работы другим потокам);
   - минусы такого способа в том, что использование глобальной переменной создает проблемы для внутрених переменых со схожим названием...;
   + в таких случаях глобальные переменные можно делать как 'final';
   + но считается хорошим тоном в таких случаях применять библиотечные классы ('concurent', которые избавляют от глобальных переменных и гарантируют стабильность).

Другие способы блокировок в многопоточных программах
====================================================
1. Коллекции из библотеки 'concurent' используют атомарные типы классов для синхронизации без блокировок (такой способ будет работать быстрее, потому-что здесь исключен 'локальный кеш потока' и поток получает прямой доступ к 'основной памяти').
2. Семафор - используется для организации пула потоков (это не один поток, который блокирует все остальные) доступа к единому ресурсу на нижнем уровне...
3. Мьютекс - ограничение доступа к единому ресурсу на более высоком уровне чем Семафор.
   + Привелегии использования Семафор-а и Мьютекс-а в том, что в случае отказа работы программы на (высоком) уровне Мьютекс-а такую программу всегда можно оживить с помощью на (низком) уровне Семафор-а.
     То есть, в этом случае Семафор служит как запасным вариантом (гарантией) для работы Мьютекс-а.


* `/usr/lib/jvm/jdk1.7.0_25/bin/javap -c LinearAlgorithm.class`
* `/usr/lib/jvm/jdk1.7.0_25/bin/javap`  `-c $OutputPath$\$FileDirRelativeToSourcepath$\$FileNameWithoutExtension$.class` | `-c $OutputPath$/$FileDirRelativeToSourcepath$/$FileNameWithoutExtension$.class`
* `Bytecode`: [What’s Cool In IntelliJIDEA. Part III: External Tools](http://arhipov.blogspot.com/2011/08/whats-cool-in-intellijidea-part-iii.html)
* [http://www.javalobby.org/java/forums/t103827.html](http://www.javalobby.org/java/forums/t103827.html)
* [http://cafebabe.sourceforge.net/](http://cafebabe.sourceforge.net/)

![Settings >> External Tools and press Add](http://4.bp.blogspot.com/-g2_YSFMMIMs/TlvT75Jv_BI/AAAAAAAAOBU/bnZY7A9vyAQ/s1600/external-tools.png)

![$FileClass$ and $OutputPath$](http://3.bp.blogspot.com/-CIFIrTcuB_o/TlvUo3j6o8I/AAAAAAAAOBc/SzICrEiwnkI/s1600/external-tools-2.png)

![javap](http://3.bp.blogspot.com/-Oe-I6DcnlzE/TlvV1llPw4I/AAAAAAAAOBk/du4A-PbUvj4/s1600/external-tools-3.png)

![Browse to Settings >> Keymap](http://3.bp.blogspot.com/-mvBXlf4syhM/TlvXtuybjoI/AAAAAAAAOBs/4SgDYVJorDc/s1600/keymap.png)

![example](http://1.bp.blogspot.com/-_cI-MhefOAM/TlvYvXnKnrI/AAAAAAAAOB0/W_d1QW1t0pY/s1600/javap.png)


* `Java Decompiler`: [JD-IntelliJ](http://jd.benow.ca/)
* [http://plugins.jetbrains.com/plugin/7100](http://plugins.jetbrains.com/plugin/7100)


* ![Brice Dutheil](http://jd.benow.ca/img/screenshot16.png)