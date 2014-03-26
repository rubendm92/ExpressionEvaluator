package parser.token;

public abstract class Bracket implements Symbol {

    public static final Bracket OPEN = new Open();
    public static final Bracket CLOSE = new Close();

    public static class Open extends Bracket {

        private Open() {
        }
    }

    public static class Close extends Bracket {

        private Close() {
        }
    }
}
