package com.ddl.test;

public class Test {
    public static void main(String[] args) {
       User user = User.builder().age(11).mobile("111").build();
       System.out.println(user.getAge());
    }

}
