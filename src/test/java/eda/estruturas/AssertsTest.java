package eda.estruturas;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Executa as classes *Asserts (baseadas na palavra-chave "assert") dentro do
 * JUnit, para que "mvn test" e o botão de testes da IDE as rodem.
 *
 * As classes *Asserts continuam podendo ser executadas diretamente (main),
 * com a JVM iniciada com a opção -ea.
 */
class AssertsTest {

    @BeforeAll
    static void assertionsPrecisamEstarHabilitadas() {
        boolean habilitadas = false;
        assert habilitadas = true; // só executa (e atribui) se -ea estiver ativo
        assertTrue(habilitadas,
                "Assertions desabilitadas: sem -ea os testes passariam sem verificar nada. "
                        + "Adicione -ea em 'VM options' da configuração de execução.");
    }

    @Test
    void linkedList() {
        LinkedListAsserts.main(new String[0]);
    }

    @Test
    void fifoCache() {
        FIFOCacheAsserts.main(new String[0]);
    }
}
