package guru.springframework.services;

import guru.springframework.commands.ClassMoForm;
import guru.springframework.converters.ClassMoFormToClassMo;
import guru.springframework.domain.ClassMo;
import guru.springframework.repositories.ClassMoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
@Service
public class ClassMoServiceImpl implements ClassMoService {

    private ClassMoRepository classmoRepository;
    private ClassMoFormToClassMo classmoFormToClassMo;

    @Autowired
    public ClassMoServiceImpl(ClassMoRepository classmoRepository, ClassMoFormToClassMo classmoFormToClassMo) {
        this.classmoRepository = classmoRepository;
        this.classmoFormToClassMo = classmoFormToClassMo;
    }


    @Override
    public List<ClassMo> listAll() {
        List<ClassMo> classmos = new ArrayList<>();
        classmoRepository.findAll().forEach(classmos::add); //fun with Java 8
        return classmos;
    }

    @Override
    public ClassMo getById(Long id) {
        return classmoRepository.findById(id).orElse(null);
    }

    @Override
    public ClassMo saveOrUpdate(ClassMo classmo) {
        classmoRepository.save(classmo);
        return classmo;
    }

    @Override
    public void delete(Long id) {
        classmoRepository.deleteById(id);

    }

    @Override
    public ClassMo saveOrUpdateClassMoForm(ClassMoForm classmoForm) {
        ClassMo savedClassMo = saveOrUpdate(classmoFormToClassMo.convert(classmoForm));

        System.out.println("Saved ClassMo Id: " + savedClassMo.getId());
        return savedClassMo;
    }
}
