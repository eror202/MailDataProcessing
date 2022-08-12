package ru.smirnov.MailDataProcessingApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.smirnov.MailDataProcessingApp.models.PostOffice;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostOfficeRepository extends JpaRepository<PostOffice, Integer> {

    Optional<PostOffice> getReferenceByIndex(Integer index);
    Optional<PostOffice> findPostOfficeByName(String name);
}
