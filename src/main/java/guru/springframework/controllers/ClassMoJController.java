package guru.springframework.controllers;

import guru.springframework.converters.ClassMoToClassMoForm;
import guru.springframework.domain.ClassMo;
import guru.springframework.services.ClassMoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import javax.validation.Valid;

/**
 * Created by jt on 1/10/17.
 */
@SuppressWarnings("unused")
@Controller
public class ClassMoJController {
    private ClassMoService classmoService;

    
    @Autowired
    public void setClassMoService(ClassMoService classmoService) {
        this.classmoService = classmoService;
    }

    @RequestMapping("/all")
    public String redirToList(){
        return "redirect:/jclassmo/listjson";
    }

    @RequestMapping("/jclassmo/listjson")
    public ResponseEntity<List<ClassMo>> listJClassMo(){
        return ResponseEntity.ok(classmoService.listAll());
    }


    @RequestMapping("/jclassmo/show/{id}")
    public ResponseEntity<ClassMo> getClassMo(@PathVariable String id){
        return ResponseEntity.ok(classmoService.getById(Long.valueOf(id)));
    }

    @RequestMapping(value = "/jclassmo", method = RequestMethod.POST)
    public ResponseEntity<ClassMo> saveOrUpdateJClassMo(@RequestBody ClassMo classMo){
        ClassMo savedClassMo = classmoService.saveOrUpdate(classMo);
        return ResponseEntity.ok(savedClassMo);
    }


    @RequestMapping("/jclassmo/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id){
        classmoService.delete(Long.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}
