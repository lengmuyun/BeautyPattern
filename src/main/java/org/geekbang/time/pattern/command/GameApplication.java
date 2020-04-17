package org.geekbang.time.pattern.command;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GameApplication {

    private static final int MAX_HANDLED_REQ_COUNT_PER_LOOP = 100;
    private Queue<Command> queue = new LinkedList<>();

    public void mainloop() {
        while (true) {
            List<Request> requests = new ArrayList<>();

            //省略从epoll或者select中获取数据，并封装成Request的逻辑，
            //注意设置超时时间，如果很长时间没有接收到请求，就继续下面的逻辑处理。

            for (Request request : requests) {
                Event event = request.getEvent();
                Command command = null;
                if (event.equals(Event.GOT_DIAMOND)) {
                    command = new GotDiamondCommand();
                } else if (event.equals(Event.GOT_STAR)) {
                    command = new GotStartCommand();
                } else if (event.equals(Event.HIT_OBSTACLE)) {
                    command = new HitObstacleCommand();
                } else if (event.equals(Event.ARCHIVE)) {
                    command = new ArchiveCommand();
                }
                if (command != null) {
                    queue.add(command);
                }
            }

            int handledCount = 0;
            while (handledCount < MAX_HANDLED_REQ_COUNT_PER_LOOP) {
                if (queue.isEmpty()) break;

                Command command = queue.poll();
                command.execute();
                handledCount++;
            }
        }
    }
}
