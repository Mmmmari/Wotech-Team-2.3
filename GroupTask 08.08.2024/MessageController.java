package com.datorium.Datorium.API.Controllers; // belongs to package created

import com.datorium.Datorium.API.DTOs.Message;
import com.datorium.Datorium.API.Services.MessageService;
import com.datorium.Datorium.API.Services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {

    private MessageService messageService;
    public MessageController(){
        messageService = new MessageService();

    }

    @PostMapping("/reply")
    public int reply(@RequestBody Message message){
        return messageService.reply(message);

    }

    @PostMapping("/shout")
    public int shout(@RequestBody Message message){
        return message.shout(message);

    }
}
