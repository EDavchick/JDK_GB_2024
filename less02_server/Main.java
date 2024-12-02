package org.less02_server;

import org.less02_server.client.domain.ClientController;
import org.less02_server.client.ui.ClientGUI;
import org.less02_server.server.repository.FileStorage;
import org.less02_server.server.domain.ServerController;
import org.less02_server.server.ui.ServerWindow;

public class Main {
    public static void main(String[] args) {
        //создание объектов сервера и создание связи между ними
        ServerController serverController = new ServerController(new ServerWindow(), new FileStorage());

        new ClientController(new ClientGUI(), serverController);
        new ClientController(new ClientGUI(), serverController);
    }
}

