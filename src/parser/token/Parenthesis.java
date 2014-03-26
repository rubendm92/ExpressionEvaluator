package parser.token;

public abstract class Parenthesis implements Symbol {

    public static final Parenthesis OPEN = new Open();
    public static final Parenthesis CLOSE = new Close();

    public static class Open extends Parenthesis {

        private Open() {
        }
    }

    public static class Close extends Parenthesis {

        private Close() {
        }
    }
}
