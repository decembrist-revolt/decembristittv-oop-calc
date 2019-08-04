package practice.calc;

import practice.calc.parser.ArgsParser;
import practice.calc.parser.CalcStringParser;
import practice.calc.parser.CorrectionParser;
import practice.calc.parser.MistakeParser;

public class Main {

    public static void main(String[] args) {
        final ArgsParser parser = new CorrectionParser(new MistakeParser());
        final CalcStringParser calcStringParser = new CalcStringParser(parser);
        final Calculator calculator = new Calculator(calcStringParser);
        calculator.calculate(args);
    }

}
