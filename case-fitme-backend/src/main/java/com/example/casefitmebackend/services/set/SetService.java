package com.example.casefitmebackend.services.set;

import com.example.casefitmebackend.models.Set;
import com.example.casefitmebackend.services.CrudService;
import org.springframework.stereotype.Service;

@Service
public interface SetService extends CrudService<Set, Integer> {
}
