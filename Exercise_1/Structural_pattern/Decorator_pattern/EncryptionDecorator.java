package Structural_pattern.Decorator_pattern;

import java.util.Base64;

public class EncryptionDecorator extends MessageDecorator {

    public EncryptionDecorator(Message decoratedMessage) {
        super(decoratedMessage);
    }

    @Override
    public String getContent() {
        return encrypt(decoratedMessage.getContent());
    }

    private String encrypt(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }
}
