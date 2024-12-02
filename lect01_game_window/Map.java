package org.lect01_game_window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Random;

public class Map extends JPanel {
    // Субъекты игры
    private static final Random RANDOM = new Random();
    private final int HUMAN_DOT = 1;
    private final int AI_DOT = 2;
    private final int EMPTY_DOT = 0;
    private static final int DOT_PADDING = 10;

    //  Состояния игрового поля
    private int gameStateType;
    private static final int STATE_GAME = 0;
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_AI = 2;
    private static final int STATE_DRAW = 3;

    private static final String MSG_WIN_HUMAN = "Победил игрок";
    private static final String MSG_WIN_AI = "Победил компьютер";
    private static final String MSG_DRAW = "Ничья";

    private int panelWidth, panelHeight, cellWidth, cellHeight;
    private int mode, fieldSizeX, fieldSizeY, winLen;
    private int[][] field;
    private boolean gameWork;

    Map() {
        // цвет фона
        setBackground(Color.WHITE);
        // Обработчик отпускания кнопки мышки
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (gameWork) {
                    update(e);
                }
            }
        });
    }

    // создание массива из х и 0, по дефолту там путсые значения
    private void initMap(){
        field = new int[fieldSizeY][fieldSizeX];
    }

    // Tic Tac Toe game logic Инициализация карты
    void startNewGame(int mode, int sizeX, int sizeY, int winLen) {
        this.mode = mode;
        this.fieldSizeX = sizeX;
        this.fieldSizeY = sizeY;
        this.winLen = winLen;

        // после каждого нажатия new game наш массив обновляется на дефолтные пустые значения
        initMap();
        gameWork = true;
        gameStateType = STATE_GAME;

        repaint();
    }
    // Обработчик обновления кнопки мышки и хода человека
    private void update(MouseEvent mouseEvent) {
        // получаем координаты того куда мы нажали
        // делим на кол-во ячеек
        int x = mouseEvent.getX() / cellWidth;
        int y = mouseEvent.getY() / cellHeight;
        // проверяем все условия
        if (!isValidCell(x, y) || !isEmptyCell(x, y)) {
            return;
        }
        // если все ок, ход игрока
        field[y][x] = HUMAN_DOT;
        // проверяем может быть игра закончена после хода человека
        if (checkEndGame(HUMAN_DOT, STATE_WIN_HUMAN)) {
            return;
        }
        // если игра не закончена ходит противник
        aiTurn();
        // перерисовка поля
        repaint();
        // проверка закончена ли игра после хода ИИ
        checkEndGame(AI_DOT, STATE_WIN_AI);
    }
    private void testBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(field[i]));
        }
        System.out.println();
    }
    // Попал ли игрок в пустую ячейку и в поле
    private boolean isValidCell(int x, int y) {
        // проверяем х и у лежат в нужном диапазоне?
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }
    private boolean isEmptyCell(int x, int y) {
        // проверка щелкнул ли игрок на пустую ячейку
        return field[y][x] == EMPTY_DOT;
    }
    // Ход компьютера
    private void aiTurn(){
        int x, y;
        // ИИ делает рандомные ходы со случайными числами
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        }
        // до тех пор, пока не попадет в пустую ячейку
        while (!isEmptyCell(x, y));
        // делает свой ход
        field[y][x] = AI_DOT;
    }
    // Проверка на ничью если доска заполнена
    private boolean isMapFull() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean checkEndGame(int dot, int gameOverType) {
        if (checkWin(dot)) {
            this.gameStateType = gameOverType;
            repaint();
            return true;
        } else if (isMapFull()) {
            this.gameStateType = STATE_DRAW;
            repaint();
            return true;
        }
        return false;
    }
    // Проверка победы одного из игроков
    private boolean checkWin(int dot) {
        // Переделать проверку победы, чтобы она не была реализована
        // просто набором условий
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (checkLine(i, j, 1, 0, winLen, dot)) return true;
                if (checkLine(i, j, 1, 1, winLen, dot)) return true;
                if (checkLine(i, j, 0, 1, winLen, dot)) return true;
                if (checkLine(i, j, 1, -1, winLen, dot)) return true;
            }
        }
        return false;
        // плохой вариант реализована просто набором условий
