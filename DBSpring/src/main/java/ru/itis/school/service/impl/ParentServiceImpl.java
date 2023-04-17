package ru.itis.school.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.school.dto.request.parent.ParentRequest;
import ru.itis.school.dto.request.parent.ParentUpdateRequest;
import ru.itis.school.dto.response.ParentCreateResponse;
import ru.itis.school.dto.response.ParentResponse;
import ru.itis.school.entities.Parent;
import ru.itis.school.mapper.ParentMapper;
import ru.itis.school.repository.ParentRepository;
import ru.itis.school.service.ParentService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {

    private final ParentRepository parentRepository;

    private final ParentMapper mapper;

    @Override
    public List<ParentResponse> getAll() {
        List<Parent> parents=parentRepository.findAll();
        return mapper.fromEntityToResponseList(parents);
    }

    @Override
    public ParentCreateResponse save(ParentRequest parentRequest) {
        return mapper.fromEntityToCreateResponse(parentRepository.save(mapper.fromRequestToEntity(parentRequest)));
    }

    @Override
    public ParentResponse updateById(ParentUpdateRequest newParent) {
        mapper.fromEntityToResponse(parentRepository.save(mapper.fromUpdateRequestToEntity(newParent)));
        return findById(newParent.getId());
    }

    @Override
    public void deleteById(UUID id) {
        parentRepository.deleteById(id);
    }

    @Override
    public ParentResponse findById(UUID id) {
        return mapper.fromEntityToResponse(parentRepository.findParentById(id));
    }
}
