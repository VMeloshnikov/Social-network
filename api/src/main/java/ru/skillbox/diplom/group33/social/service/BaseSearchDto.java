package ru.skillbox.diplom.group33.social.service;

import lombok.Data;

import java.util.Optional;

@Data
public class BaseSearchDto {

    private final BaseRepository baseRepository;
    private BaseDto baseDto = new BaseDto();

    public boolean search() {
        Optional<BaseDto> optional = baseRepository.findById(baseDto.getId());
        if (optional.isPresent()) {
            baseDto.setIsDeleted(false);
            return false;
        } else {
            baseDto.setIsDeleted(true);
            return true;
        }
    }
}
