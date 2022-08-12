package ru.smirnov.MailDataProcessingApp.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.smirnov.MailDataProcessingApp.models.Receiver;
import ru.smirnov.MailDataProcessingApp.repositories.ReceiverRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

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

    @Transactional
    public void updateReceiver(int identification, Receiver receiver){
        Receiver receiverToUpdate = receiverRepository.getReferenceByIdentification(identification).get();
        receiverToUpdate.setName(receiver.getName());
        receiverToUpdate.setIndex(receiver.getIndex());
        receiverToUpdate.setAddress(receiver.getAddress());
        receiverRepository.save(receiverToUpdate);
    }
    @Transactional
    public void delivered(int identification){
        Receiver receiverToUpdate = receiverRepository.getReferenceByIdentification(identification).get();
        receiverToUpdate.setDelivered(true);
        receiverToUpdate.setTimeOfDelivered(Instant.now());
    }
}
