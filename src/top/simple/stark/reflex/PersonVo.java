/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package top.simple.stark.reflex;

/**
 * @author muse
 */
public class PersonVo {

    public String name;

    protected Integer age;

    private Byte sex;

    Boolean isMarriage1;

    public PersonVo() {
    }

    public PersonVo(String name, Integer age, Byte sex, Boolean isMarriage1) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.isMarriage1 = isMarriage1;
    }

    public Boolean getMarriage1() {
        return isMarriage1;
    }

    public void setMarriage1(Boolean marriage1) {
        isMarriage1 = marriage1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "PersonVo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", isMarriage1=" + isMarriage1 +
                '}';
    }
}
