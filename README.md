# eda

Código das aulas de **Estruturas de Dados e Análise de Algoritmos (EDA)**, em Java.

## Estrutura

```
pom.xml                   Build Maven (Eclipse, IntelliJ, VS Code, NetBeans importam direto)
src/
├── main/java/eda/
│   ├── estruturas/   Fila, Pilha, LinkedList, ArrayList, TabelaHash, TabelaHashDois, FIFOCache
│   ├── recursivos/   BuscaBinaria, BuscaLinearRecursiva, Fibonacci,
│   │                 PotenciaRecursividade, InsertionRecursivo, EncontraQuebra
│   ├── sort/         Insertion, InsereUltimo, Selection, MergePassoPasso, Quick
│   ├── questoes/     InvertePilhaDois, OrdenaPilhaInvertendo, RemoveIndexLL,
│   │                 TrocaVizinhosLL, VerificaDuplicados
│   └── treino/       FIFOCacheTreino, HashTreino
└── test/java/eda/estruturas/
                      LinkedListAsserts, FIFOCacheAsserts, AssertsTest (JUnit)
template-intro-analise/   Projeto Gradle de análise empírica (scripts R/shell, dados)
```

## Requisitos

- **JDK 11 ou superior** (testado com 21). Para usar outra versão, altere
  `maven.compiler.release` no `pom.xml`.
- Nenhuma outra instalação é necessária para abrir na IDE: Eclipse e IntelliJ
  já trazem suporte a Maven.

## Abrindo na IDE

O projeto é um projeto Maven padrão (`src/main/java`, `src/test/java`). **Não há
arquivos de IDE versionados**: a própria IDE gera `.project`, `.classpath`,
`.idea/` etc. a partir do `pom.xml`.

**IntelliJ IDEA**
`File > Open…` → selecione o `pom.xml` (ou a pasta) → *Open as Project*.

**Eclipse**
`File > Import… > Maven > Existing Maven Projects` → selecione a pasta do
repositório → *Finish*.

**VS Code / NetBeans / outras**
Abra a pasta; com o *Extension Pack for Java* (VS Code) ou o suporte Maven nativo
(NetBeans) o `pom.xml` é reconhecido automaticamente.

Em qualquer IDE, para rodar uma classe: abra-a e use *Run* no método `main`.
Para testes, use *Run* em `AssertsTest` (ou na pasta `src/test/java`).

> **Importante:** as classes `*Asserts` usam a palavra-chave `assert`, que o Java
> só verifica com a opção `-ea`. O `AssertsTest` falha com uma mensagem clara se
> `-ea` estiver desligado. IntelliJ e Eclipse já ligam `-ea` nas execuções JUnit;
> se rodar um `main` direto, adicione `-ea` em *VM options*.

## Linha de comando

Com Maven:

```bash
mvn test                                                    # compila e roda os testes
mvn compile exec:java -Dexec.mainClass=eda.recursivos.Fibonacci
```

Sem Maven (só JDK):

```bash
mkdir -p out
javac -encoding UTF-8 -d out $(find src/main -name "*.java")
java -cp out eda.recursivos.Fibonacci

# testes baseados em assert (note o -ea)
javac -encoding UTF-8 -d out $(find src -name "*.java" -not -name "AssertsTest.java")
java -ea -cp out eda.estruturas.LinkedListAsserts
java -ea -cp out eda.estruturas.FIFOCacheAsserts
```

No Windows (PowerShell), troque o `$(find …)` por:
`javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src/main -Filter *.java).FullName`

## template-intro-analise

Projeto Gradle independente (abra essa pasta separadamente na IDE; IntelliJ e
Eclipse/Buildship importam Gradle nativamente):

```bash
cd template-intro-analise
gradle test
```
