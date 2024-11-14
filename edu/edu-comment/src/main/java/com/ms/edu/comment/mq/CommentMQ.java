package com.ms.edu.comment.mq;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * ClassName: CommentMQ
 * Package: com.ms.edu.comment.mq
 * Description:
 *
 * @Author ms
 * @Create 2024/6/21 9:37
 * @Version 1.0
 */
@Component
public class CommentMQ {
    @RabbitListener(queuesToDeclare = @Queue("commentList"))
    public void receive(String messaage) {
        System.out.println("消费者1---" + messaage);
    }

    @RabbitListener(queuesToDeclare = @Queue("commentList"))
    public void receive2(String messaage) {
        System.out.println("消费者2--" + messaage);
    }
}
