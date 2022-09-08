package com.example.casefitmebackend.services.set;

import com.example.casefitmebackend.exceptions.SetNotFoundException;
import com.example.casefitmebackend.models.Set;
import com.example.casefitmebackend.repositories.SetRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SetServiceImpl implements SetService{

    private SetRepository setRepository;

    public SetServiceImpl(SetRepository setRepository) {
        this.setRepository = setRepository;
    }
    @Override
    public Set findById(Integer id) {
        return setRepository.findById(id)
                .orElseThrow(() -> new SetNotFoundException(id));
    }

    @Override
    public Collection<Set> findAll() {
        return setRepository.findAll();
    }

    @Override
    public Set add(Set entity) {
        return setRepository.save(entity);
    }

    @Override
    public Set update(Set entity) {
        return setRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        setRepository.deleteById(id);
    }
}
