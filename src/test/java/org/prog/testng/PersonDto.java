package org.prog.testng;


public class PersonDto {
    private String name;
    private IdDto id;

    // constructor, getters, and setters for name and id fields

    public PersonDto(String name, String id) {
        this.name = name;
        this.id = new IdDto(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IdDto getId() {
        return id;
    }

    public void setId(IdDto id) {
        this.id = id;
    }
    public class Main  {
        public static void main(String[] args) {
            // assume we have a PersonDto object
            PersonDto person = new PersonDto("John Doe", "12345");

            // print the name and id fields
            System.out.println("Name: " + person.getName());
            System.out.println("Id: " + person.getId().getId());
        }
    }
}