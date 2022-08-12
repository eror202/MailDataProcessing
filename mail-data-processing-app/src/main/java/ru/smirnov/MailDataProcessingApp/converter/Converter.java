package ru.smirnov.MailDataProcessingApp.converter;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.smirnov.MailDataProcessingApp.dto.PostOfficeDTO;
import ru.smirnov.MailDataProcessingApp.dto.PostPathDTO;
import ru.smirnov.MailDataProcessingApp.dto.ReceiverDTO;
import ru.smirnov.MailDataProcessingApp.dto.TypesOfPostDTO;
import ru.smirnov.MailDataProcessingApp.models.PostOffice;
import ru.smirnov.MailDataProcessingApp.models.PostPath;
import ru.smirnov.MailDataProcessingApp.models.Receiver;
import ru.smirnov.MailDataProcessingApp.models.TypesOfPost;
import ru.smirnov.MailDataProcessingApp.response.PostOfficeResponse;
import ru.smirnov.MailDataProcessingApp.response.PostPathResponse;
import ru.smirnov.MailDataProcessingApp.response.ReceiverResponse;
import ru.smirnov.MailDataProcessingApp.response.TypesOfPostResponse;
import ru.smirnov.MailDataProcessingApp.services.PostOfficeService;
import ru.smirnov.MailDataProcessingApp.services.PostPathService;
import ru.smirnov.MailDataProcessingApp.services.ReceiverService;
import ru.smirnov.MailDataProcessingApp.services.TypesOfPostService;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class Converter {
    private final ModelMapper modelMapper;
    private final ReceiverService receiverService;
    private final TypesOfPostService typesOfPostService;
    private final PostPathService postPathService;
    private final PostOfficeService postOfficeService;

    public ReceiverResponse converterToReceiverDTO() {
        return new ReceiverResponse(receiverService.findAll().stream().map(this::convertToReceiverDTO).collect(Collectors.toList()));
    }

    public Receiver converterToReceiver(ReceiverDTO receiverDTO) {
        return convertToReceiver(receiverDTO);
    }

    public TypesOfPost converterToTypesOfPost(TypesOfPostDTO typesOfPostDTO) {
        return convertToTypesOfPost(typesOfPostDTO);
    }

    public TypesOfPostResponse converterToTypesOfPostDTO() {
        return new TypesOfPostResponse(typesOfPostService.findAll().stream().map(this::convertToTypesOfPostDTO).collect(Collectors.toList()));
    }
    public TypesOfPostDTO converterToTypesOfPostDTO(Optional<TypesOfPost> typesOfPost) {
        return convertToTypesOfPostDTO(typesOfPost.get());
    }

    public PostPathResponse converterToPostPath() {
        return new PostPathResponse(postPathService.findAll().stream().map(this::convertToPostPathDTO).collect(Collectors.toList()));
    }

    public PostPath converterToPostPath(PostPathDTO postPathDTO) {
        return convertToPostPath(postPathDTO);
    }

    public PostOfficeResponse converterToPostOfficeDTO() {
        return new PostOfficeResponse(postOfficeService.findAll().stream().map(this::convertToPostOfficeDTO).collect(Collectors.toList()));
    }

    public PostOffice converterToPostOffice(PostOfficeDTO postOfficeDTO){
        return convertToPostOffice(postOfficeDTO);
    }

    private Receiver convertToReceiver(ReceiverDTO receiverDTO) {
        return modelMapper.map(receiverDTO, Receiver.class);
    }

    private ReceiverDTO convertToReceiverDTO(Receiver receiver) {
        return modelMapper.map(receiver, ReceiverDTO.class);
    }

    private TypesOfPost convertToTypesOfPost(TypesOfPostDTO typesOfPostDTO) {
        return modelMapper.map(typesOfPostDTO, TypesOfPost.class);
    }

    private TypesOfPostDTO convertToTypesOfPostDTO(TypesOfPost typesOfPost) {
        return modelMapper.map(typesOfPost, TypesOfPostDTO.class);
    }

    private PostPath convertToPostPath(PostPathDTO postPathDTO) {
        return modelMapper.map(postPathDTO, PostPath.class);
    }

    private PostPathDTO convertToPostPathDTO(PostPath postPath) {
        return modelMapper.map(postPath, PostPathDTO.class);
    }

    private PostOffice convertToPostOffice(PostOfficeDTO postOfficeDTO) {
        return modelMapper.map(postOfficeDTO, PostOffice.class);
    }

    private PostOfficeDTO convertToPostOfficeDTO(PostOffice postOffice) {
        return modelMapper.map(postOffice, PostOfficeDTO.class);
    }
}
