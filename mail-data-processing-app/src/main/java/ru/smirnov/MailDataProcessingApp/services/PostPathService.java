package ru.smirnov.MailDataProcessingApp.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.smirnov.MailDataProcessingApp.models.PostOffice;
import ru.smirnov.MailDataProcessingApp.models.PostPath;
import ru.smirnov.MailDataProcessingApp.repositories.PostOfficeRepository;
import ru.smirnov.MailDataProcessingApp.repositories.PostPathRepository;
import ru.smirnov.MailDataProcessingApp.repositories.ReceiverRepository;

import java.time.Instant;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class PostPathService {

    private final PostPathRepository postPathRepository;
    private final ReceiverRepository receiverRepository;
    private final PostOfficeRepository postOfficeRepository;
    private final PostOfficeService postOfficeService;

    public List<PostPath> findAll(){
        return postPathRepository.findAll();
    }

    @Transactional
    public void savePostPath(PostPath postPath){
        postPath.setRegistrationTime(Instant.now());
        postPath.setPostOfficeName(postOfficeRepository
                .findPostOfficeByName(postPath.getPostOfficeName().getName()).get());
        postPathRepository.save(postPath);
    }

    @Transactional
    public void updatePostPathArrivalToPostOffice(int identification){
        PostPath postPathToUpdate = postPathRepository.findPostPathByReceiverIdentification(receiverRepository
                .getReferenceByIdentification(identification).get()).get();
        postPathToUpdate.setDateOfArrivalAtThePostOffice(Instant.now());
        postPathRepository.save(postPathToUpdate);

    }
    @Transactional
    public void updatePostPathDepartureFromPostOffice(int identification){
        PostPath postPathToUpdate = postPathRepository.findPostPathByReceiverIdentification(receiverRepository
                .getReferenceByIdentification(identification).get()).get();
        postPathToUpdate.setDateOfDepartureFromThePostOffice(Instant.now());
        postPathRepository.save(postPathToUpdate);
    }
    @Transactional
    public void changePostOffice(int identification, PostPath postPath){
        PostPath postPathToUpdate = postPathRepository.findPostPathByReceiverIdentification(receiverRepository
                .getReferenceByIdentification(identification).get()).get();
        postPathToUpdate.setPostOfficeName(postPath.getPostOfficeName());
        postPathRepository.save(postPathToUpdate);
    }
}
