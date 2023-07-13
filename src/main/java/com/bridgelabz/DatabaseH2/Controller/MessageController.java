package com.bridgelabz.DatabaseH2.Controller;

import com.bridgelabz.DatabaseH2.Model.Message;
import com.bridgelabz.DatabaseH2.Repository.MessageRepo;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MessageController {
    @Autowired
    private MessageRepo messageRepo;
    @PostMapping("/add")
     public Message addMessage(@RequestBody Message message){
         return messageRepo.save(message);
     }

     @GetMapping("/GetAll")
    public List<Message> getAllMessage(){
        return  messageRepo.findAll();
     }
     @GetMapping("/getbyId/{id}")
     public Optional<Message> getbyid(@PathVariable int id) {
        return messageRepo.findById(id);
     }
    @PutMapping("/update/{id}")
     public Message updateMessage(@PathVariable int id,@RequestBody Message message){
        Optional<Message> messagedata = messageRepo.findById(id);
        if (messagedata.isPresent()){
            messagedata.get().setMessage(message.getMessage());
            return  messageRepo.save(messagedata.get());
        }
        return null;
     }

    @DeleteMapping("/DeleteById/{id}")
    public void DeleteById(@PathVariable int id) {
        messageRepo.deleteById(id);
    }

}
