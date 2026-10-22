# eda

Código das aulas de **Estruturas de Dados e Análise de Algoritmos (EDA)**, em Java.

## Estrutura

```
src/
├── main/java/eda/
│   ├── estruturas/   Fila, Pilha, LinkedList, ArrayList
│   ├── recursivos/   BuscaBinaria, BuscaLinearRecursiva, Fibonacci,
│   │                 PotenciaRecursividade, InsertionRecursivo, EncontraQuebra
│   ├── sort/         Sorting, Insertion, Selection, Merge, Quick, ...
│   └── analise/      VerificaDuplicados (leitura de amostras via stdin)
└── test/java/eda/
    └── estruturas/   LinkedListAsserts
template-intro-analise/   Projeto Gradle de análise empírica (scripts R/shell, dados)
```

## Como compilar e executar

```bash
mkdir -p out
javac -d out $(find src -name "*.java")
java -cp out eda.recursivos.Fibonacci
```

## Pendências conhecidas

- `sort/MergePassoPasso.java`: rascunho de counting/radix sort incompleto (não compila).
- `estruturas/ArrayList.java`: `remove(int index)` e `remove(int value)` têm a mesma assinatura.
