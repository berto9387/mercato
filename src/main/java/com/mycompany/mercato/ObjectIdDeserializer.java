/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercato;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import java.io.IOException;
import org.bson.types.ObjectId;

/**
 *
 * @author tony_
 */
public class ObjectIdDeserializer extends JsonDeserializer<String> {

    @Override
    public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode oid = ((JsonNode)p.readValueAsTree()).get("$oid");
        return oid.asText();
    }

}