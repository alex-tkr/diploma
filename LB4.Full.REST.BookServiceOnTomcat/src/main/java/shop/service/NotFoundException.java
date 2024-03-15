package shop.service;

public class NotFoundException extends ServiceException {
	private static final long serialVersionUID = -1510616808964159070L;

	public NotFoundException() {
		super(404);
	}

	public NotFoundException(String message, Throwable cause, boolean enableSuppression,
                             boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace, 404);
	}

	public NotFoundException(String message, Throwable cause) {
		super(message, cause, 404);
	}

	public NotFoundException(String message) {
		super(message, 404);
	}

	public NotFoundException(Throwable cause) {
		super(cause, 404);
	}

}
