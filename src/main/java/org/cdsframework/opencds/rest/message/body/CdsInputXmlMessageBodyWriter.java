package org.cdsframework.opencds.rest.message.body;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import org.cdsframework.cds.util.MarshalUtils;
import org.opencds.vmr.v1_0.schema.CDSInput;

/**
 *
 * @author sdn
 */
@Provider
@Produces(MediaType.APPLICATION_XML)
public class CdsInputXmlMessageBodyWriter implements MessageBodyWriter<CDSInput>  {

    @Override
    public boolean isWriteable(Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        return type == CDSInput.class;
    }

    @Override
    public long getSize(CDSInput t, Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        return 0;
    }

    @Override
    public void writeTo(
            CDSInput cdsInput,
            Class<?> type,
            Type genericType,
            Annotation[] annotations,
            MediaType mediaType,
            MultivaluedMap<String, Object> httpHeaders,
            OutputStream out)
            throws IOException, WebApplicationException {
        MarshalUtils.marshal(cdsInput, out);
    }
    
}
