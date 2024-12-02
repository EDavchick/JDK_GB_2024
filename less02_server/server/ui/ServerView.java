package org.less02_server.server.ui;

import org.less02_server.server.domain.ServerController;

/**
 * Интерфейс описывающий абстракцию ServerWindow
 */
public interface ServerView {
    void showMessage(String message);
    void setServerController(ServerController serverController);
}
