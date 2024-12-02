package org.lect01_game_window;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;

    GameWindow gameWindow;
    private JButton btnStart;

    private ButtonGroup buttonGroup;
    private JLabel gameMode;
    private JLabel selectFieldSize;
    private JLabel setFieldSize;
    private JLabel selectLengthForWin;
    private JLabel setLengthForWin;

    private JRadioButton human_AI;
    private JRadioButton human_Human;

    private JSlider selectSizeSlider;
    private JSlider setLengthSlider;

    private static final String SELECT_FIELD_SIZE = "Выбранный размер поля: ";
    private static final String SET_FIELD_LENGTH = "Установленная длина: ";
    SettingsWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        btnStart = new JButton("Start new game");

/* Добавить на экран компоновщик-сетку с одним столбцом и добавить над
существующей кнопкой следующие компоненты в заданном порядке:
JLabel с заголовком «Выберите режим игры»,
сгруппированные в ButtonGroup переключаемые
JRadioButton с указанием режимов «Человек против компьютера» и «Человек против человека»,
JLabel с заголовком «Выберите размеры поля»,
JLabel с заголовком «Выбранный размер поля:»,
JSlider со значениями 3..10,
JLabel с заголовком «Выберите длину для победы»,
JLabel с заголовком «Установленная длина:»,
JSlider со значениями 3..10. */
        setLayout(new GridLayout(10, 1));
        buttonGroup = new ButtonGroup();

        gameMode = new JLabel("Выберите режим игры");
        add(gameMode);
        human_AI = new JRadioButton("Человек против компьютера");
        human_Human = new JRadioButton("Человек против человека");
        buttonGroup.add(human_AI);
        buttonGroup.add(human_Human);
        add(human_AI);
        add(human_Human);

        selectFieldSize = new JLabel("Выберите размеры поля");
        add(selectFieldSize);
        setFieldSize = new JLabel(SELECT_FIELD_SIZE);
        add(setFieldSize);
        selectSizeSlider = new JSlider(3, 10, 3);
        add(selectSizeSlider);

        selectLengthForWin = new JLabel("Выберите длину для победы");
        add(selectLengthForWin);
        setLengthForWin = new JLabel(SET_FIELD_LENGTH);
        add(setLengthForWin);
        setLengthSlider = new JSlider(3, 10, 3);
        add(setLengthSlider);

        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        selectSizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int num = (int)selectSizeSlider.getValue();
                setFieldSize.setText(SELECT_FIELD_SIZE + num);
                setLengthSlider.setMaximum(num);
            }
        });

        setLengthSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int num = (int)setLengthSlider.getValue();
                setLengthForWin.setText(SET_FIELD_LENGTH + num);
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGame();
            }
        });

        add(btnStart);
    }

    private void startNewGame() {
        int mode = 0;
        if (human_AI.isSelected()) {
            mode = 1;
        } else if (human_Human.isSelected()) {
            mode = 2;
        }
        int sizeField = selectSizeSlider.getValue();
        int sizeLength = setLengthSlider.getValue();
        gameWindow.startNewGame(mode,sizeField,sizeField,sizeLength);
        // чтобы сделать поле 5x5 ячеек:
//        gameWindow.startNewGame(0,5,5,5);
        setVisible(false);
    }
}