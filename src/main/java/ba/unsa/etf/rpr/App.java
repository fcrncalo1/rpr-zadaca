package ba.unsa.etf.rpr;

public class App 
{
    public static void main( String[] args )
    {

        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        try {
            System.out.println(evaluator.evaluate(args[0]));
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

    }
}
