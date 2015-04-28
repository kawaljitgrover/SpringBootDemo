package com.kawal;

import com.kawal.domain.Person;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component("myPermissionEvaluator")
public class AppPermissionEvaluator {

    public boolean hasPermission(Long id, String test) {
        return true;
    }

    public boolean hasPermission(int age) {
        return true;
    }

    public boolean hasPermission(String name) {
        return true;
    }


    public boolean hasPermissions(String... permissions) {
        System.out.println("Permissions : " + Arrays.toString(permissions));
//        return true;
        return false;
    }

    public boolean hasPermission(Person filterObject, int maxAge) {
//        return true;
        return filterObject.getAge() <= maxAge;
    }

}
