package com.ms.edu.comment;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = EduCommentApplication.class)
@RunWith(SpringRunner.class)
public class EduCommentApplicationTests {

	@Resource
	private RabbitTemplate rabbitTemplate;


	@Test
	public void contextLoads() {
		rabbitTemplate.convertAndSend("hello","hello world");
	}

}
