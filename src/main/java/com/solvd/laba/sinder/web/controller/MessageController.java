package com.solvd.laba.sinder.web.controller;

import com.solvd.laba.sinder.web.dto.AttachmentDto;
import com.solvd.laba.sinder.web.dto.MessageDto;
import com.solvd.laba.sinder.web.dto.group.OnSend;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/{userId}/pairs/{pairId}/messages")
public class MessageController {

    @GetMapping
    public List<MessageDto> openChat() {
        return null;
    }

    @PostMapping
    public MessageDto send(@Validated(OnSend.class) @RequestBody MessageDto messageDto, @Validated(OnSend.class) AttachmentDto attachmentDto) {
        // text, links
        System.out.println(attachmentDto);
        return null;
    } //phone, links as request params


}