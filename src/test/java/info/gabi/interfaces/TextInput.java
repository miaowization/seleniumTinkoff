package info.gabi.interfaces;


public interface TextInput extends BaseElement {
    void type(String text);

    void clear();

    void clearAndType(String text);
}
