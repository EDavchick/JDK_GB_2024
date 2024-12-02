package org.less02_server.client.ui;

import org.less02_server.client.domain.ClientController;

/**
 * Интерфейс описывающий абстракцию GUI
 */
public interface ClientView {
    /**
     * Метод для отображения сообщения в GUI
     * @param message текст сообщения
     */
    void showMessage(String message);

    /**
     * Метод отключения от сервера со стороны сервера
     */
    void disconnectedFromServer();
    /**
     * Сеттер
     * @param clientController объект, описывающий логику программы
     */
    void setClientController(ClientController clientController);
}
