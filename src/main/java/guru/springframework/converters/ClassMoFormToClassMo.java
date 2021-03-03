package guru.springframework.converters;

import guru.springframework.commands.ClassMoForm;
import guru.springframework.domain.ClassMo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by jt on 1/10/17.
 */
@Component
public class ClassMoFormToClassMo implements Converter<ClassMoForm, ClassMo> {

    @Override
    public ClassMo convert(ClassMoForm classmoForm) {
    	
        ClassMo classmo = new ClassMo();
        
        if (classmoForm.getId() != null  && !StringUtils.isEmpty(classmoForm.getId())) {
            classmo.setId(new Long(classmoForm.getId()));
        }
        classmo.setCompanyId(classmoForm.getCompanyId());
        classmo.setCompanyName(classmoForm.getCompanyName());
        classmo.setReportLogo(classmoForm.getReportLogo());
        classmo.setReportLogopath(classmoForm.getReportLogopath());
        return classmo;
    }
}
