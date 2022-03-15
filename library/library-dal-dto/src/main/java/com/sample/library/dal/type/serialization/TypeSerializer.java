package com.sample.library.dal.type.serialization;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.sample.library.dal.type.IType;

/**
 * The type Type serializer.
 */
public class TypeSerializer extends JsonSerializer<IType> {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================

    /** The constant ID. */
    private static final String ID = "id";

    /** The constant NAME. */
    private static final String NAME = "name";

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
     * Serialize.
     *
     * @param type the type
     * @param jsonGenerator the json generator
     * @param serializerProvider the serializer provider
     * @throws IOException the io exception
     */
    @Override
    public void serialize(IType type, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField(ID, type.getId());
        jsonGenerator.writeStringField(NAME, type.getName());
        jsonGenerator.writeEndObject();
    }


    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================

}
