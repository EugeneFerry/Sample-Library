package com.sample.library.dal.type;

import java.util.Map;
import java.util.TreeMap;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sample.library.dal.type.serialization.CategoryTypeDeserializer;
import com.sample.library.dal.type.serialization.TypeSerializer;

/**
 * The enum Category type.
 */
@JsonSerialize(using = TypeSerializer.class)
@JsonDeserialize(using = CategoryTypeDeserializer.class)
public enum CategoryType implements IType {

    // ===========================================
    // Values
    // ===========================================

    /** The Action adventure. */
    ACTION_ADVENTURE(1, "Action & Adventure"),

    /** The Thriller. */
    THRILLER(2, "Thriller"),

    /** The Horror. */
    HORROR(3, "Horror"),

    /** The Romance. */
    ROMANCE(4, "Romance");

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The constant LOOKUP_MAP. */
    private static final Map<Integer, CategoryType> LOOKUP_MAP = new TreeMap<>();

    /** The Id. */
    private final Integer id;

    /** The Name. */
    private final String name;

    // ===========================================
    // Static Initialisers
    // ===========================================

    static {
        // Initialise the LOOKUP_MAP
        for (CategoryType type : values()) {
            getLookupMap().put(type.getId(), type);
        }
    }


    // ===========================================
    // Constructors
    // ===========================================

    /**
     * Instantiates a new Category type.
     *
     * @param id the id
     * @param name the name
     */
    CategoryType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    // ===========================================
    // Public Methods
    // ===========================================

    /**
     * Lookup category type.
     *
     * @param id the id
     * @return the category type
     */
    public static CategoryType lookup(Integer id) {
        return getLookupMap().get(id);
    }

    /**
     * Lookup category type.
     *
     * @param name the name
     * @return the category type
     */
    public static CategoryType lookup(String name) {
        CategoryType categoryType = null;
        for (CategoryType type : values()) {
            if (type.getName().equals(name)) {
                categoryType = type;
                break;
            }
        }
        return categoryType;
    }

    /**
     * Gets lookup map.
     *
     * @return the lookup map
     */
    private static Map<Integer, CategoryType> getLookupMap() {
        return LOOKUP_MAP;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    @Override
    public Integer getId() {
        return this.id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return this.getName();
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
