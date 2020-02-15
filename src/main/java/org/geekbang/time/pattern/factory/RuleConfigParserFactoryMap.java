package org.geekbang.time.pattern.factory;

import java.util.HashMap;
import java.util.Map;

public class RuleConfigParserFactoryMap {

    private static final Map<String, IRuleConfigParserFactory> cachedFactories = new HashMap<>();

    static {
        cachedFactories.put("json", JsonRuleConfigParser::new);
        cachedFactories.put("xml", XmlRuleConfigParser::new);
        cachedFactories.put("yaml", YamlRuleConfigParser::new);
        cachedFactories.put("properties", PropertiesRuleConfigParser::new);
    }

    public static IRuleConfigParserFactory getParserFactory(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        return cachedFactories.get(type.toLowerCase());
    }

}
