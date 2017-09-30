package edu.mum.cs545.localhost.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import edu.mum.cs545.localhost.domain.UserProfile;

public class UserProfileIdentityJsonSerializer extends JsonSerializer<UserProfile> {

	@Override
	public void serialize(UserProfile value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		gen.writeStartObject();
		gen.writeNumberField("id", value.getId());
		gen.writeEndObject();
	}
	
}
