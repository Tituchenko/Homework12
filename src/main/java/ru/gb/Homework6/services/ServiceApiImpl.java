package ru.gb.Homework6.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.gb.Homework6.models.Characters;
import ru.gb.Homework6.models.Result;

import java.util.List;


@Service
public class ServiceApiImpl implements ServiceApi{

    @Autowired
    private RestTemplate template;

    @Autowired
    private HttpHeaders headers;

    private  static final String CHARACTER_API = "https://rickandmortyapi.com/api/character";
    private  static final String CHARACTER_API_PAGE = "https://rickandmortyapi.com/api/character/?page={page}";
    private  static final String CHARACTER_API_SINGLE = "https://rickandmortyapi.com/api/character/{id}";
    @Override
    public Characters getAllCharacters() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> responce = template.exchange(CHARACTER_API, HttpMethod.GET,entity, Characters.class);

        return responce.getBody();
    }
    public Characters getAllCharacters(int page) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> responce = template.exchange(CHARACTER_API_PAGE, HttpMethod.GET,entity, Characters.class,page);

        return responce.getBody();
    }
    public Result getSingleCharacter(int id){
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Result> responce = template.exchange(CHARACTER_API_SINGLE, HttpMethod.GET,entity, Result.class,id);
        return responce.getBody();
    }
}