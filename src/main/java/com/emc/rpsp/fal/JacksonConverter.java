//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.emc.rpsp.fal;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

import java.io.IOException;
import java.lang.reflect.Type;

public class JacksonConverter implements Converter {
	private static final String MIME_TYPE = "application/json; charset=UTF-8";
	private final ObjectMapper objectMapper;

	public JacksonConverter() {
		this(new ObjectMapper());
	}

	public JacksonConverter(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public Object fromBody(TypedInput body, Type type)
	        throws ConversionException {
		try {
			JavaType e = this.objectMapper.getTypeFactory().constructType(type);
			return this.objectMapper.readValue(body.in(), e);
		} catch (JsonParseException var4) {
			throw new ConversionException(var4);
		} catch (JsonMappingException var5) {
			throw new ConversionException(var5);
		} catch (IOException var6) {
			throw new ConversionException(var6);
		}
	}

	public TypedOutput toBody(Object object) {
		try {
			String e = this.objectMapper.writeValueAsString(object);
			return new TypedByteArray("application/json; charset=UTF-8",
			        e.getBytes("UTF-8"));
		} catch (IOException var3) {
			throw new AssertionError(var3);
		}
	}
}
