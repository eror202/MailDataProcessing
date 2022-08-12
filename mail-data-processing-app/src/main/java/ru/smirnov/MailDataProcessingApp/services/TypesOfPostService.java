package ru.smirnov.MailDataProcessingApp.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.smirnov.MailDataProcessingApp.models.TypesOfPost;
import ru.smirnov.MailDataProcessingApp.repositories.ReceiverRepository;
import ru.smirnov.MailDataProcessingApp.repositories.TypesOfPostRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class TypesOfPostService {
    private final TypesOfPostRepository typesOfPostRepository;
    private final ReceiverRepository receiverRepository;

    public List<TypesOfPost> findAll(){
        return typesOfPostRepository.findAll();
    }

    @Transactional
    public void saveTypeOfPost(TypesOfPost typesOfPost){
        typesOfPostRepository.save(typesOfPost);
    }

    public Optional<TypesOfPost> findOne(int identification){
        return typesOfPostRepository.getReferenceByReceiverIdentification(receiverRepository.getReferenceByIdentification(identification).get());
    }
    @Transactional
    public void updateTypeOfPost(int identification, TypesOfPost typesOfPost){
        TypesOfPost typesOfPostToUpdate = typesOfPostRepository
                .getReferenceByReceiverIdentification(receiverRepository.getReferenceByIdentification(identification).get()).get();
        typesOfPostToUpdate.setType(typesOfPost.getType());
        typesOfPostRepository.save(typesOfPostToUpdate);
    }
}
