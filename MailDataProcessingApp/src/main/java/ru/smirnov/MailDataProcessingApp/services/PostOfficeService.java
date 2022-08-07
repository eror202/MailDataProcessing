package ru.smirnov.MailDataProcessingApp.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.smirnov.MailDataProcessingApp.models.PostOffice;
import ru.smirnov.MailDataProcessingApp.repositories.PostOfficeRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class PostOfficeService {
    private final PostOfficeRepository postOfficeRepository;

    public List<PostOffice> findAll() {
        return postOfficeRepository.findAll();
    }

    @Transactional
    public void savePostOffice(PostOffice postOffice){
        postOfficeRepository.save(postOffice);
    }
}
