package com.vay.hash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author qiaozhe
 */
@Setter
@Getter
@AllArgsConstructor
public class Person {
    private String name;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Person){
            Person p = (Person)obj;
            if(p.getName().equals(this.getName())){
                return true;
            }
            return false;
        }else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
