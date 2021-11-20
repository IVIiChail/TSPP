package com.company;

public class Corporation {
    private Department array_of_departments[];
    private Director director;

    public Corporation(Department[] array_of_departments, Director director) {
        this.array_of_departments = array_of_departments;
        this.director = director;
    }

    public Department[] getArray_of_departments() {
        return array_of_departments;
    }

    public void setArray_of_departments(Department[] array_of_departments) {
        this.array_of_departments = array_of_departments;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
