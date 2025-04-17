package utils;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class TestFailureTrackerExtensionUtils implements TestExecutionExceptionHandler, BeforeEachCallback {

    private static final ThreadLocal<Boolean> testFailed = ThreadLocal.withInitial(() -> false);

    public static boolean didTestFail() {
        return testFailed.get();
    }

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        testFailed.set(true); // Marca que o teste falhou
        throw throwable; // Propaga a exceção para que o teste falhe de verdade
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        testFailed.set(false); // Reseta o status de falha no início de cada teste
    }
}