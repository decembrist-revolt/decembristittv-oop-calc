package practice.calc.parser;

public class CorrectionParser implements ArgsParser {

    private ArgsParser parser;

    public CorrectionParser() {
    }

    public CorrectionParser(ArgsParser parser) {
        this.parser = parser;
    }

    @Override
    public String[] parse(String[] calcArgs) {
        final String[] parsedArgs = parser != null ? parser.parse(calcArgs) : calcArgs;
        final String joining = String.join("", parsedArgs);
        return  joining.split("");
    }

}
