package cg.validate;

import cg.model.Staff;
import cg.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
public class ValidateName implements Validator {
    @Autowired
    IStaffService staffService;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Staff staff = (Staff) target;
        List<Staff> staffList = staffService.findAll();
        for (Staff s: staffList) {
            if (staff.getName().equals(s.getName())){
                errors.rejectValue("name","","ten da ton tai, moi nhap ten khac");
                return;
            }
        }
    }
}
