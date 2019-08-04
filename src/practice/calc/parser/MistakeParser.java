package practice.calc.parser;

public class MistakeParser implements ArgsParser {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    private ArgsParser parser;

    public MistakeParser() {
    }

    public MistakeParser(ArgsParser parser) {
        this.parser = parser;
    }

    @Override
    public String[] parse(String[] calcArgs) {
        final String joining = String.join("", calcArgs);
        for (String arg : joining.split("")) {
            if (ALPHABET.contains(arg)) {
                throw new RuntimeException("Недопустимый символ " + arg);
            }
        }
        return parser != null ? parser.parse(calcArgs) : calcArgs;
    }

}