package ru.smirnov.MailDataProcessingApp.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.smirnov.MailDataProcessingApp.models.Receiver;
import ru.smirnov.MailDataProcessingApp.repositories.ReceiverRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class ReceiverService {

    private final ReceiverRepository receiverRepository;

    public List<Receiver> findAll()
    {
        return receiverRepository.findAll();
    }

    @Transactional
    public void saveReceiver(Receiver receiver){
        receiverRepository.save(receiver);
    }
}
