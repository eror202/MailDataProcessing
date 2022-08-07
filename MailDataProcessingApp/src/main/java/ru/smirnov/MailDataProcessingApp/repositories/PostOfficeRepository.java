package ru.smirnov.MailDataProcessingApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.smirnov.MailDataProcessingApp.models.PostOffice;

public interface PostOfficeRepository extends JpaRepository<PostOffice, Integer> {
}
