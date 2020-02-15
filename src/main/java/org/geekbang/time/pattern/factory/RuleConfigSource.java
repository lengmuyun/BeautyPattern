package org.geekbang.time.pattern.factory;

public class RuleConfigSource {

    public RuleConfig load(String ruleConfigFilePath) {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParserFactory parserFactory = RuleConfigParserFactoryMap.getParserFactory(ruleConfigFileExtension);
        if (parserFactory == null) {
            throw new InvalidRuleConfigException("Rule config file format is not supported: " + ruleConfigFilePath);
        }
        IRuleConfigParser parser = parserFactory.createParser();
        String configText = "";
        return parser.parse(configText);
    }

    private String getFileExtension(String filePath) {
        // ...解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }

}
