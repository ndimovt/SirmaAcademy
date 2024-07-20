package io.github.ndimovt.midexam.employee;
/**
 * The abstract Human class
 **/

public abstract class Human {
    private int id;
    private String name;

    /**
     * Instantiating Human
     * @param id Integer value
     * @param name String object
     */
    public Human(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**Return id
     *
     * @return Integer value
     */

    public int getId() {
        return id;
    }

    /**Update object name property
     *
     * @param name String object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**Return name property
     *
     * @return String object
     */
    public String getName() {
        return name;
    }
}
