package Structural_pattern.Decorator_pattern;

import java.util.Base64;

public class DecryptionDecorator extends MessageDecorator {

    public DecryptionDecorator(Message decoratedMessage) {
        super(decoratedMessage);
    }

    @Override
    public String getContent() {
        return decrypt(decoratedMessage.getContent());
    }

    private String decrypt(String data) {
        return new String(Base64.getDecoder().decode(data));
    }
}
