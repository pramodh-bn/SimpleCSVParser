package com.xyz.app.parse;


import com.xyz.app.config.Configuration;

/**
 * A singleton Factory which returns the custom parser based on the
 * delimiter(, or | or ' ')
 */

public class CustomParserFactory {
    private static CustomParserFactory ourInstance = new CustomParserFactory();

    public static CustomParserFactory getInstance() {
        return ourInstance;
    }

    public ICustomParser getParser(Configuration configuration) {
        ICustomParser parser = null;
        if (configuration.getDelimiter().equalsIgnoreCase(","))
            parser = new CommaCustomParser();
        else if (configuration.getDelimiter().equalsIgnoreCase("|"))
            parser = new PipeCustomParser();
        else if (configuration.getDelimiter().equalsIgnoreCase(" "))
            parser = new SpaceCustomParser();
        return parser;
    }
}
