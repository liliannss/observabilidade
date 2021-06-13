package br.com.api.resource.repositories;

import br.com.api.resource.models.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface ResourceRepository extends JpaRepository<ResourceEntity, Long> {

}
