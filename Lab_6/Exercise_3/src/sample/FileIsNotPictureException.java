package sample;

public class FileIsNotPictureException extends Exception {

    FileIsNotPictureException() {

    }

    FileIsNotPictureException(String message) {
        super(message);
    }
}
