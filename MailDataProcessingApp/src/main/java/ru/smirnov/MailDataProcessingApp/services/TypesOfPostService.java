package ru.smirnov.MailDataProcessingApp.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.smirnov.MailDataProcessingApp.models.TypesOfPost;
import ru.smirnov.MailDataProcessingApp.repositories.TypesOfPostRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class TypesOfPostService {
    private final TypesOfPostRepository typesOfPostRepository;

    public List<TypesOfPost> findAll(){
        return typesOfPostRepository.findAll();
    }

    @Transactional
    public void saveTypeOfPost(TypesOfPost typesOfPost){
        typesOfPostRepository.save(typesOfPost);
    }
}
