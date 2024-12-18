## Лабораторная работа 3 "Базовые растровые алгоритмы".

### Используемые технологии:
  * C++
  * Qt 6.8.0
  * qcustomplot

### Задачи:
  * Написать приложение/веб-приложение, иллюстрирующее работу базовых растровых алгоритмов;
  * Создать исполняемый файл в формате .exe. 

## Описание приложения:
Спроектирован удобный и интуитивно понятный пользовательский интерфейс приложения.
Реализованы алгоритмы построения линий и окружностей.
Создано масштабируемое поле для отображения графиков;
Был создан исполняемый файл в формате .exe.

### Основные объекты приложения:
  * Рабочее окно, где отображена система координат, иллюстрирующая работу базовых растровых алгоритмов;  
  * Labels, которые отображают название переменной, которую мы хотим изменить;
  * SpinBoxes, где отображаются все переменные, которые можно изменить;
  * Combobox для выбора конкретного алгоритма.

### Используемые библиотеки:
  * QMainWindow(основное поле приложения);
  * QVector (предоставляет работу с векторами);
  * QPoint (описывает точку на плоскости, используя целочисленную точность);
  * QActionGroup (используется для группировки действий);
  * QPainter (выполняет низкоуровневое рисование на виджетах и других устройствах рисования).

### Реализованный функционал:
  * Отображение работы всех растровых алгоритмов на сетке;
  * Возможность выбора конерктного растрового алгоритма в Combobox;
  * Возможность изменения координат и радиуса
  * Возможность изменения координат и радиуса.
  
Основные файлы:

  - raster-algorithms.cpp
  - raster-algorithms.h
  - main.cpp
  
### Выводы:
В рамках этой лабораторной работы мной было разработано приложение, включающее реализацию пяти алгоритмов 
растеризации линий и кривых таких как:
* пошаговый алгоритм;
* алгоритм ЦДА;
* алгоритм Брезенхема;
* алгоритм Брезенхема (окружность);
* алгоритм Кастла-Питвея (дополнительно).
Получен практический опыт использования встроенной библиотеки qcustomplot для построения графиков.

Скриншоты:

![image](https://github.com/user-attachments/assets/6aba8954-b3b5-48d5-abdc-cdcc48073f53)
![image](https://github.com/user-attachments/assets/563c5ea4-f3f5-4a9e-8489-718fe4602260)


