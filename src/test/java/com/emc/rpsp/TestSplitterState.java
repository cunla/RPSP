package com.emc.rpsp;

import com.emc.rpsp.fal.ClusterConnector;
import com.emc.rpsp.fal.ClusterConnectorFactory;
import com.emc.rpsp.fal.commons.ClusterSplittersState;
import com.emc.rpsp.fal.commons.FullRecoverPointSettings;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by morand3 on 8/3/2016.
 */
public class TestSplitterState {
    @Test
    public void testSplitterState() {
        ClusterConnector connector = ClusterConnectorFactory.getConnector("10.64.125.39", "admin", "admin");

        //This passed well
        FullRecoverPointSettings x = connector.getFullRecoverPointSettings();

        //This fails in deserialization...
        ClusterSplittersState states = connector.getSplittersState();

        ObjectMapper mapper = new ObjectMapper();

        try {
            //Convert object to JSON string and save into file directly
            mapper.writeValue(new File("C:\\states.json"), states);

            //Convert object to JSON string
            String json = mapper.writeValueAsString(states);
            System.out.println(json);

            //Convert object to JSON string and pretty print
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(states);
            System.out.println(json);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
