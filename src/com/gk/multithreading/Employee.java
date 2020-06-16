package com.gk.multithreading;

import java.util.Objects;

public class Employee {
    String name;
    Integer amout;
    Integer id;
    Employee(String name, Integer amount){
        this.name = name;
        this.amout = amount;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null)
//            return true;
//        if (this.getClass() != obj.getClass())
//            return false;
//        final Employee other = (Employee) obj;
//        if (!Objects.equals(this.name, other.name))
//            return false;
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 1;
//        hash = 7 * hash + Objects.hashCode(this.name);
//        System.out.println(hash);
//        return hash;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return name.equals(employee.name) &&
                amout.equals(employee.amout);
    }

    @Override
    public int hashCode() {
        System.out.println(Objects.hash(name));
        return Objects.hash(name);
    }
}
