package parser.token;

public interface Token<Type> {

    public interface Handler {

        public void handle(Token token);
    }
}
