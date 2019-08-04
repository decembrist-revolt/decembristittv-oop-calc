package practice.calc.parser;

import practice.calc.operation.*;

public class CalcStringParser {

    private ArgsParser parser;

    public CalcStringParser(ArgsParser parser) {
        this.parser = parser;
    }

    public Operation parse(String[] calcArgs) {
        final String[] parsedArgs = parser != null ? parser.parse(calcArgs) : calcArgs;
        final Number firstNumber = convertToNumber(parsedArgs[0]);
        Operation result = new ConstOperation(firstNumber);
        for (int i = 1; i < parsedArgs.length; i += 2) {
            String arg = parsedArgs[i];
            if (isOperation(arg)) {
                final Number nextNumber = convertToNumber(parsedArgs[i + 1]);
                if (arg.equals("+")) {
                    result = new SumOperation(result, nextNumber);
                } else {
                    result = new SubtractOperation(result, nextNumber);
                }
            } else {
                throw new RuntimeException("Некорректный массив");
            }
        }
        return result;
    }

    private boolean isOperation(String arg) {
        return arg.equals("+") || arg.equals("-");
    }

    private Number convertToNumber(String arg) {
        Number result;
        if (arg.contains(".")) {
            result = Double.valueOf(arg);
        } else {
            result = Long.valueOf(arg);
        }
        return result;
    }

}