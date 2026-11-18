package eda.estruturas;

public class FIFOCacheAsserts {

    public static void main(String[] args) {

        // Cria um cache com capacidade máxima de 3 elementos.
        FIFOCache fifocache = new FIFOCache(3);

        // O cache está vazio, então ninguém precisa ser removido.
        assert fifocache.getNextEviction() == null;

        // Confirma que o cache começa com zero elementos.
        assert fifocache.size() == 0;

        // Adiciona "a" ao cache.
        // Como "a" ainda não existe, retorna miss.
        assert "miss".equals(fifocache.get("a"));

        // Ainda existe espaço no cache, então não há remoção.
        assert fifocache.getNextEviction() == null;

        // Agora existe um elemento no cache.
        assert fifocache.size() == 1;

        // "a" já existe no cache, então retorna hit.
        assert "hit".equals(fifocache.get("a"));

        // Consultar novamente não adiciona outro elemento.
        assert fifocache.size() == 1;


        // Adiciona "b", pois ainda não existe.
        assert "miss".equals(fifocache.get("b"));

        // O cache possui apenas dois elementos.
        // Ainda existe espaço disponível.
        assert fifocache.getNextEviction() == null;

        // Adiciona "c" ao cache.
        assert "miss".equals(fifocache.get("c"));

        // "b" já existe, então retorna hit.
        assert "hit".equals(fifocache.get("b"));

        // "c" também já existe, então retorna hit.
        assert "hit".equals(fifocache.get("c"));

        // O cache está cheio: a, b e c.
        assert fifocache.size() == 3;


        // Como o cache está cheio, o próximo a sair é "a".
        // Ele foi o primeiro elemento adicionado.
        assert fifocache.getNextEviction().equals("a");

        // Adiciona "d".
        // Como o cache está cheio, "a" precisa sair.
        assert "miss".equals(fifocache.get("d"));

        // Agora "b" é o elemento mais antigo.
        assert fifocache.getNextEviction().equals("b");


        // "a" foi removido anteriormente.
        // Portanto, sua nova consulta gera miss.
        // Como o cache está cheio, "b" será removido.
        assert "miss".equals(fifocache.get("a"));

        // Agora o cache contém c, d e a.
        // O mais antigo é "c".
        assert fifocache.getNextEviction().equals("c");

        // "b" saiu quando "a" entrou.
        // Portanto, consultar "b" gera miss.
        assert "miss".equals(fifocache.get("b"));

    }
}
