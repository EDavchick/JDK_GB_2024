package org.lect01_game_window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
//    private static final int WINDOW_POSX = 700;
//    private static final int WINDOW_POSY = 300;
    // Создание кнопок
    private JButton btnStart;
    private JButton btnExit;
    private Map map;
    SettingsWindow settings;
            GameWindow(){
        // Все окна по умолчанию невидимые. Нажатие на крестик по умолчанию делает окно невидимым и не завершает программу.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Устанавливаем настройки окна
        // Свойства окна, такие как размер и заголовок возможно задать вызовом методов в конструкторе
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null); // окно появляется по центру экрана со значением null
//        setLocation(WINDOW_POSX, WINDOW_POSY);

        // Добавляем название кнопок и настройки окна
        setTitle("TicTacToe");
        setResizable(false);
        btnStart = new JButton("New Game");
        btnExit = new JButton("Exit");
        settings = new SettingsWindow(this); // создается ссылка на текущий объект
        map = new Map();

        // Для выполнения кода по нажатию кнопки на интерфейсе нужно создать
        // обработчик кнопки и вписать код в него
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // закрытие идет
                System.exit(0);
                    }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // нажатие кнопки старт делает видимым наше окно настроек
                settings.setVisible(true);
                    }
        });

        // Создание панели кнопок из наших отдельных кнопок и расположим их снизу
        JPanel panBottom = new JPanel(new GridLayout(1,2));
        panBottom.add(btnStart);
        panBottom.add(btnExit);

        // добавляем панель вниз
        add(panBottom, BorderLayout.SOUTH);
        // добавляет игру по центру
        add(map);

        // чтобы наш экран появился после всех настроект
        setVisible(true);
    }

    // начало игры
    void startNewGame(int mode, int fSzX, int fSzY, int wLen) {
        map.startNewGame(mode, fSzX, fSzY, wLen);
    }
}
