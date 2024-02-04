package ru.gb.Homework6.services;

import ru.gb.Homework6.models.Characters;
import ru.gb.Homework6.models.Result;

public interface ServiceApi {
        public Characters getAllCharacters();
        public Characters getAllCharacters(int page);
        public Result getSingleCharacter(int id);


}
