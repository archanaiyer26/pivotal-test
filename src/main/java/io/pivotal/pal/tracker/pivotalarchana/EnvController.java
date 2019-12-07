package io.pivotal.pal.tracker.pivotalarchana;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String portNo;
    private String memory_limit;
    private String cf_instance_index;
    private String cf_instance_addr;

    public EnvController(@Value("${portNo :NOT SET}") String portNo,@Value("${memory_limit : NOT SET}") String memoryLimit,@Value("${cfInstanceIndex : NOT SET}")
            String cfInstanceIndex,@Value("${cfInstanceAddr : NOT SET}") String cfInstanceAddr){


        this.portNo = portNo;
        this.memory_limit = memoryLimit;
        this.cf_instance_index = cfInstanceIndex;
        this.cf_instance_addr = cfInstanceAddr;
    }

    @GetMapping("/env")
    public Map<String,String> getEnv(){

        Map<String,String> env = new HashMap<>();
        env.put("PORT",portNo);
        env.put("MEMORY_LIMIT",memory_limit);
        env.put("CF_INSTANCE_INDEX",cf_instance_index);
        env.put("CF_INSTANCE_ADDR",cf_instance_addr);

        return env;

    }
}