//        if (field[0][0]==dot && field[0][1]==dot && field[0][2]==dot) return true;
//        if (field[1][0]==dot && field[1][1]==dot && field[1][2]==dot) return true;
//        if (field[2][0]==dot && field[2][1]==dot && field[2][2]==dot) return true;
//        if (field[0][0]==dot && field[1][0]==dot && field[2][0]==dot) return true;
//        if (field[0][1]==dot && field[1][1]==dot && field[2][1]==dot) return true;
//        if (field[0][2]==dot && field[1][2]==dot && field[2][2]==dot) return true;
//        if (field[0][0]==dot && field[1][1]==dot && field[2][2]==dot) return true;
//        if (field[0][2]==dot && field[1][1]==dot && field[2][0]==dot) return true;
//        return false;
    }

    // метод принимает координаты ячейки, по которой произведен щелчок,
    // переменные в какую сторону надо двигаться,
    // проверяем заполнена ли линия одними х или 0
    private boolean checkLine(int x, int y, int vx, int vy, int len, int dot) {
        // находим координаты следующей ячейки
        int far_x = x + (len - 1) * vx;
        int far_y = y + (len - 1) * vy;
        // поверяем лежит ли ячейка на игровом поле
        if (!isValidCell(far_x, far_y)) {
            return false;
        }
        // если все ок, делаем столько шагов, сколько нас просили по ширине поля
        for (int i = 0; i < len; i++) {
            // если вся линия заполнена например х и мы не словили фолс
            if (field[y + i * vy][x + i * vx] != dot) {
                return false;
            }
        }
        // возвращаем тру
        return true;
    }

    // после метода repaint автоматически вызывается метод paintComponent
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        // есди игра идет, мы перерисовываем игру
        if (gameWork) {
            render(g);
        }
    }

    private void render(Graphics g) {
        // получаем размеры игрового поля
        panelWidth = getWidth();
        panelHeight = getHeight();
        // получаем размер одной ячейки
        cellWidth = panelWidth / fieldSizeX;
        cellHeight = panelHeight / fieldSizeY;

        // выбираем цвет, которым будем рисовать
        g.setColor(Color.BLACK);

        //  Результат разлиновки поля для игры
        for (int h = 0; h < fieldSizeY; h++) {
            int y = h * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }
        for (int w = 0; w < fieldSizeX; w++) {
            int x = w * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        //  Отрисовка ячейки определенной фигурой
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == EMPTY_DOT) {
                    continue;
                }
                // человек играет Х
                if (field[y][x] == HUMAN_DOT) {
                    // цвет линий
                    g.setColor(Color.RED);
                    // первая линия
                    g.drawLine(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            (x + 1) * cellWidth - DOT_PADDING,
                            (y + 1) * cellHeight - DOT_PADDING);
                    // вторая линия
                    g.drawLine(x * cellWidth + DOT_PADDING,
                            (y + 1) * cellHeight - DOT_PADDING,
                            (x + 1) * cellWidth - DOT_PADDING,
                            y * cellHeight + DOT_PADDING);

                    // получается Х
                }
                // ИИ играет 0
                else if (field[y][x] == AI_DOT) {
                    // цвет круга
                    g.setColor(Color.DARK_GRAY);
                    g.drawOval(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeight - DOT_PADDING * 2);
                } else {
                    throw new RuntimeException(STR."Unexpected value \{field[y][x]}in cell: x = \{x} y = \{y}");
                }
            }
        }
        // если игра закончена (любое состояние, кроме STATE_GAME)
        // вывод сообщения
        if (gameStateType != STATE_GAME) {
            showMessageGameOver(g);
        }
    }
    // Отрисовка сообщения об окончании игры
    private void showMessageGameOver(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, getHeight() / 2, getWidth(), 70);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Times new roman", Font.BOLD, 40));
        switch (gameStateType) {
            case STATE_DRAW -> g.drawString(MSG_DRAW, 100, getHeight() / 2 + 60);
            case STATE_WIN_AI -> g.drawString(MSG_WIN_AI, 100, getHeight() / 2 + 60);
            case STATE_WIN_HUMAN -> g.drawString(MSG_WIN_HUMAN, 100, getHeight() / 2 + 60);
            default -> throw new RuntimeException(STR."Unexpected gameOver state \{gameStateType}");
        }
        gameWork = false;
    }
}