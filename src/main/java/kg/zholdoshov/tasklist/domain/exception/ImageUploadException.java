package kg.zholdoshov.tasklist.domain.exception;

public class ImageUploadException extends RuntimeException {

    public ImageUploadException() {
        super();
    }

    public ImageUploadException(final String m) {
        super(m);
    }

}
