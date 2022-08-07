package ru.smirnov.MailDataProcessingApp.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.smirnov.MailDataProcessingApp.models.PostPath;
import ru.smirnov.MailDataProcessingApp.repositories.PostPathRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class PostPathService {

    private final PostPathRepository postPathRepository;

    public List<PostPath> findAll(){
        return postPathRepository.findAll();
    }

    @Transactional
    public void savePostPath(PostPath postPath){
        postPathRepository.save(postPath);
    }
}
