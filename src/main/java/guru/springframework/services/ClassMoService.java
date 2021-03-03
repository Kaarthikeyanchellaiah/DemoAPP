package guru.springframework.services;

import guru.springframework.commands.ClassMoForm;
import guru.springframework.domain.ClassMo;

import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
public interface ClassMoService {

    List<ClassMo> listAll();

    ClassMo getById(Long id);

    ClassMo saveOrUpdate(ClassMo classmo);

    void delete(Long id);

    ClassMo saveOrUpdateClassMoForm(ClassMoForm classmoForm);
}
