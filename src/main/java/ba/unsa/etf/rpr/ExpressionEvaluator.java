package ba.unsa.etf.rpr;

import java.util.Stack;

/** Represents a tool that is used for evaluating arithmetic expressions
 * @author Faris Crnčalo
 * @version 1.0
 * @since 1.0
 */
public class ExpressionEvaluator {

    private final Stack<String> ops;
    private final Stack<Double> values;

    /** Class constructor that initializes class attributes
     */
    public ExpressionEvaluator() {
        this.ops = new Stack<>();
        this.values = new Stack<>();
    }

    /** Method for evaluating the expression that is sent through the parameter
     * @param expression The expression that we want to evaluate
     * @return A result that represents the evaluated expression
     * @throws RuntimeException in case of an invalid arithmetic expression
     */
    public Double evaluate(String expression) throws RuntimeException {
        if (expression.contains("( )") || expression.contains(") (") || expression.contains("( +") ||
            expression.contains("( -") || expression.contains("( *") || expression.contains("( /") ||
            expression.contains("+ )") || expression.contains("- )") || expression.contains("* )") ||
            expression.contains("/ )") )
            throw new RuntimeException("Invalid arithmetic expression!");
        for(String s : expression.split(" ")){
            if(s.equals("(")) ;
            else if(s.equals("+")) ops.push(s);
            else if(s.equals("-")) ops.push(s);
            else if(s.equals("*")) ops.push(s);
            else if(s.equals("/")) ops.push(s);
            else if(s.equals("sqrt")) ops.push(s);
            else if(s.equals(")")) {
                String op = ops.pop();
                double v = values.pop();
                if (op.equals("+")) v = values.pop() + v;
                else if (op.equals("-")) v = values.pop() - v;
                else if (op.equals("*")) v = values.pop() * v;
                else if (op.equals("/")) v = values.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                values.push(v);
            }
            else try {
                    values.push(Double.parseDouble(s));
                } catch (Exception e) {
                    throw new RuntimeException("Invalid arithmetic expression!");
                }
        }
        if (values.size() != 1 || ops.size() > values.size()) throw new RuntimeException("Invalid arithmetic expression!");
        return values.pop();
    }
}
