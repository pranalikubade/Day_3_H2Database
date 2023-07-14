package com.bridgelabz.DatabaseH2.Service;

import com.bridgelabz.DatabaseH2.DTO.MessageDTO;
import com.bridgelabz.DatabaseH2.Model.Message;
import com.bridgelabz.DatabaseH2.Repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepo messageRepo;

    public Message addMessage(MessageDTO messageDTO) {
    Message messageData =new Message(messageDTO);
    return messageRepo.save(messageData);
    }

    public Optional<Message> getById(int id) {
        return messageRepo.findById(id);
    }

    public Message updateMessage(int id, MessageDTO messageDTO) {
        Optional<Message> messageData = getById(id);
        if (messageData.isPresent()){
            messageData.get().updateMessage(messageDTO);
            return messageRepo.save(messageData.get());
        }
        return null;
    }

    public List<Message> findAll() {
        return messageRepo.findAll();
    }

    public boolean deleteMessage(int id) {
        // Check if the message exists
        if (messageRepo.existsById(id)) {
            messageRepo.deleteById(id);
            return true; // Deletion successful
        }
        return false; // Message not found
    }

}
