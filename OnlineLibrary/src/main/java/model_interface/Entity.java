package model_interface;

/**
 * This is an interface represent an Entity, or one row of a relational table.
 * EntityFactory should be used when a new instance of Entity is needed. Some
 * methods of EntitySet return Entity
 *
 * @author Nguyen Xuan Trung
 */
public interface Entity {

    /**
     * Type is the name of the table
     *
     * @return the type of the entity
     */
    String getType();

    /**
     * Attributes are columns of the table.
     *
     * @return a String array contains all attribute names
     */
    String[] getAttributesName();

    /**
     * Attributes are columns of the table.
     *
     * @param attribute_name : name of the column
     * @return the value of the attribute, or null if the attribute is empty or
     * does not exist
     */
    String getAttribute(String attribute_name);

    /**
     * This method will change the value of the corresponding record, if the
     * Entity is linked with a database record. Will only change the object
     * value otherwise
     *
     * @param attribute_name : column to change
     * @param value : change to this value
     * @return True if update is successful. False if attribute name cannot be
     * found or value is not valid.
     */
    boolean setAttribute(String attribute_name, String value);
    /**
     * Update bulk of attributes. Update success when and only when all
     * attribute names are valid and all values are valid
     *
     * @param attribute_names : columns to change
     * @param values : new values of columns, in the same order as
     * attribute_names
     * @return True if update is success, False when there are invalid attribute
     * names and/or values
     */
    boolean setAttributes(String[] attribute_names, String[] values);

    /**
     *
     * @return whether the Entity is marked as deleted.
     */
    boolean isDeleted();

    /**
     *
     * @param is_delete : whether this Entity is marked as deleted
     * @return True if update is success
     */
    boolean delete(boolean is_delete);
}
