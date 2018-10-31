package com.wq.springboot.entity;

import java.io.Serializable;
import java.util.Date;

public class MyStudent implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Integer student_id;
    private String name;
    private Integer age;
    private String sex;
    private Date birthday;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;

        MyStudent s = (MyStudent) o;

        if (id != null ? !id.equals(s.id) : s.id != null)
            return false;

        return true;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the student_id
     */
    public Integer getStudent_id() {
        return student_id;
    }

    /**
     * @param student_id the student_id to set
     */
    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
