package com.sample.library.dal.type.serialization;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.sample.library.dal.type.CategoryType;
import com.sample.library.dal.type.IType;

/**
 * The type Category type deserializer.
 */
public class CategoryTypeDeserializer extends JsonDeserializer<IType> {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The constant ID. */
    private static final String ID = "id";


    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================

    // ===========================================
    // Public Methods
    // ===========================================

    /**
     * Deserialize type.
     *
     * @param jsonParser the json parser
     * @param context the context
     * @return the type
     * @throws IOException the io exception
     */
    @Override
    public IType deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
        JsonNode node = jsonParser.readValueAsTree();
        IType value = (node.get(ID) == null ?  CategoryType.lookup(node.textValue()) : CategoryType.lookup(node.get(ID).intValue()));
        return value;
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
