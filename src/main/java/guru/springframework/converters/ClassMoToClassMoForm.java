package guru.springframework.converters;

import guru.springframework.commands.ClassMoForm;
import guru.springframework.domain.ClassMo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 1/10/17.
 */
@Component
public class ClassMoToClassMoForm implements Converter<ClassMo, ClassMoForm> {
    @Override
    public ClassMoForm convert(ClassMo classmo) {
        ClassMoForm classmoForm = new ClassMoForm();
        classmoForm.setId(classmo.getId());
        classmoForm.setCompanyId(classmo.getCompanyId());
        classmoForm.setCompanyName(classmo.getCompanyName());
        classmoForm.setReportLogo(classmo.getReportLogo());
        classmoForm.setReportLogopath(classmo.getReportLogopath());
        return classmoForm;
    }
}
