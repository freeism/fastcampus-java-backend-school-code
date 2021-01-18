package com.fastcampus.todo.controller;

import com.fastcampus.todo.dto.UserDto;
import com.fastcampus.todo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @author Martin
 * @since 2021/01/18
 */
@Component
@RequiredArgsConstructor
public class UserConsumer implements MessageListener<String, UserDto> {
    private final UserService userService;

    @Override
    @KafkaListener(topics = "user", groupId = "consumer-1")
    public void onMessage(ConsumerRecord<String, UserDto> data) {
        System.out.println(">> " + data.key());
        System.out.println(">> " + data.value());

        userService.addUser(data.value());
    }
}
