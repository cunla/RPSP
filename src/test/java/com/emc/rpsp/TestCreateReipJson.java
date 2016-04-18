package com.emc.rpsp;

import com.emc.rpsp.fal.commons.*;
import com.emc.rpsp.fal.wrappers.VmNetworkPoliciesSet;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

/**
 * Created by morand3 on 4/18/2016.
 */
public class TestCreateReipJson {
    @Test
    public void testCreateJson() {
        ObjectMapper mapper = new ObjectMapper();

        //For testing
        VmNetworkPoliciesSet vmNetworkPoliciesSet = createDummy();

        try {
            //Convert object to JSON string and save into file directly
            mapper.writeValue(new File("C:\\policies.json"), vmNetworkPoliciesSet);

            //Convert object to JSON string
            String jsonInString = mapper.writeValueAsString(vmNetworkPoliciesSet);
            System.out.println(jsonInString);

            //Convert object to JSON string and pretty print
            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(vmNetworkPoliciesSet);
            System.out.println(jsonInString);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private VmNetworkPoliciesSet createDummy() {
        ConsistencyGroupUID groupUID = new ConsistencyGroupUID(558389424);

        VirtualCenterUID virtualCenterUID = new VirtualCenterUID("BB47075D-D75B-47B7-A41E-0D4EC03F4E35");
        VmUID vmUID = new VmUID("50022a9e-c266-51e0-92c8-b639bfd7144b", virtualCenterUID);

        GlobalNetworkPolicy globalNetworkPolicy = null;
        NicCustomizationPolicy nicCustomizationPolicy = null;
        HashSet<NicCustomizationPolicy> nicPolicies = new HashSet<>();
        nicPolicies.add(nicCustomizationPolicy);
        VmNetworkCustomizationPolicy vmNetworkCustomizationPolicy = new VmNetworkCustomizationPolicy(globalNetworkPolicy, nicPolicies);


        VmNetworkPolicy vmNetworkPolicy = new VmNetworkPolicy(groupUID, vmUID, vmNetworkCustomizationPolicy);
        VmNetworkPoliciesSet res = new VmNetworkPoliciesSet(new HashSet<>());
        res.getInnerSet().add(vmNetworkPolicy);
        return res;
    }
}
