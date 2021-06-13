package br.com.api.resource.services;

import br.com.api.resource.models.ResourceEntity;
import br.com.api.resource.repositories.ResourceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository repository;

    @Override
    public ResourceEntity create(ResourceEntity resourceEntity) {
        return repository.save(resourceEntity);
    }

    @Override
    public List<ResourceEntity> findAll() {
        List<ResourceEntity> resourceEntityList = repository.findAll();

        return resourceEntityList;
    }

}